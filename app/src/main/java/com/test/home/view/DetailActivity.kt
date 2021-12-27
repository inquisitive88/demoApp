package com.test.home.view

import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.test.R
import com.test.base.activity.BaseDataBindingActivity
import com.test.databinding.DetailDataBinding
import com.test.di.DaggerProvider
import com.test.home.callbacks.DetailViewCallbacks
import com.test.home.model.ResultsItem
import com.test.util.Constants


class DetailActivity : BaseDataBindingActivity<DetailDataBinding>(R.layout.activity_detail),
    DetailViewCallbacks {


    override fun onDataBindingCreated() {
        supportActionBar?.hide()
        binding.callback = this
        binding.lifecycleOwner = this


        if (intent.extras != null) {

            val detailModel = intent.getSerializableExtra(Constants.DETAIL_MODEL) as ResultsItem



            if (detailModel.media != null) if (detailModel.media.get(0).mediaMetadata != null) {

                Glide.with(this)
                    .load(detailModel.media[0].mediaMetadata!![0].url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.ivThumbnail)
            }
            if (detailModel.title != null) {
                binding.tvTitle.text = detailModel.title.toString()
            }
            if (detailModel.byline != null) {
                binding.tvBy.text = detailModel.byline.toString()
            }
            if (detailModel.source != null) {
                binding.tvSource.text = detailModel.source.toString()
            }
            if (detailModel.publishedDate != null) {
                binding.tvDate.text = detailModel.publishedDate.toString()
            }
            if (detailModel.abstract != null) {
                binding.tvAbstract.text = detailModel.abstract.toString()
            }

        }


    }

    override fun injectDaggerComponent() {
        DaggerProvider.getAppComponent()?.inject(this)

    }

    override fun backClick() {
        onBackPressed()
    }


}