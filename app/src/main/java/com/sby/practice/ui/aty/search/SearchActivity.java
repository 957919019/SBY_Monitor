package com.sby.practice.ui.aty.search;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.sby.practice.R;
import com.sby.practice.adapter.SearchResultAdapter;
import com.sby.practice.ui.core.ActivityCollector;
import com.sby.practice.ui.core.BaseActivity;
import com.sby.utils.ToastUtil;
import com.sby.utils.keyboardCtr.KeyboardUtils;
import com.sby.widget.EditTextWithClear;
import com.sby.widget.divider.DividerGridItemDecoration;
import com.sby.widget.popupWindow.PopSearchType;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 搜索界面
 */
public class SearchActivity extends BaseActivity implements EditText.OnEditorActionListener
{

    @BindView(R.id.tv_type)
    TextView tv_type;
    @BindView(R.id.et_input_search)
    EditTextWithClear et_search;
    @BindView(R.id.tb_toolbar)
    Toolbar tb_toolbar;
    @BindView(R.id.rv_list)
    RecyclerView rv_list;

    private Activity activity = SearchActivity.this;
    private PopSearchType type;
    private int searchType; // 搜索类型
    private SearchResultAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        initWidget();
    }

    /**
     * 搜索结果集
     */
    private void initWidget()
    {
        setSupportActionBar(tb_toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //去掉标题栏
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv_list.setHasFixedSize(true);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        rv_list.setItemAnimator(new DefaultItemAnimator());// 设置item动画
        rv_list.addItemDecoration(new DividerGridItemDecoration(this));


    }

    /**
     * 单击事件
     *
     * @param view
     */
    @OnClick({  R.id.tv_type})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.tv_type:
                type = new PopSearchType(activity);
                type.showPopup(tv_type);
                type.setOnClickFlagListener(new PopSearchType.OnClickFlagListener()
                {
                    @Override
                    public void getFlag(int flag)
                    {
                        type.dismiss();
                        ChangeText(flag);
                    }
                });
                break;
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
    {
        String keyword = et_search.getText().toString().trim();
        if (actionId == EditorInfo.IME_ACTION_SEARCH && !TextUtils.isEmpty(keyword) && keyword != null)
        {
            KeyboardUtils.closeKeyboard(activity, et_search); // 先隐藏键盘
            ToastUtil.topToast(activity,"搜索的内容是：" + tv_type.getText().toString() + "下标：" + searchType + keyword);
//            startActivity(new Intent(activity, SearchResultActivity.class).putExtra("keywords", keyword).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK),
//                    ActivityOptions.makeSceneTransitionAnimation(activity).toBundle());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 10; i++)
            {
                list.add("第" + i + "架飞机");
            }
            mAdapter = new SearchResultAdapter(activity, list);
            rv_list.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();

            mAdapter.setOnItemClickLitener(new SearchResultAdapter.SearchResultClick()
            {
                @Override
                public void onItemClick(View view, int position)
                {
                    showToast("当前点击了第---" + position + "架") ;
                    //                startActivity(new Intent(activity, MainActivity.class).putExtra("latutd", "asda").addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                }
            });
        }
        return true;
    }

    /**
     * 响应选择搜索类型后的文字改变
     * @param flag
     */
    private void ChangeText(int flag)
    {
        searchType = flag;
        switch (flag)
        {
            case 0:
                tv_type.setText("全部");
                break;
            case 1:
                tv_type.setText("飞机编号");
                break;
            case 2:
                tv_type.setText("公司名称");
                break;
            case 3:
                tv_type.setText("飞机型号");
                break;
        }
    }

    /**
     * 标题栏动作
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                ActivityCollector.removeActivity(activity);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }
}
