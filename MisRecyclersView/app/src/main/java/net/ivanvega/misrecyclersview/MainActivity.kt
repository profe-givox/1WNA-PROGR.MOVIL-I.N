package net.ivanvega.misrecyclersview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.ivanvega.misrecyclersview.data.flowerList

class MainActivity : AppCompatActivity() {
    lateinit var rvf : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvf = findViewById(R.id.recyclerView)

        rvf.layoutManager = LinearLayoutManager(applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        )


    }
}