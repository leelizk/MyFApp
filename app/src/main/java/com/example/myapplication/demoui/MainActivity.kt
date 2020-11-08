package com.example.myapplication.demoui

import com.example.myapplication.R

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding
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

    lateinit var mBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
         mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        //打印日志
        Log.d(TAG,"MainActivity start");

        Toast.makeText(this,"show FFFFF",Toast.LENGTH_SHORT).show();

        //显示内容
        show_roll_result.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                val randomInt = (1..6).random()
                show_roll_result.setText("f you all ::: " + randomInt);
            }

        });


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