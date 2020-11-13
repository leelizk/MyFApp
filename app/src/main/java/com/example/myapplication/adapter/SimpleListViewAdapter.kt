package com.example.myapplication.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import kotlin.jvm.internal.Reflection

/**
 * 简单列表显示
 */

class SimpleListViewAdapter : BaseAdapter
{

    var context: Context;

    constructor(context:Context,dataList:List<String>){
        this.context=context
        this.dataList = dataList;
    }

    //数据列表
    var dataList:List<String> = listOf();

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        //加载 layout
        var view =View.inflate(context, R.layout.list_item,null)

        //通过view 获取 控件引用
        var textView: TextView =view.findViewById(R.id.tv_title)
        var textView2:TextView =view.findViewById(R.id.tv_thumbnailUrl)
        var imageView: ImageView =view.findViewById(R.id.iv_photo_main_Image)
        //通过text设置值
        textView.text= this.dataList[position]
        textView2.text= this.dataList[position]
        //load 图片
       // Glide.with(context).load(arr[position].pic).into(imageView)
        return  view
    }

    override fun getItem(p0: Int): Any {
        return dataList.get(p0);
    }

    override fun getItemId(p0: Int): Long {
        return 0;
    }

    override fun getCount(): Int {
        return dataList.size;
    }
}