package com.jetpack.alphabeticrecylerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.util.*

class MainActivity : AppCompatActivity() {

    private val listValue: List<String> by lazy {
        Json.decodeFromString<List<String>>(
            this.assets.open("programming_languages.json").use {
                it.reader().readText()
            }
        ).sortedBy {
            it.lowercase(Locale.ROOT)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.HORIZONTAL, false
        )

        recyclerView.adapter = ListAdapter(listValue)

        fab.setOnClickListener {
            with(fastScroller) {
                val tmp = handleWidth
                handleWidth = handleHeight
                handleHeight = tmp

                fastScrollDirection = if (fastScrollDirection == RecyclerViewFastScroller.FastScrollDirection.HORIZONTAL) {
                    recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    RecyclerViewFastScroller.FastScrollDirection.VERTICAL
                } else {
                    recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    RecyclerViewFastScroller.FastScrollDirection.HORIZONTAL
                }
            }
        }
    }
}





















