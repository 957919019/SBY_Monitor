package com.sby.practice.ui.aty.options;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;
import com.sby.practice.R;
import com.sby.practice.ui.core.ActivityCollector;
import com.sby.practice.ui.core.BaseActivity;
import com.sby.utils.PhoneUtils;

import java.util.List;

/**
 * 帮助
 */
public class Help extends BaseActivity implements View.OnClickListener
{
    private Toolbar mToolbar;
    private Button bt_connect;

    private Activity activity = Help.this;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        initWeiget();
    }

    /**
     * 初始化控件
     */
    private void initWeiget()
    {
        mToolbar = (Toolbar) findViewById(R.id.activity_help_tb_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //去掉标题栏
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bt_connect = (Button) findViewById(R.id.activity_help_bt_connect);
        bt_connect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.activity_help_bt_connect:
                if( PhoneUtils.isTablet(activity) != true) // 如果不是平板
                {
                    Acp.getInstance(this).request(new AcpOptions.Builder().setPermissions(Manifest.permission.CALL_PHONE).build(),
                            new AcpListener()
                            {
                                @Override
                                public void onGranted()
                                {
                                    Intent intent = new Intent();
                                    intent.setAction(Intent.ACTION_CALL);
                                    intent.setData(Uri.parse("tel:" + getResources().getString(R.string.customer_service_telephone_numbers)));
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                }

                                @Override
                                public void onDenied(List<String> permissions)
                                {
                                    showToast( permissions.toString() + "权限被拒绝,请在设备权限管理开启相关权限！");
                                }
                            });
                } else
                {
                    showToast( "此功能仅限手机使用");
                }
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
