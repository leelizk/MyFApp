package com.example.myapplication.net

interface ICallBack<T> {
    fun onSuccess(t:T);

    fun onFail(msg:String?);
}