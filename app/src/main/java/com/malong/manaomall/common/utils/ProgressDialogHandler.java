package com.malong.manaomall.common.utils;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;


import com.malong.manaomall.R;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Malong
 * on 18/6/26.
 * 封装统一的dialog请求加载ui
 */
public class ProgressDialogHandler extends Handler {


    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 0;

    private SweetAlertDialog mProgressDialog;

    private Context context;
    private boolean cancelable;
    private OnProgressCancelListener mProgressCancelListener;

    public ProgressDialogHandler(Context context){
        this(context,false,null);
    }

    public ProgressDialogHandler(Context context,
                                 boolean cancelable,OnProgressCancelListener progressCancelListener) {
        super();
        this.context = context;
        this.mProgressCancelListener = progressCancelListener;
        this.cancelable = cancelable;

        initProgressDialog();
    }

//    private void initProgressDialog(){
//        if (mProgressDialog == null) {
//            mProgressDialog = new ProgressDialog(context);
//            mProgressDialog.setMessage(context.getResources().getString(R.string.loading));
//
//            mProgressDialog.setCancelable(cancelable);
//
//            if (cancelable) {
//
//                mProgressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "关闭", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//
//                        if(mProgressCancelListener !=null)
//                            mProgressCancelListener.onCancelProgress();
//                    }
//                });
//
//
//            }
//
//
//        }
//    }


    private void initProgressDialog(){

        if(mProgressDialog ==null){

            mProgressDialog = new SweetAlertDialog(context,SweetAlertDialog.PROGRESS_TYPE);
            mProgressDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            mProgressDialog.setTitleText(context.getResources().getString(R.string.loading));

            if(cancelable){

                mProgressDialog.setCancelText(context.getResources().getString(R.string.close));
                mProgressDialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.cancel();
                        if(mProgressCancelListener !=null){
                            mProgressCancelListener.onCancelProgress();
                        }
                    }
                });
            }
        }
    }

    public void showProgressDialog(){

        if(mProgressDialog != null && !mProgressDialog.isShowing()){
            mProgressDialog.show();
        }
    }

    public void dismissProgressDialog(){
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                showProgressDialog();
                break;
            case DISMISS_PROGRESS_DIALOG:
                dismissProgressDialog();
                break;
        }
    }


    public interface OnProgressCancelListener{

        void onCancelProgress();
    }
}