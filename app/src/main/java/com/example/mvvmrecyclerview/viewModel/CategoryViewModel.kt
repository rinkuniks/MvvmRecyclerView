package com.example.mvvmrecyclerview.viewModel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmrecyclerview.R
import com.example.mvvmrecyclerview.model.Category
import com.squareup.picasso.Picasso

class CategoryViewModel : ViewModel
{
    var id = ""
    var title =""
    var desc = ""
    var imagePath =""
    constructor() : super()
    constructor(category : Category) : super() {
        this.id = category.id
        this.title = category.title
        this.desc = category.desc
        this.imagePath = category.imagePath
    }

    var arrayListMutableLiveData = MutableLiveData<ArrayList<CategoryViewModel>>()

    var arrayList = ArrayList<CategoryViewModel>()

    fun getImageUrl() : String
    {
        return imagePath
    }

    fun getArrayList(): MutableLiveData<ArrayList<CategoryViewModel>>
    {
        val category1 = Category("1","Title1","This is first Desc","android.jpg")
        val category2 = Category("2","Title2","This is Second Desc","android.jpg")
        val category3 = Category("3","Title3","This is Third Desc","android.jpg")
        val category4 = Category("4","Title4","This is Fourth Desc","android.jpg")

        val categoryViewModel1 = CategoryViewModel(category1)
        val categoryViewModel2 = CategoryViewModel(category2)
        val categoryViewModel3 = CategoryViewModel(category3)
        val categoryViewModel4 = CategoryViewModel(category4)

        arrayList.add(categoryViewModel1)
        arrayList.add(categoryViewModel2)
        arrayList.add(categoryViewModel3)
        arrayList.add(categoryViewModel4)

        arrayListMutableLiveData.value = arrayList

        return arrayListMutableLiveData
    }
}

object ImageBindingAdapter{
    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUrl(view:ImageView,url:String)
    {
        Picasso.get().load(url).placeholder(R.drawable.android).into(view)
    }
}