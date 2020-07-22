package com.hzcominfo.apodemo.proxy;

import android.util.Log;

/**
 * Create by Ljw on 2020/7/21 15:34
 */
public class DBOperationer implements DBOperation {

    private static final String TAG = "MainActivity";

    @Override
    public void add() {
        Log.e(TAG, "添加数据成功");
    }

    @Override
    public void delete() {
        Log.e(TAG, "删除数据成功");
    }

    @Override
    public void modify() {
        Log.e(TAG, "修改数据成功");
    }

    @Override
    public void save() {
        Log.e(TAG, "保存数据成功");
    }
}
