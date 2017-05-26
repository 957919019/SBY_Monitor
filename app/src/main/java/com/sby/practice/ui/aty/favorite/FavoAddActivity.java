package com.sby.practice.ui.aty.favorite;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.sby.constant.Constant;
import com.sby.constant.GlobalVariable;
import com.sby.practice.R;
import com.sby.practice.adapter.FavoAddAdapter;
import com.sby.practice.ui.core.ActivityCollector;
import com.sby.practice.ui.core.BaseActivity;
import com.sby.utils.keyboardCtr.KeyboardUtils;
import com.sby.utils.Logger;
import com.sby.utils.SearchHistoryUtils;
import com.sby.widget.divider.DividerGridItemDecoration;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static com.sby.constant.Constant.HISTORY_MAX;

/**
 * 新增收藏
 */
public class FavoAddActivity extends BaseActivity implements OnGetSuggestionResultListener, OnGetPoiSearchResultListener
{

    @BindView(R.id.activity_favo_add_et_search)
    AutoCompleteTextView et_search;
    @BindView(R.id.activity_favo_add_tb_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.activity_favo_add_rv_list)
    RecyclerView rv_list;
    @BindView(R.id.activity_favo_add_tv_delAll)
    TextView tv_delAll;

    private Activity activity = FavoAddActivity.this;
    private SimpleDateFormat mFormat;
    private FavoAddAdapter mAdapter;
    private List<String> list;
    private int clickPosition; // 存储adapter单击的下标，在搜索一路已存在的时候， 先删除旧的数据，再更新适配器
    private int searchType = 0;  // 搜索的类型，在显示时区分
    private int loadIndex = 0; // 设置每页容量，默认为每页10条

    private SuggestionSearch mSuggestionSearch = null; // 搜索建议
    private PoiSearch mPoiSearch = null;
    private ArrayList<String> suggestList; // 搜索建议的结果集
    private ArrayAdapter<String> sugAdapter; //  显示搜索建议的适配器

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favo_add);
        ButterKnife.bind(this);

        initWidget();
        setAction();
    }

    /**
     * 初始化控件
     */
    private void initWidget()
    {
        //toolbar的控件
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); // Toolbar掉标题栏
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv_list.setHasFixedSize(true);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        rv_list.setItemAnimator(new DefaultItemAnimator());// 设置item动画
        rv_list.addItemDecoration(new DividerGridItemDecoration(this));

        // 初始化建议搜索模块，注册建议搜索事件监听
        mSuggestionSearch = SuggestionSearch.newInstance();
        mSuggestionSearch.setOnGetSuggestionResultListener(this);
        // 初始化搜索模块，注册搜索事件监听
        mPoiSearch = PoiSearch.newInstance();
        mPoiSearch.setOnGetPoiSearchResultListener(this);
        showSearchHistory();
    }

    /**
     * 从SP查询搜索历史，并按时间显示
     */
    private void showSearchHistory()
    {
        Map<String, String> hisAll = (Map<String, String>) SearchHistoryUtils.getAll(activity);
        //将key排序升序
        Object[] keys = hisAll.keySet().toArray();
        Arrays.sort(keys);
        int keyLeng = keys.length;
        //这里计算 如果历史记录条数是大于 可以显示的最大条数，则用最大条数做循环条件，防止历史记录条数-最大条数为负值，数组越界
        int hisLeng = keyLeng > HISTORY_MAX ? HISTORY_MAX : keyLeng;
        list = new ArrayList<>();
        for (int i = 1; i <= hisLeng; i++)
        {
            list.add(hisAll.get(keys[keyLeng - i]));
        }

        mAdapter = new FavoAddAdapter(activity, list);
        rv_list.setAdapter(mAdapter);
    }

    /**
     * 搜索框监听
     */
    private void setAction()
    {
        // 搜索
        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                String keyword = et_search.getText().toString().trim();
                if (actionId == EditorInfo.IME_ACTION_SEARCH && !"".equals(keyword) && keyword != null)
                {
                    KeyboardUtils.closeKeyboard(activity, et_search); // 先隐藏键盘
                    // 市内搜索，如果已有定位数据，使用已保存的，如果没有定位数据，则默认以北京为市搜索
                    if (GlobalVariable.getLOCATION() != null)
                    {
                        mPoiSearch.searchInCity((new PoiCitySearchOption()).city(GlobalVariable.getLOCATION()).keyword(keyword).pageNum(loadIndex));
                    } else
                    {
                        showToast("无法定位到当前城市，\n请确保开启定位权限提高搜索精确度。");
                        mPoiSearch.searchInCity((new PoiCitySearchOption()).city(Constant.BEIJINGSHI).keyword(keyword).pageNum(loadIndex));
                    }
                    // 将搜索记录保存到SP中
                    saveSearchHistory(keyword);
                    return true;
                }
                return false;
            }
        });
        // 文字变动监听
        et_search.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                // 输入的内容不可为空
                if (TextUtils.isEmpty(s))
                {
                    return;
                }
                // 使用建议搜索服务获取建议列表，结果在onGetSuggestionResult()中更新
                mSuggestionSearch
                        .requestSuggestion((new SuggestionSearchOption())
                                .keyword(s.toString()).city(""));
            }
        });
        // 适配器点击事件
        mAdapter.setOnItemClickListener(new FavoAddAdapter.FavoAddClick()
        {
            @Override
            public void onItemClick(View view, int position) // 单击事件
            {
                clickPosition = position;
                et_search.setText(list.get(position).toString());
                et_search.requestFocus();
                KeyboardUtils.openKeyboard(activity, et_search); // 显示键盘
                et_search.setSelection(list.get(position).toString().length()); // 将光标移动到最后
            }

            @Override
            public void onDelClick(View view, int position) // 删除
            {
                // 获取map中value对应的key，然后删除key对应的某条数据
                String key = SearchHistoryUtils.valueGetKey(SearchHistoryUtils.getAll(activity), list.get(position).toString());
                SearchHistoryUtils.remove(activity, key);
            }
        });
        // 清空
        tv_delAll.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                clearsearchHistory();
                mAdapter.remoceAll();
            }
        });
    }

    /**
     * 标题栏动作
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                ActivityCollector.removeActivity(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mPoiSearch.destroy();
        mSuggestionSearch.destroy();
    }

    /**
     * 将历史记录保存至sp中，key=当前时间(20160302133455，便于排序) ，value=关键字
     *
     * @param keyWords
     */
    private void saveSearchHistory(String keyWords)
    {
        //保存之前要先查询sp中是否有该value的记录，有则删除.这样保证搜索历史记录不会有重复条目
        Map<String, String> historys = (Map<String, String>) SearchHistoryUtils.getAll(activity);
        for (Map.Entry<String, String> entry : historys.entrySet())
        {
            if (keyWords.equals(entry.getValue()))
            {
                SearchHistoryUtils.remove(activity, entry.getKey());
                list.remove(clickPosition); // 删除旧搜索历史
            }
        }
        mFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        // 以时间为key，保存搜索记录
        SearchHistoryUtils.put(activity, "" + mFormat.format(new Date()), keyWords);
        mAdapter.add(et_search.getText().toString(), 0); //添加新搜索历史
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 清除历史记录
     */
    private void clearsearchHistory()
    {
        SearchHistoryUtils.clear(this);
        //同时刷新历史记录显示页面
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 删除多余的历史记录
     * 如果历史记录数量大于限定数量(10条)，则按key升序排序，删除前几条
     */
    private void delMoreSearchHistory()
    {

        Map<String, String> hisAll = (Map<String, String>) SearchHistoryUtils.getAll(this);
        if (hisAll.size() > HISTORY_MAX)
        {
            //将key排序升序
            Object[] keys = hisAll.keySet().toArray();
            Arrays.sort(keys);
            // LENGTH = 12 , MAX = 10 , I = 1,0,count =2;
            for (int i = keys.length - HISTORY_MAX - 1; i > -1; i--)
            {
                SearchHistoryUtils.remove(this, (String) keys[i]);
            }
        }
    }

    /**
     * 获取在线建议搜索结果，得到requestSuggestion返回的搜索结果
     */
    @Override
    public void onGetSuggestionResult(SuggestionResult res)
    {
        if (res == null || res.getAllSuggestions() == null) // 不能为空
        {
            return;
        }
        suggestList = new ArrayList<>();
        for (SuggestionResult.SuggestionInfo info : res.getAllSuggestions())
        {
            if (info.key != null)
            {
                suggestList.add(info.key);
            }
        }
        sugAdapter = new ArrayAdapter<>(activity, R.layout.item_favo_add_suggess, suggestList);
        et_search.setAdapter(sugAdapter);
        sugAdapter.notifyDataSetChanged();
    }

    /**
     * 获取POI搜索结果，包括searchInCity，searchNearby，searchInBound返回的搜索结果
     */
    @Override
    public void onGetPoiResult(PoiResult result)
    {
        Logger.w("onGetPoiResult", "1进入了回调");
        if (result == null || result.error == SearchResult.ERRORNO.RESULT_NOT_FOUND)
        {
            Logger.w("1_1", "未找到结果");
            return;
        }
        if (result.error == SearchResult.ERRORNO.NO_ERROR)
        {
            startActivity(new Intent(activity, FavoSearchResultActivity.class).setFlags(FLAG_ACTIVITY_NEW_TASK)
                            .putExtra("result", (Serializable) result.getAllPoi()),
                    ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
            return;
        }

        // 当输入关键字在本市没有找到，但在其他城市找到时，返回包含该关键字信息的城市列表
        if (result.error == SearchResult.ERRORNO.AMBIGUOUS_KEYWORD)
        {
            String strInfo = "在多个地区：\n";
            for (CityInfo cityInfo : result.getSuggestCityList())
            {
                strInfo += cityInfo.city;
                strInfo += "\n";
            }
            strInfo += "\n找到结果,建议重新搜索更详细的地址！";
            showToast(strInfo);
        } else
        {
            showToast("搜索超时，请检查网络");
        }
    }

    @Override
    public void onGetPoiDetailResult(PoiDetailResult result)
    {
        Logger.w("2onGetPoiDetailResult", "进入了2");
        if (result.error != SearchResult.ERRORNO.NO_ERROR)
        {
            Logger.w("2_1", "NO_ERROR");
        } else
        {
            Logger.w("2_2", result.getName() + ": " + result.getAddress());
        }
    }

    @Override
    public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult)
    {
        Logger.w("3_Indoor", "进入了3");
    }

}
