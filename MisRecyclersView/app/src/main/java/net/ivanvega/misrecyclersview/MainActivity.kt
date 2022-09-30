package net.ivanvega.misrecyclersview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.ivanvega.misrecyclersview.data.flowerList
import net.ivanvega.misrecyclersview.fragmentos.FragmentFlowerList

class MainActivity : AppCompatActivity(R.layout.layout_main_fragment) {
    lateinit var rvf : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.layout_main_fragment)

        if (savedInstanceState == null){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FragmentFlowerList>(R.id.fragment_container_view)
                //add(R.id.fragment_container_view, FragmentFlowerList())
            }
        }

        /*
        rvf = findViewById(R.id.recyclerView)

        rvf.layoutManager = LinearLayoutManager(applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        )

        val adaptador = FlowerAdapter(
                flowerList(resources),
            {
                Toast.makeText(applicationContext
                , "Flor prsionada ${it.name}",
                Toast.LENGTH_SHORT).show()
            }
        )
        rvf.adapter = adaptador

         */
    }
}