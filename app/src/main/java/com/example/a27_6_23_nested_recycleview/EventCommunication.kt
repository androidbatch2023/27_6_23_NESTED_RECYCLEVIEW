package com.example.a27_6_23_nested_recycleview

interface EventCommunication {

    fun sedData(
        holder: StoreProductsAdapter.StoreProductViewHolder,
        position: Int
    )
}