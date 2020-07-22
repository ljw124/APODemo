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
        //这里便是通过切面抽取出来的相同业务，每个切面方法都要执行的
        ((DBOperationer)subject).save();
        //这里可以模拟页面跳转，假如“个人信息”页面必须要在登录之后才能跳转，可以这样：
        boolean isLogin = true; //模拟登录状态
        if (isLogin){
            //代理的方法名
            Log.e(TAG, method.getName());
            return method.invoke(subject, objects); //切面方法执行
        } else {
            return null; //返回null切面方法不再执行
        }
    }
}
