package com.example.myapplication.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

/**
 * 简单列表显示
 */

class SimpleListView : BaseAdapter()
{

    //数据列表
    var dataList:List<Object> = listOf();

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        TODO("Not yet implemented")
    }

    override fun getItem(p0: Int): Any {
        return dataList.get(p0);
    }

    override fun getItemId(p0: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getCount(): Int {
        return dataList.size;
    }
}