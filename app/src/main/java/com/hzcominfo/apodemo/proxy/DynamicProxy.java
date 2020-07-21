package com.hzcominfo.apodemo.proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Create by Ljw on 2020/7/21 15:42
 */
public class DynamicProxy implements InvocationHandler {

    public static final String TAG = "MainActivity";

    // 这个就是我们要代理的真实对象
    private Object subject;
    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Log.e(TAG, "代理前的操作");
        Log.e(TAG, method.getName());
        method.invoke(subject, objects);
        Log.e(TAG, "代理后的操作");
        return null;
    }
}
