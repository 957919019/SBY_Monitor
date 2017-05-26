//package com.sby.widget;
//
//import android.content.Context;
//import android.content.res.ColorStateList;
//import android.content.res.Resources;
//import android.util.AttributeSet;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.sby.practice.R;
//
///**
// * Created by kowal on 2017/4/18.
// */
//
//public class AreaView extends RelativeLayout
//{
//
//    private View view;
//    private ImageView iv_content;
//    private TextView tv_content;
//    private Context content;
//
//    public AreaView(Context context) {
//        super(context);
//        content = context;
//        initView(context);
//    }
//
//    public AreaView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        content = context;
//        initView(context);
//    }
//
//    public AreaView(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//        content = context;
//        initView(context);
//    }
//
//    private void initView(Context context) {
//        view = View.inflate(context, R.layout.iconbutton, this);
//        iv_content = (ImageView) view
//                .findViewById(R.id.iconbutton_imageView_content);
//        tv_content = (TextView) view
//                .findViewById(R.id.iconbutton_textview_content);
//
//    }
//
//    /**
//     * 给自定义控件设置值
//     *
//     * @param iv
//     *            图片
//     * @param tv
//     *            文字
//     */
//    public void onSetViewData(int iv, String tv) {
//        iv_content.setBackgroundResource(iv);
//        tv_content.setText(tv);
//    }
//
//    /**
//     * 给自定义控件设置值
//     *
//     * @param iv
//     *            图片
//     * @param tv
//     *            文字
//     * @param tv_color
//     *            文字颜色
//     */
//    public void onSetViewData(int iv, int tv, int tv_color) {
//        Resources resource = (Resources) content.getResources();
//        iv_content.setBackgroundResource(iv);
//        tv_content.setText(tv);
//        tv_content.setTextColor((ColorStateList) resource.getColorStateList(tv_color));
//    }
//
//}
