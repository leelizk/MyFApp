package com.example.myapplication.demoui

import com.example.myapplication.R

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.myapplication.adapter.SimpleListViewAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.db.AppDatabase
import com.example.myapplication.db.dao.PhotoDao
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity()  {

    //定义常量
    private val clickTimes:Int=0
    //定义变量
    var testNull:String?=null;
    //定义常量
    companion object{
        private const val TAG:String="MainActivity"
    }

    var photoDao: PhotoDao?=null;

    lateinit var mBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
         mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
         initDb();
        //打印日志
        Log.d(TAG,"MainActivity start");

        Toast.makeText(this,"show FFFFF",Toast.LENGTH_SHORT).show();

        //显示内容
       /* click_roll.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                val randomInt = (1..6).random()
                show_roll_result.setText("f you all ::: " + randomInt);
            }

        });*/

        /*click_addphoto.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {
                Log.d(TAG,photoDao.toString());
            }

        })*/

        var myList:MutableList<String> = mutableListOf();
        for(i in 1..10){
           // Log.d(TAG,"debug===>" + i);
            myList.add(i.toString());
        }

        // 简单的列表
        var simpleAdapter:SimpleListViewAdapter = SimpleListViewAdapter(this,myList);
        //使用 adapter
        show_list.adapter = simpleAdapter;

    }

    fun initDb(){
        val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "myfapp.db" // 创建数据库比较消耗资源，可以在Application加载时加载数据库，这样保证Database为单例加载模式，若App有多个进程，需要取消下面这行注释
        ).build()
        photoDao = db.photoDao();
    }

    //定义方法
    fun out(str: String?){
        Log.d(TAG, if (str != null) str.toString() else "empty")
        var i:Int = 0;
        for (i  in 1..100){
            // out(i.toString())
            println(i)
        }
    }
}