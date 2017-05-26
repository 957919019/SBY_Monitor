package com.sby.widget.popupWindow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

import com.sby.practice.R;

/**
 * 联系客服
 *
 * @author kowal
 */
public class ConnectToService implements OnClickListener
{
    public PopupWindow mPopupWindow;
    private Button bt_ok, bt_cancle;
    private Context mContext;

    private OnClickFlagDialogListener onClickFlagDialogListener;

    public PopupWindow getmPopupWindow()
    {
        return mPopupWindow;
    }

    public ConnectToService(Context context)
    {
        mContext = context;

        mPopupWindow = new PopupWindow(context);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        mPopupWindow.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setAnimationStyle(R.style.bottom_to_top);
        mPopupWindow.setContentView(initViews());

        mPopupWindow.getContentView().setOnTouchListener(new OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                mPopupWindow.setFocusable(false);
                mPopupWindow.dismiss();
                return true;
            }
        });

    }

    public View initViews()
    {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.dialog_connect_to_service, null);
        bt_ok = (Button) view.findViewById(R.id.dialog_connect_to_service_bt_ok);
        bt_ok.setOnClickListener(this);
        bt_cancle = (Button) view.findViewById(R.id.dialog_connect_to_service_bt_cancle);
        bt_cancle.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.dialog_connect_to_service_bt_ok:
                onClickFlagDialogListener.getFlag(0);
                break;
            case R.id.dialog_connect_to_service_bt_cancle:
                mPopupWindow.dismiss();
                break;

            default:
                break;
        }
    }

    public interface OnCancelClickListener
    {
        void onCancel(View view);

    }

    public interface OnClickFlagDialogListener
    {
        void getFlag(int flag);
    }

    public void setOnClickFlagDialogListener(
            OnClickFlagDialogListener onClickFlagDialogListener)
    {
        this.onClickFlagDialogListener = onClickFlagDialogListener;
    }

    public void dismiss()
    {
        if (mPopupWindow != null && mPopupWindow.isShowing())
        {
            mPopupWindow.dismiss();
        }
    }

    public void showPopup(View rootView)
    {
        // 第一个参数是要将PopupWindow放到的View，第二个参数是位置，第三第四是偏移值
        mPopupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);
    }

}
