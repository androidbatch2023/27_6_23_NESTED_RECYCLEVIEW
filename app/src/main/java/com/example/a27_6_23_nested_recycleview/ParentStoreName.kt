package com.example.a27_6_23_nested_recycleview

data class ParentStoreName(
    var storeName: String,
    var productDetails: MutableList<ChildProductName>
)

