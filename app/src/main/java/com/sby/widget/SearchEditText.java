package com.sby.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import com.sby.practice.R;

/**
 * 实现一个常见的EditText，EditText前面是一个搜索图标
 * 如果EditText不为空，右边则会有一个删除图标，点击删除图标将清除EditText的内容
 */
public class SearchEditText extends EditText
{
    private Drawable mDrawableRight;

    public SearchEditText(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setDrawable(0);
        mDrawableRight = getResources().getDrawable(R.mipmap.clear_all_text);
        this.addTextChangedListener(new TextWatcher()
        {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                //文本改变的时候调用
                if (s.length() > 0)
                {
                    setDrawable(R.mipmap.clear_all_text);
                } else
                {
                    setDrawable(0);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after)
            {
                //文本改变之前调用
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                //文本改变之后调用
            }
        });
    }

    // 设置EditText左右上下的图标
    @SuppressLint("NewApi")
    private void setDrawable(int id)
    {
        this.setCompoundDrawablesRelativeWithIntrinsicBounds(R.mipmap.search_bar_icon_normal, 0, id, 0);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        // 设置删除图形的点击事件
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            float x = event.getX();
            if (x > this.getWidth() - mDrawableRight.getIntrinsicWidth() - this.getPaddingRight() && x < this.getWidth() - this.getPaddingRight())
            {
                this.setText("");
            }
        }
        return super.onTouchEvent(event);
    }


}
