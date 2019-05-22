package com.example.mvvmrecyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmrecyclerview.R
import com.example.mvvmrecyclerview.databinding.CategoryBinding
import com.example.mvvmrecyclerview.viewModel.CategoryViewModel

class CustomAdapter(private var context :Context, private val arrayList:ArrayList<CategoryViewModel>)
    :RecyclerView.Adapter<CustomAdapter.CustomView>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {
        val layoutInflater = LayoutInflater.from(parent.context)
        val categoryBinding : CategoryBinding =DataBindingUtil.inflate(layoutInflater,R.layout.innerlayout,parent,false)
        return CustomView(categoryBinding)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {
        val categoryViewModel = arrayList[position]
        holder.bind(categoryViewModel)
    }

    class CustomView(var categoryBinding : CategoryBinding):RecyclerView.ViewHolder(categoryBinding.root)
    {
        fun bind(categoryViewModel : CategoryViewModel)
        {
            this.categoryBinding.categorymodel = categoryViewModel
            categoryBinding.executePendingBindings()
        }
    }
}