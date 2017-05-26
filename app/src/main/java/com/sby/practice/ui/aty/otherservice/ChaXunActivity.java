package com.sby.practice.ui.aty.otherservice;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.sby.bean.other.ChaXun;
import com.sby.constant.Constant;
import com.sby.practice.R;
import com.sby.utils.DateUtils;
import com.sby.utils.ToastUtil;
import com.sby.widget.popupWindow.CalendarSelector;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChaXunActivity extends AppCompatActivity
{

    @BindView(R.id.tv_startTime)
    TextView tv_startTime;
    @BindView(R.id.tv_endTime)
    TextView tv_endTime;
    @BindView(R.id.bt_select)
    Button bt_select;
    @BindView(R.id.rv_list)
    RecyclerView rv_list;

    private Activity activity = ChaXunActivity.this;
    private ChaXunAdapter axAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cha_xun);
        ButterKnife.bind(this);
        initWidget();
    }

    private void initWidget()
    {
        rv_list.setHasFixedSize(true);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        rv_list.setItemAnimator(new DefaultItemAnimator());// 设置item动画
    }

    @OnClick({R.id.tv_startTime, R.id.tv_endTime, R.id.bt_select})
    public void onViewClicked(View view)
    {
        switch (view.getId())
        {
            case R.id.tv_startTime:
                new CalendarSelector(activity).showPop(view).setOnMediaClick(new CalendarSelector.OnMediaClick()
                {
                    @Override
                    public void onFinish(String data)
                    {
                        Date startTime = DateUtils.StrToDate(data); // 获取选择的值
                        // 比较选取的时间与本地时间(选取时间不得大于系统时间)
                        if (DateUtils.compareWithSyatemDate(startTime))
                        {
                            tv_startTime.setText(data);
                        } else
                        {
                            ToastUtil.topToast(activity, getString(R.string.re_choose_time_please));
                            tv_startTime.setText("");
                        }
                    }
                });
                break;
            case R.id.tv_endTime:
                new CalendarSelector(activity).showPop(view).setOnMediaClick(new CalendarSelector.OnMediaClick()
                {
                    @Override
                    public void onFinish(String data)
                    {
                        Date startTime = DateUtils.StrToDate(data); // 获取选择的值
                        // 比较选取的时间与本地时间(选取时间不得大于系统时间)
                        if (DateUtils.compareWithSyatemDate(startTime))
                        {
                            tv_endTime.setText(data);
                        } else
                        {
                            ToastUtil.topToast(activity, getString(R.string.re_choose_time_please));
                            tv_endTime.setText("");
                        }
                    }
                });
                break;
            case R.id.bt_select:
                OkHttpClient client = new OkHttpClient();
                RequestBody body = RequestBody.create(MediaType.parse("application/json"), "");
                Request requestPostFile = new Request.Builder().url(Constant.uri + "selectPlan").post(body).build();
                client.newCall(requestPostFile).enqueue(new Callback()
                {
                    @Override
                    public void onFailure(Call call, IOException e)
                    {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException
                    {
                        if (response.code() != 200)
                        {
                            runOnUiThread(new Runnable()
                            {
                                @Override
                                public void run()
                                {
                                    try
                                    {
                                        ToastUtil.topToast(activity, "查询数据失败\n请稍后重试");
                                    } catch (Exception e)
                                    {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            return;
                        }
                        String str = response.body().string();

                        final ChaXun aa = JSON.parseObject(str, ChaXun.class);
                        if ("success".equals(aa.getState()))
                        {
                            runOnUiThread(new Runnable()
                            {
                                @Override
                                public void run()
                                {
                                    try
                                    {
                                        if (aa.getData() != null)
                                        {
                                            setWidget(aa.getData());
                                        } else
                                        {
                                            ToastUtil.topToast(activity, "数据为空");
                                        }
                                    } catch (Exception e)
                                    {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        } else
                        {
                            ToastUtil.topToast(activity, "查询数据失败\n请稍后重试");
                        }
                    }
                });
                break;
        }
    }

    private void setWidget(List<ChaXun.DataBean> data)
    {
        axAdapter = new ChaXunAdapter(activity, data);
        rv_list.setAdapter(axAdapter);
    }

}
