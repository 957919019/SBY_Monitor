package com.sby.practice.ui.aty.otherservice;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.sby.application.MyMapApplication;
import com.sby.bean.flt.JiChang;
import com.sby.bean.other.BasePlan;
import com.sby.bean.other.JiHuaShenQing;
import com.sby.constant.Constant;
import com.sby.practice.R;
import com.sby.practice.adapter.JiChangAdapter;
import com.sby.utils.DateUtils;
import com.sby.utils.FormatUtils;
import com.sby.utils.ToastUtil;
import com.sby.widget.popupWindow.CalendarSelector;

import java.io.IOException;
import java.util.ArrayList;
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

public class HuLinActivity extends AppCompatActivity
{

    @BindView(R.id.tv_fltTime)
    TextView tv_fltTime;
    @BindView(R.id.tv_startTime)
    TextView tv_startTime;
    @BindView(R.id.tv_endTime)
    TextView tv_endTime;
    @BindView(R.id.sp_qfJC)
    Spinner sp_qfJC;
    @BindView(R.id.sp_jlJC)
    Spinner sp_jlJC;
    @BindView(R.id.sp_bjJC)
    Spinner sp_bjJC;
    @BindView(R.id.sp_JX)
    Spinner sp_JX;
    @BindView(R.id.sp_JH)
    Spinner sp_JH;
    @BindView(R.id.sp_JZ)
    Spinner sp_JZ;
    @BindView(R.id.et_jhbh)
    EditText et_jhbh;
    @BindView(R.id.et_gcy)
    EditText et_gcy;
    @BindView(R.id.et_kqrs)
    EditText et_kqrs;
    @BindView(R.id.et_dqrs)
    EditText et_dqrs;
    @BindView(R.id.et_fltYD)
    EditText et_fltYD;
    @BindView(R.id.et_lingAndHeight)
    EditText et_lingAndHeight;
    @BindView(R.id.et_hxYingDa)
    EditText et_hxYingDa;
    @BindView(R.id.et_kyMsg)
    EditText et_kyMsg;
    @BindView(R.id.sp_fxDanWei)
    Spinner sp_fxDanWei;
    @BindView(R.id.et_lianxiren)
    EditText et_lianxiren;
    @BindView(R.id.et_phone)
    EditText et_phone;
    @BindView(R.id.et_remark)
    EditText et_remark;
    @BindView(R.id.jh_commit)
    Button jh_commit;

    private Activity activity = HuLinActivity.this;
    private JiChangAdapter qifeiAdapter;
    private JiChangAdapter jlAdapter;
    private JiChangAdapter bjAdapter;
    private JiChangAdapter jixing;
    private JiChangAdapter jihaoAdapter;
    private JiChangAdapter jizhangAdapter;
    private JiChangAdapter feixingdanwei;
    private String qfId;
    private String jlId;
    private String bjID;
    private String jiHaoId;
    private String jzName;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hu_lin);
        ButterKnife.bind(this);
        initWidget();
        initWidget2();
    }


    private void initWidget()
    {
        List<JiChang> jcList = new ArrayList<>();
        JiChang jc1 = new JiChang();
        jc1.setId(7951 + "");
        jc1.setjCName("阿尔山机场");
        jcList.add(jc1);
        JiChang jc2 = new JiChang();
        jc2.setId(8555 + "");
        jc2.setjCName("喀纳斯机场");
        jcList.add(jc2);
        JiChang jc3 = new JiChang();
        jc3.setId(8556 + "");
        jc3.setjCName("布尔津临时起降点");
        jcList.add(jc3);
        JiChang jc4 = new JiChang();
        jc4.setId(8596 + "");
        jc4.setjCName("沙湾县临时起降点");
        jcList.add(jc4);
        JiChang jc5 = new JiChang();
        jc5.setId(8607 + "");
        jc5.setjCName("可可托海镇");
        jcList.add(jc5);
        qifeiAdapter = new JiChangAdapter(activity, jcList);
        qifeiAdapter.setDropDownViewResource(R.layout.hulin_spinner_dropitem);
        sp_qfJC.setAdapter(qifeiAdapter);
        sp_qfJC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                qfId = qifeiAdapter.getItem(position).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
        jlAdapter = new JiChangAdapter(activity, jcList);
        jlAdapter.setDropDownViewResource(R.layout.hulin_spinner_dropitem);
        sp_jlJC.setAdapter(jlAdapter);
        sp_jlJC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                jlId = jlAdapter.getItem(position).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
        bjAdapter = new JiChangAdapter(activity, jcList);
        bjAdapter.setDropDownViewResource(R.layout.hulin_spinner_dropitem);

        sp_bjJC.setAdapter(bjAdapter);
        sp_bjJC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                bjID = bjAdapter.getItem(position).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

    }

    private void initWidget2()
    {
        List<JiChang> jixings = new ArrayList<>();
        jixings.add(new JiChang("1", "N-5A"));
        jixings.add(new JiChang("2", "Y-5"));
        jixings.add(new JiChang("1337", "GA-200"));
        jixing = new JiChangAdapter(this, jixings);
        jixing.setDropDownViewResource(R.layout.hulin_spinner_dropitem);
        sp_JX.setAdapter(jixing);

        sp_JX.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                // TODO: 2017/5/21
                List<JiChang> jihaos = new ArrayList<>();
                jihaoAdapter = new JiChangAdapter(HuLinActivity.this, jihaos);
                jihaoAdapter.setDropDownViewResource(R.layout.hulin_spinner_dropitem);
                sp_JH.setAdapter(jihaoAdapter);
                sp_JH.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                    {
                        jiHaoId = jihaoAdapter.getItem(position).getId();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent)
                    {

                    }
                });
                jihaos.clear();

                switch (position)
                {
                    case 0:
                        List<JiChang> jihaos1 = new ArrayList<>();
                        jihaos1.add(new JiChang("11170", "aaaaa"));
                        jihaos.addAll(jihaos1);
                        jihaoAdapter.notifyDataSetChanged();
                        break;
                    case 1:
                        List<JiChang> jihaos2 = new ArrayList<>();
                        jihaos2.add(new JiChang("1", "B8615"));
                        jihaos2.add(new JiChang("2", "B8619"));
                        jihaos.addAll(jihaos2);
                        jihaoAdapter.notifyDataSetChanged();
                        break;
                    case 2:

                        List<JiChang> jihaos3 = new ArrayList<>();
                        jihaos3.add(new JiChang("3759", "B50AD"));
                        jihaos3.add(new JiChang("3444", "B8790"));
                        jihaos3.add(new JiChang("3760", "B8001"));
                        jihaos3.add(new JiChang("3753", "B8067"));
                        jihaos.addAll(jihaos3);
                        jihaoAdapter.notifyDataSetChanged();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });


        List<JiChang> jiZhangs = new ArrayList<>();
        jiZhangs.add(new JiChang("3356", "Brown Matthew Michael"));
        jiZhangs.add(new JiChang("2382", "周平生"));
        jiZhangs.add(new JiChang("2384", "任诚实"));
        jiZhangs.add(new JiChang("2385", "王广领"));
        jiZhangs.add(new JiChang("2393", "赵  军"));

        jizhangAdapter = new JiChangAdapter(this, jiZhangs);
        jizhangAdapter.setDropDownViewResource(R.layout.hulin_spinner_dropitem);
        sp_JZ.setAdapter(jizhangAdapter);

        sp_JZ.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                jzName = bjAdapter.getItem(position).getjCName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        List<JiChang> fxdws = new ArrayList<>();
        fxdws.add(new JiChang("1277", "海南亚太通用航空公司"));
        fxdws.add(new JiChang("1274", "石家庄冀华通用航空公司"));
        fxdws.add(new JiChang("1276", "荆门通用航空公司"));
        fxdws.add(new JiChang("1306", "呼伦贝尔天鹰通用航空有限责任公司"));
        fxdws.add(new JiChang("1307", "齐齐哈尔鹤翔通用航空有限责任公司"));
        feixingdanwei = new JiChangAdapter(this, fxdws);
        feixingdanwei.setDropDownViewResource(R.layout.hulin_spinner_dropitem);
        sp_fxDanWei.setAdapter(feixingdanwei);

        sp_fxDanWei.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

    }


    @OnClick({R.id.tv_fltTime, R.id.tv_startTime, R.id.tv_endTime, R.id.jh_commit})
    public void onViewClicked(View view)
    {
        switch (view.getId())
        {
            case R.id.tv_fltTime:
                new CalendarSelector(activity).showPop(view).setOnMediaClick(new CalendarSelector.OnMediaClick()
                {
                    @Override
                    public void onFinish(String data)
                    {
                        Date startTime = DateUtils.StrToDate(data); // 获取选择的值
                        // 比较选取的时间与本地时间(选取时间不得大于系统时间)
                        if (DateUtils.compareWithSyatemDate(startTime))
                        {
                            tv_fltTime.setText(data);
                        } else
                        {
                            ToastUtil.topToast(activity, getString(R.string.re_choose_time_please));
                            tv_fltTime.setText("");
                        }
                    }
                });
                break;
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
            case R.id.jh_commit:
                String empCode = MyMapApplication.user.getEmpCode();

                BasePlan basePlan = new BasePlan();
                basePlan.setFlightTypeId(8);
                basePlan.setDepartureDate(new Date(System.currentTimeMillis()));
                basePlan.setTakeOffAirportId(FormatUtils.strToInt(qfId));
                basePlan.setLandingAirportId(FormatUtils.strToInt(jlId));
                basePlan.setAllPilots(jzName);

                JiHuaShenQing ji = new JiHuaShenQing();
                ji.setUserName(empCode);
                ji.setBasePlan(basePlan);


                OkHttpClient client = new OkHttpClient();
                RequestBody body = RequestBody.create(MediaType.parse("application/json"), JSONObject.toJSONString(ji));
                Request requestPostFile = new Request.Builder().url(Constant.uri + "createPlan").post(body).build();
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
                        runOnUiThread(new Runnable()
                        {
                            @Override
                            public void run()
                            {

                                try
                                {
                                    String s = response.toString();
                                    if (s != null)
                                    {
                                        ToastUtil.topToast(activity, "提交成功！");
                                    }

                                } catch (Exception e)
                                {
                                    e.printStackTrace();
                                }


                            }
                        });
                    }
                });

        }
    }

}
