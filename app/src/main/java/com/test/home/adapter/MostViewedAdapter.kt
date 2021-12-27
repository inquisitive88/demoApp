package com.test.home.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.test.databinding.ItemMostViewedBinding
import com.test.home.model.ResultsItem
import com.test.home.view.DetailActivity
import com.test.util.CommonUtilities
import com.test.util.Constants
import java.io.Serializable


class MostViewedAdapter(
    var context: Context,
    var mostViewedList: ArrayList<ResultsItem>
) :
    RecyclerView.Adapter<MostViewedAdapter.MyViewHolder>(){


    private lateinit var mBinding: ItemMostViewedBinding

    fun updateData(mostViewedList: ArrayList<ResultsItem>) {
        this.mostViewedList = mostViewedList
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        mBinding = ItemMostViewedBinding.inflate(LayoutInflater.from(context), parent, false)

        return MyViewHolder(mBinding)
    }


    inner class MyViewHolder(var binding: ItemMostViewedBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {

        return mostViewedList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var data = mostViewedList[position]

        if (data.title!=null)
        {
            holder.binding.tvTitle.text = data.title
        }


        if (data.byline != null) {
            holder.binding.tvAuthor.text = data.byline.toString()
        }


        if (data.source != null) {
            holder.binding.tvSource.text = data.source.toString()
        }

        if (data.media != null) {
            if (data.media?.get(0)?.mediaMetadata != null) {

                Glide.with(context)
                    .load(data.media?.get(0)?.mediaMetadata!![0].url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.binding.ivThumbnail)
            }
        }


        if (data.publishedDate != null) {
            holder.binding.tvDate.text = data.publishedDate.toString()
        }


        holder.itemView.setOnClickListener {


            val args = Bundle()
            args.putSerializable(Constants.DETAIL_MODEL, data as Serializable)


            CommonUtilities.fireActivityIntent(
                context as Activity,
                Intent(context as Activity, DetailActivity::class.java)
                    .putExtras(args),
                isFinish = false,
                isForward = true
            )

        }

    }


}