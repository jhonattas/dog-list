package com.soucriador.dogceo

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.soucriador.dogceo.breeds.AdapterItemsContract

class BindingAdapters {

    companion object {
        @BindingAdapter("items")
        @JvmStatic
        fun setItems(recyclerView: RecyclerView, items: MutableList<Any>) {

            recyclerView.adapter.let {
                if (it is AdapterItemsContract) {
                    it.replaceItems(items)
                }
            }
        }
    }

}