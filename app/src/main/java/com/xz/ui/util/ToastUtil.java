package com.xz.ui.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.widget.Toast;


/**
 * @author xz
 * 单例
 */
public class ToastUtil {

    private Toast sToast;

    private long sOneTime = 0L;
    /**
     * 上一次需要发送的消息
     */
    private String sOldmsg;

    /**
     * 上下文对象
     */
    private Context mContext;

    private Handler handler;


    private ToastUtil() {
        handler = new Handler(Looper.getMainLooper());
    }

    public static ToastUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static final class SingletonHolder {
        private static final ToastUtil INSTANCE = new ToastUtil();
    }

    public static void init(@NonNull Context context) {
        // 初始化Context
        getInstance().mContext = context;
    }

    private void toast(String str) {
        if (mContext == null) {
            throw new RuntimeException("Please init the Context before showToast");
        }
        if (sToast == null) {
            sToast = Toast.makeText(mContext, str, Toast.LENGTH_SHORT);
//            View toastlayout = LayoutInflater.from(App.sAppContext).inflate(R.layout.view_layout_toast, null);
//            sToastTv = toastlayout.findViewById(R.id.lt_tv);
//            //toast显示在屏幕中间
//            sToast.setGravity(Gravity.CENTER, 0, 200);
//            sToast.setView(toastlayout);
        }
        long sTwoTime = System.currentTimeMillis();
        if (TextUtils.equals(sOldmsg, str)) {
            if (sTwoTime - sOneTime > Toast.LENGTH_SHORT) {
                sToast.setText(str);
                sToast.show();
            }
        } else {
            sOldmsg = str;
            sToast.setText(str);
            sToast.show();
        }
        sOneTime = sTwoTime;
    }


    private void showStr(String str) {
        if (!TextUtils.isEmpty(str)) {
            toast(str);
        }
    }

    private void showToThread(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                getInstance().showStr(str);
            }
        });

    }

    private void showStr(@StringRes int resId) {
        toast(mContext.getResources().getString(resId));
    }

    public static void showThread(String str){
        getInstance().showToThread(str);
    }


    public static void show(String str) {
        getInstance().showStr(str);
    }

    public static void show(@StringRes int resId) {
        getInstance().showStr(resId);
    }


    public static void showException(Exception apiException) {
        getInstance().showStr(apiException.getMessage());
    }


    /**
     * 暂无更多数据吐司
     */
    public static void showNoData() {
        getInstance().showStr("暂无更多数据");
    }

    /**
     * 无网络吐司
     *
     * @param
     */

    public static void showNoNet() {
        getInstance().showStr("网络繁忙,请检查网络!");
    }

    public static void noServiceData() {
        getInstance().showStr("获取失败,服务器繁忙!");
    }


    public static void doException(Exception exc) {
        exc.getLocalizedMessage();
        if (TextUtils.equals(exc.toString(), "java.net.SocketTimeoutException")) {
            getInstance().showStr("服务器连接超时，请稍后再试");
        } else {
            showNoNet();
        }
    }

}
