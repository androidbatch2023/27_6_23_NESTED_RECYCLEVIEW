package com.example.a27_6_23_nested_recycleview

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a27_6_23_nested_recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var userAdapter: StoreNameAdapter
    private val parentList = mutableListOf<ParentStoreName>()
    private val list = ArrayList<OderInfo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        addDataToList()
        binding.recycleView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        userAdapter = StoreNameAdapter(parentList)
        binding.recycleView.adapter = userAdapter
        binding.recycleView.setHasFixedSize(true)

        checkArray()

//        val data = intent.getStringExtra("hello")
//        Log.d("TAG", "onCreate: $data")
//        binding.textViewTotalProductPrice.text = data
    }

    private fun addDataToList() {
        val childList1 = mutableListOf<ChildProductName>()
        childList1.add(ChildProductName(R.drawable.product, "Fanta", 1.0, 1.0))
//
        val childList2 = mutableListOf<ChildProductName>()
        childList2.addAll(
            mutableListOf(
                ChildProductName(R.drawable.fanta, "cock", 1.0, 1.0),
                ChildProductName(R.drawable.product, "Fanta", 1.0, 1.0),
                ChildProductName(R.drawable.fanta, "cock", 1.0, 1.0),
                ChildProductName(R.drawable.product, "Fanta", 1.0, 1.0)
            )
        )
        parentList.add(
            ParentStoreName(
                "BHARGAV",
                childList2
            )
        )
        parentList.add(
            ParentStoreName(
                "Bhumika",
                childList2,
            )
        )
        parentList.add(
            ParentStoreName(
                "Bhumi",
                childList2
            )
        )
        parentList.add(
            ParentStoreName(
                "Nikhil",
                childList2
            )
        )
        Toast.makeText(this, "${parentList.indices}", Toast.LENGTH_SHORT).show()
//        Toast.makeText(this, "${parentList[2].productDetails.size}", Toast.LENGTH_SHORT).show()
        Log.d("TAG", "addDataToList:${parentList.indices} ")
        Log.d("TAG", "addDataToList:${parentList[0].productDetails.indices} ")
        Log.d("TAG", "addDataToList:${parentList[1].productDetails.indices} ")
        Log.d("TAG", "addDataToList:${parentList[2].productDetails.indices} ")
        Log.d("TAG", "addDataToList:${parentList[3].productDetails.indices} ")
    }

    fun checkArray() {
//        for (i in 0..parentList.size + 1) {
//            if (i == 0 || i == 1 || i == 2 || i == 3) {
//                for (j in 0..parentList[i].productDetails.size + 1) {
//
//                    if (j == 0 || j == 1 || j == 2 || j == 3) {
//                        println("${parentList[i].productDetails[j].imageProductName}")
//                        println("${parentList[i].productDetails[j].productPrice}")
//                        println("${parentList[i].productDetails[j].productNumber}")
//                        println("${parentList[i].productDetails[j].productName}")
//                        Log.d("TAG", "checkArray: i  = $i")
//                        Log.d("TAG", "checkArray: j  = $j")
//                    } else {
//                        Toast.makeText(this, "ELSE PART", Toast.LENGTH_SHORT).show()
//                        break
//                    }
//                }
//            } else {
//                break
//            }
//        }


//        var i = 0
//        while (i in 0..parentList.size + 1) {
//            var j = 0
//            while (j in 0..parentList[i].productDetails.size + 1) {
//                if ()
//            }
//        }
    }
}