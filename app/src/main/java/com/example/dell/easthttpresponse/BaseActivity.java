package com.example.dell.easthttpresponse;

import android.app.ProgressDialog;
import android.widget.Toast;

import com.example.dell.easthttpresponse.http.model.HttpData;
import com.hjq.http.listener.OnHttpListener;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/EasyHttp
 *    time   : 2019/05/19
 *    desc   : 基类封装
 */
public class BaseActivity extends AppCompatActivity implements OnHttpListener {

    /** 加载对话框 */
    private ProgressDialog mDialog;
    /** 对话框数量 */
    private int mDialogTotal;

    /**
     * 当前加载对话框是否在显示中
     */
    public boolean isShowDialog() {
        return mDialog != null && mDialog.isShowing();
    }

    /**
     * 显示加载对话框
     */
    public void showDialog() {
        if (mDialog == null) {
            mDialog = new ProgressDialog(this);
            mDialog.setMessage(getResources().getString(R.string.http_loading));
            mDialog.setCancelable(false);
            mDialog.setCanceledOnTouchOutside(false);
        }
        if (!mDialog.isShowing()) {
            mDialog.show();
        }
        mDialogTotal++;
    }

    /**
     * 隐藏加载对话框
     */
    public void hideDialog() {
        if (mDialogTotal == 1) {
            if (mDialog != null && mDialog.isShowing()) {
                mDialog.dismiss();
            }
        }
        if (mDialogTotal > 0) {
            mDialogTotal--;
        }
    }

    @Override
    public void onStart(Call call) {
        showDialog();
    }

    @Override
    public void onSucceed(Object result) {
        if (result instanceof HttpData) {
            Toast.makeText(this, ((HttpData) result).getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFail(Exception e) {
        Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEnd(Call call) {
        hideDialog();
    }
}