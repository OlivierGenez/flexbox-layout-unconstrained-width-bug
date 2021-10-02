package com.example.flexboxbug

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        with(findViewById<RecyclerView>(R.id.rv)) {
            adapter = MyAdapter()
        }
    }
}

class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = FlexboxLayout(parent.context).apply {
            flexWrap = FlexWrap.WRAP
            addView(TextView(context).apply {
                text = "You can't see me!"
                layoutParams = FlexboxLayout.LayoutParams(
                    FlexboxLayout.LayoutParams.WRAP_CONTENT,
                    FlexboxLayout.LayoutParams.WRAP_CONTENT
                )
            })
        }
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = Unit

    override fun getItemCount(): Int = 1
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
