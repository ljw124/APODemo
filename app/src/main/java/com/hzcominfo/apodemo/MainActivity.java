package com.hzcominfo.apodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.hzcominfo.apodemo.proxy.DBOperation;
import com.hzcominfo.apodemo.proxy.DBOperationer;
import com.hzcominfo.apodemo.proxy.DynamicProxy;

import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity{

    private DBOperation dbOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //要代理的对象
        DBOperation operation = new DBOperationer();
        //初始化动态代理
        DynamicProxy dynamicProxy = new DynamicProxy(operation);
        dbOperation = (DBOperation) Proxy.newProxyInstance(DBOperationer.class.getClassLoader(), operation.getClass().getInterfaces(), dynamicProxy);
    }

    public void addData(View view) {
        dbOperation.add();
    }

    public void deleteData(View view) {
        dbOperation.delete();
    }

    public void modifyData(View view) {
        dbOperation.modify();
    }
}
