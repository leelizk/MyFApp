package com.example.myapplication.demoui.details

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.model.Photo
import com.example.myapplication.ui.BaseActivity
import com.example.myapplication.ui.ViewModelFactory
import com.example.myapplication.utils.Constants
import com.example.myapplication.utils.observe
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.details_layout.*


class DetailsActivity : BaseActivity() {

    private lateinit var detailsViewModel: DetailsViewModel

    override val layoutId: Int
        get() = R.layout.details_layout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailsViewModel.photoEntity.value = intent.getParcelableExtra(Constants.PHOTOS_ITEM_KEY)
    }

    override fun initializeViewModel() {
        detailsViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory
        ).get(DetailsViewModel::class.java)
    }

    override fun observeViewModel() {
        observe(detailsViewModel.photoEntity, ::initializeView)
    }

    private fun initializeView(photoEntity: Photo) {
        tv_title?.text = photoEntity.title
        tv_thumbnailUrl?.text = photoEntity.thumbnailUrl
        if (photoEntity.url.isNotEmpty()) {
            Picasso.get().load(photoEntity.url).placeholder(R.drawable.ic_launcher_background)
                .into(iv_photo_main_Image)
        }
    }
}
