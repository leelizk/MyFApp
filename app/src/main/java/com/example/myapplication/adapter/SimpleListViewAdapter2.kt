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

class SimpleListViewAdapter2 : BaseAdapter
{

    var context: Context;

    val pageSize:Int = 2;

    constructor(context:Context,dataList:List<String>){
        this.context=context
        this.dataList = dataList;
    }

    //数据列表
    var dataList:List<String> = listOf();

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        //加载 layout
        var view =View.inflate(context, R.layout.list_item2,null)

        //通过view 获取 控件引用
        var title1: TextView =view.findViewById(R.id.tv_title)
        var url1:ImageView =view.findViewById(R.id.iv_photo_main_Image)
        //var imageView: ImageView =view.findViewById(R.id.iv_photo_main_Image)
        //通过text设置值
        var newPos:Int = (position * pageSize);
        title1.text= this.dataList[newPos];
        Glide.with(context).load(R.drawable.mv18279).into(url1)
        var nextPos :Int = newPos + 1
        if((nextPos) < this.dataList.size) {
            var title2: TextView = view.findViewById(R.id.tv_title2);
            var url2: ImageView = view.findViewById(R.id.iv_photo_main_Image2)
            title2.text = this.dataList[nextPos];
            //url2.text = "==>" + this.dataList[nextPos];
            Glide.with(context).load(R.drawable.mv18279).into(url2)
        }

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
        if(dataList.size > 0){
            return (dataList.size/2) + ((dataList.size%2))
         }

            return 0;
    }
}