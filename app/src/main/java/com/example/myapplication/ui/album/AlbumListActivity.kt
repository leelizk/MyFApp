package com.example.myapplication.ui.album

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityAlbumListBinding
import com.example.myapplication.ui.BaseActivity

class AlbumListActivity : BaseActivity(){

    private lateinit var photoAdapter: PhotoAdapter;
    private lateinit var mBinding:ActivityAlbumListBinding;
    override val layoutId: Int
        get() = R.layout.activity_album_list

    override fun initializeViewModel() {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //数据绑定
        mBinding = DataBindingUtil.setContentView(this, layoutId)
        //初始adapter

    }

    override fun observeViewModel() {
        TODO("Not yet implemented")
    }
}
