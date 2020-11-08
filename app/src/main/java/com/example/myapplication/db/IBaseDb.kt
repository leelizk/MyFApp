package com.example.myapplication.db

import java.io.Serializable

interface IBaseDb<T> {

    open fun insert(list:List<T>);

    open fun update(t:T);

    open fun delete(t:T);

    open fun selectList(t:T):List<T>;

    open fun selectCount(map:Map<String,Object>):Int;

    open fun selectById(id:Serializable):T;






}