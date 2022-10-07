package net.ivanvega.misrecyclersview

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.ivanvega.misrecyclersview.data.Flower
import net.ivanvega.misrecyclersview.data.flowerList
import net.ivanvega.misrecyclersview.fragmentos.FragmentFlowerDetail
import net.ivanvega.misrecyclersview.fragmentos.FragmentFlowerList

class MainActivity : AppCompatActivity() {
    //lateinit var rvf : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main_fragment)

        DataSource.lsFlower.addAll(flowerList(resources))

        val fcvl = findViewById<View>(R.id.fragment_container_view)
        val fcvf = supportFragmentManager.findFragmentById(R.id.fragment_container_view)

        if(fcvl != null && fcvf == null) {
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

    fun mostrarDetailFlower(it: Flower) {

        val fcvl = findViewById<View>(R.id.fragment_container_view)
        val fd = supportFragmentManager.findFragmentById(R.id.fragdetail)

        if(fcvl != null &&  fd==null ){

            val frag = FragmentFlowerDetail.newInstance(it.id.toString(),"")
            val trans = supportFragmentManager.beginTransaction()
            trans.setReorderingAllowed(true)
            trans.replace(R.id.fragment_container_view, frag)
            trans.addToBackStack(null)
            trans.commit()
        }else{
            val fragD = fd?.let {
                it as FragmentFlowerDetail
            }
            fragD?.setDetailFlower(it.id)

        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun deleteFlower(id: Long) {
        DataSource.lsFlower.removeIf {
            it.id==id
        }
        supportFragmentManager.popBackStack()
    }
}