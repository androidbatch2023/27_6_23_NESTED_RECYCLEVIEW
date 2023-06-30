package com.example.a27_6_23_nested_recycleview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a27_6_23_nested_recycleview.databinding.ItemParentStoreNameBinding

class StoreNameAdapter(
    var addDataToList: MutableList<ParentStoreName>
) :
    RecyclerView.Adapter<StoreNameAdapter.StoreNameViewHolder>() {

    lateinit var userAdapter2: StoreProductsAdapter

    var position1: Int = 0
    lateinit var holder1: StoreNameViewHolder

    inner class StoreNameViewHolder(var view: ItemParentStoreNameBinding) :
        RecyclerView.ViewHolder(view.root) {


        fun bind(holder1: StoreNameViewHolder, position1: Int) {

            holder1.view.textViewStoreName.text =
                addDataToList[position1].storeName


            holder1.view.rvChild.layoutManager =
                LinearLayoutManager(holder1.itemView.context, RecyclerView.VERTICAL, false)
            userAdapter2 =
                StoreProductsAdapter(addDataToList[position1].productDetails)
            holder1.view.rvChild.adapter = userAdapter2
            holder1.view.rvChild.setHasFixedSize(true)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreNameViewHolder {
        return StoreNameViewHolder(
            ItemParentStoreNameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return addDataToList.size
    }

    override fun onBindViewHolder(holder1: StoreNameViewHolder, position1: Int) {

        holder1.bind(holder1, position1)
        this.position1 = position1
        this.holder1 = holder1

        Log.d("TAG", "onBindViewHolder: $position1")
        Log.d("TAG", "onBindViewHolder: $holder1")

    }

//    override fun sedData(
//        holder: StoreProductsAdapter.StoreProductViewHolder,
//        position: Int
//    ) {
//        Log.d("TAG", "addProduct: $position")
//        addProduct(holder, position)
//        removeProduct(holder, position)
////        dataAddOderInfo(holder, position)
//    }

//    private fun addProduct(
//        holder: StoreProductsAdapter.StoreProductViewHolder,
//        position: Int,
//    ) {
//
//        holder.view.imageViewAddd.setOnClickListener {
//            var productNumber = holder.view.textViewShowNumberItem.text.toString().toDouble()
//            var productPrice = holder.view.textViewProductPrice.text.toString().toDouble()
//
//            if (productNumber <= 20.0) {
//                productNumber += 1.0
//                productPrice += 75.0
//
//
//                for (i in 0..addDataToList.size + 1) {
//                    if (position1 == 4 || position1 == 1 || position1 == 2 || position1 == 3) {
//                        for (j in 0..addDataToList[position1].productDetails.size + 1) {
//                            if (position == 4 || position == 1 || position == 2 || position == 3) {
//
//                                addDataToList[position1].productDetails[position].productPrice =
//                                    productPrice.toString().toDouble()
//
//                                holder.view.textViewProductPrice.text =
//                                    addDataToList[position1].productDetails[position].productPrice.toString()
//
//                                addDataToList[position1].productDetails[position].productNumber =
//                                    productNumber.toString().toDouble() // position to store Data
//
//                                holder.view.textViewShowNumberItem.text =
//                                    addDataToList[position1].productDetails[position].productNumber.toString()
//                            } else {
//                                break
//                            }
//                        }
//                    } else {
//                        break
//                    }
//                }
////                addDataToList[position1].productDetails.clear()
////                    Log.d("TAG", "addProduct: ${addDataToList[position1].productDetails.indices}")
////                    this.notifyItemInserted(position)
//                this.notifyItemChanged(holder1.adapterPosition)
//                userAdapter2.notifyItemChanged(holder.adapterPosition)
//
//            } else {
//                productNumber + 0
//            }
//        }
//    }
//
//    private fun removeProduct(
//        holder: StoreProductsAdapter.StoreProductViewHolder,
//        position: Int
//    ) {
//        holder.view.viewAddRemove.setOnClickListener {
//            var productNumber = holder.view.textViewShowNumberItem.text.toString().toDouble()
//            var productPrice = holder.view.textViewProductPrice.text.toString().toDouble()
//
//            if (productNumber > 1.0) {
//                productNumber -= 1.0
//                productPrice -= 75.0
//
//                for (i in 0..addDataToList.size + 1) {
//                    if (position1 == 0 || position1 == 1 || position1 == 2 || position1 == 3) {
//                        for (j in 0..addDataToList[i].productDetails.size + 1) {
//                            if (position == 0 || position == 1 || position == 2 || position == 3) {
//
//                                addDataToList[position1].productDetails[position].productPrice =
//                                    productPrice.toString().toDouble()
//
//                                holder.view.textViewProductPrice.text =
//                                    addDataToList[position1].productDetails[position].productPrice.toString()
//
//                                addDataToList[position1].productDetails[position].productNumber =
//                                    productNumber.toString().toDouble()
//                                holder.view.textViewShowNumberItem.text =
//                                    addDataToList[position1].productDetails[position].productNumber.toString()
//                            }
//                        }
//                    }
//                }
////
////                for (i in addDataToList[position1].productDetails.indices) {
////                    for (j in addDataToList[position1].productDetails.size..0) {
//
////                addDataToList[position1].productDetails[position].productPrice =
////                    productPrice.toString().toDouble()
////
////                holder.view.textViewProductPrice.text =
////                    addDataToList[position1].productDetails[position].productPrice.toString()
////
////                addDataToList[position1].productDetails[position].productNumber =
////                    productNumber.toString().toDouble()
////                holder.view.textViewShowNumberItem.text =
////                    addDataToList[position1].productDetails[position].productNumber.toString()
////                    }
////                }
////                addDataToList[position].productDetails.clear()
//                this.notifyItemRemoved(holder.adapterPosition)
//                userAdapter2.notifyItemRemoved(holder.adapterPosition)
//
//            } else {
//                productNumber + 1
//                holder.view.imageViewProduct.visibility = View.GONE
//                holder.view.textViewProductName.visibility = View.GONE
//                holder.view.viewAddRemove.visibility = View.GONE
//                holder.view.textViewProductPrice.visibility = View.GONE
//                holder.view.cardViewImage.visibility = View.GONE
//
//                addDataToList[position1].productDetails.removeAt(position)
//                userAdapter2.notifyItemRemoved(holder.adapterPosition)
//                this.notifyItemRangeChanged(position1, addDataToList[position1].productDetails.size)
//            }
//        }
//    }
////    @SuppressLint("SetTextI18n")
////    private fun dataAddOderInfo(
////        holder: StoreProductsAdapter.StoreProductViewHolder,
////        position: Int
////
////    ) {
////
////        this.position1
////        this.holder1
////
////        for (i in addDataToList.size..0) {
////            for (ii in addDataToList[position1].productDetails.size..0) {
////                if (i == ii) {
////
//////                    binding.textViewTotalProductPrice.text =
////
////                    val productNumber =
////                        addDataToList[position].productDetails[position].productNumber.toString()
////
//////                    binding.textViewSubTotalPrice.text =
////                    val productPrice =
////                        addDataToList[position].productDetails[position].productPrice.toString()
////
////                    val includeTax =
////                        (addDataToList[position].productDetails[position].productPrice * 6) / 100
////
//////                    binding.textViewServiceCharge6Price.text = includeTax.toString()
////
//////                    binding.textViewTotalPrice.text =
////                    val total =
////                        (includeTax + addDataToList[position].productDetails[position].productPrice).toString()
////                    Log.d(
////                        "TAG",
////                        "dataAddOderInfo:$productNumber,$productPrice,$includeTax,${total} "
////                    )
////                }
////            }
////        }
////    }
}
