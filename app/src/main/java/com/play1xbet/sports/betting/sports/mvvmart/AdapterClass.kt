package com.play1xbet.sports.betting.sports.mvvmart

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.play1xbet.sports.betting.sports.mvvmart.databinding.RowItemBinding
import com.play1xbet.sports.betting.sports.mvvmart.local.response.Data
import com.play1xbet.sports.betting.sports.mvvmart.local.response.DataDemo
import kotlin.math.roundToInt

class AdapterClass() :
    RecyclerView.Adapter<AdapterClass.MyViewHolder>() {

    var data = ArrayList<Data>()
    lateinit var context: Context


    constructor(context: Context, data: ArrayList<Data>) : this() {
        this.context = context
        this.data = data
    }


    inner class MyViewHolder(view: RowItemBinding) :
        RecyclerView.ViewHolder(view.root) {

        var binding: RowItemBinding

        init {
            binding = view

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterClass.MyViewHolder {
        val bindingUpcoming: RowItemBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.row_item,
                parent,
                false
            )
        return MyViewHolder(bindingUpcoming)
    }

    override fun onBindViewHolder(holder: AdapterClass.MyViewHolder, position: Int) {

        var datas = data[position]

        holder.binding.textView.text = "Amount"

        holder.binding.date.text = datas.trans_date
        holder.binding.txtPaidAmt.text = datas.trans_amt
        holder.binding.paidFrom.text = "Paid By: " + datas.trans_from
        holder.binding.paidTo.text = "Paid To: " + datas.trans_to
        holder.binding.paymentMethod.text = "Paid Through: " + datas.trans_method

    }

    override fun getItemCount(): Int {
        return data.size
    }
}