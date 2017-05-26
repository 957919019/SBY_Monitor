package com.sby.practice.ui.aty.options;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.sby.practice.R;
import com.sby.practice.ui.core.ActivityCollector;
import com.sby.practice.ui.core.BaseActivity;

/**
 * 反馈
 */
public class Feedback extends BaseActivity
{

    private Toolbar mToolbar;
    private EditText et_content;
    private Button bt_submit;

    private Activity activity = Feedback.this;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        initWeiget();
        setAction();
    }

    /**
     * 初始化控件
     */
    private void initWeiget()
    {
        mToolbar = (Toolbar) findViewById(R.id.activity_feedback_tb_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //去掉标题栏
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_content = (EditText)findViewById(R.id.activity_feedback_et_content);
        bt_submit = (Button)findViewById(R.id.activity_feedback_bt_submit);
    }

    private void setAction()
    {
        et_content.addTextChangedListener(new TextWatcher()
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
                if( "".equals(s.toString()) || s.toString() == null )
                {
                    bt_submit.setClickable(false);
                    bt_submit.setBackgroundColor(Color.GRAY);
                } else
                {
                    bt_submit.setClickable(true);
                    bt_submit.setBackground(getDrawable(R.drawable.home_bt_selector));
                }
            }
        });
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
