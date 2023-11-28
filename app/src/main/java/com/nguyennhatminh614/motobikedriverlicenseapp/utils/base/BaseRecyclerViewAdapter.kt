package com.nguyennhatminh614.motobikedriverlicenseapp.utils.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.nguyennhatminh614.motobikedriverlicenseapp.utils.OnClickItem
import java.util.concurrent.Executors

abstract class BaseRecyclerViewAdapter<T, VB : ViewBinding, VH : BaseViewHolder<T, VB>>(
    diffCallback: DiffUtil.ItemCallback<T>,
) : ListAdapter<T, VH>(
    AsyncDifferConfig.Builder(diffCallback)
        .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
        .build()
) {
    protected var clickItemInterface: OnClickItem<T>? = null
    
    override fun onBindViewHolder(holder: VH, position: Int) {
        if (position < currentList.size) {
            holder.onBindData(getItem(position))
        }
    }

    override fun onBindViewHolder(holder: VH, position: Int, payloads: MutableList<Any>) {
        if (position < currentList.size) {
            if (payloads.isNotEmpty()) {
                holder.onBindData(getItem(position), payloads)
            } else {
                holder.onBindData(getItem(position))
            }
        }
    }

    abstract fun registerOnClickItemEvent(onClickItem: OnClickItem<T>)

    protected fun <VB> inflateViewBinding(
        inflateFunction: (LayoutInflater, ViewGroup, Boolean) -> VB,
        parent: ViewGroup,
    ): VB = inflateFunction(
        LayoutInflater.from(parent.context),
        parent,
        false
    )
}
