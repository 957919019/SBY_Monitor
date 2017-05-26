package com.sby.practice.ui.aty;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sby.practice.R;

import butterknife.ButterKnife;

/**
 * 测试
 */
public class TestActivity extends AppCompatActivity
{
    private Activity activity = TestActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

    }



}
