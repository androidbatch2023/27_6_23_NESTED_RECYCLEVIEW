package com.example.a27_6_23_nested_recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a27_6_23_nested_recycleview.databinding.ItemChildBinding

class StoreProductsAdapter(
    private var productDetails: MutableList<ChildProductName>
) :
    RecyclerView.Adapter<StoreProductsAdapter.StoreProductViewHolder>() {


    inner class StoreProductViewHolder(var view: ItemChildBinding) :
        RecyclerView.ViewHolder(view.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreProductViewHolder {
        return StoreProductViewHolder(ItemChildBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return productDetails.size
    }

    override fun onBindViewHolder(holder: StoreProductViewHolder, position: Int) {
        holder.view.imageViewProduct.setImageResource(productDetails[position].imageProductName!!)
        holder.view.textViewProductName.text = productDetails[position].productName
        addProduct(holder, position)
        removeProduct(holder, position)

    }


    private fun addProduct(holder: StoreProductViewHolder, position: Int) {

        holder.view.imageViewAddd.setOnClickListener {
            var productNumber = holder.view.textViewShowNumberItem.text.toString().toDouble()
            var productPrice = holder.view.textViewProductPrice.text.toString().toDouble()

            if (productNumber <= 20.0) {
                productNumber += 1.0
                productPrice += 75.0

                productDetails[position].productPrice =
                    productPrice.toString().toDouble()

                holder.view.textViewProductPrice.text =
                    productDetails[position].productPrice.toString()

                productDetails[position].productNumber =
                    productNumber.toString().toDouble() // position to store Data

                holder.view.textViewShowNumberItem.text =
                    productDetails[position].productNumber.toString()
            } else {
                productNumber + 0
            }
        }
    }

    private fun removeProduct(holder: StoreProductViewHolder, position: Int) {
        holder.view.viewAddRemove.setOnClickListener {
            var productNumber = holder.view.textViewShowNumberItem.text.toString().toDouble()
            var productPrice = holder.view.textViewProductPrice.text.toString().toDouble()

            if (productNumber > 1.0) {
                productNumber -= 1.0
                productPrice -= 75.0

                for (i in 0..productDetails.size + 1) {
                    productDetails[position].productPrice =
                        productPrice.toString().toDouble()

                    holder.view.textViewProductPrice.text =
                        productDetails[position].productPrice.toString()

                    productDetails[position].productNumber =
                        productNumber.toString().toDouble()
                    holder.view.textViewShowNumberItem.text =
                        productDetails[position].productNumber.toString()
                }

            } else {
                productNumber + 1
                holder.view.imageViewProduct.visibility = View.GONE
                holder.view.textViewProductName.visibility = View.GONE
                holder.view.viewAddRemove.visibility = View.GONE
                holder.view.textViewProductPrice.visibility = View.GONE
                holder.view.cardViewImage.visibility = View.GONE

                if (!productDetails.isEmpty()) {

                    productDetails.clear(); //The list for update recycle view

                    this.notifyDataSetChanged();
                }
                productDetails.removeAt(position)
                this.notifyItemRemoved(position)

//                this.notifyItemRemoved(holder.adapterPosition)
//                this.notifyItemRangeChanged(position, productDetails.size)
            }
        }
    }
//    @SuppressLint("SetTextI18n")
//    private fun dataAddOderInfo(
//        holder: StoreProductsAdapter.StoreProductViewHolder,
//        position: Int
//
//    ) {
//
//        this.position1
//        this.holder1
//
//        for (i in addDataToList.size..0) {
//            for (ii in addDataToList[position1].productDetails.size..0) {
//                if (i == ii) {
//
////                    binding.textViewTotalProductPrice.text =
//
//                    val productNumber =
//                        addDataToList[position].productDetails[position].productNumber.toString()
//
////                    binding.textViewSubTotalPrice.text =
//                    val productPrice =
//                        addDataToList[position].productDetails[position].productPrice.toString()
//
//                    val includeTax =
//                        (addDataToList[position].productDetails[position].productPrice * 6) / 100
//
////                    binding.textViewServiceCharge6Price.text = includeTax.toString()
//
////                    binding.textViewTotalPrice.text =
//                    val total =
//                        (includeTax + addDataToList[position].productDetails[position].productPrice).toString()
//                    Log.d(
//                        "TAG",
//                        "dataAddOderInfo:$productNumber,$productPrice,$includeTax,${total} "
//                    )
//                }
//            }
//        }
//    }

}

