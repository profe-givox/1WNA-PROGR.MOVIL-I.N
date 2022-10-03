package net.ivanvega.misrecyclersview.fragmentos

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.ivanvega.misrecyclersview.FlowerAdapter
import net.ivanvega.misrecyclersview.R
import net.ivanvega.misrecyclersview.data.flowerList

class FragmentFlowerList: Fragment(R.layout.layout_fragment_listflower) {

    lateinit var rvlf: RecyclerView
    lateinit var contexto : Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contexto = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val layout =
            inflater.inflate(R.layout.layout_fragment_listflower,
                container, false)

        rvlf = layout.findViewById<RecyclerView>(R.id.recyclerView)

        rvlf.layoutManager = LinearLayoutManager(contexto,
            LinearLayoutManager.VERTICAL,
            false
        )

        val adaptador = FlowerAdapter(
            flowerList(resources),
            {
                Toast.makeText(contexto
                    , "Flor prsionada ${it.name}",
                    Toast.LENGTH_SHORT).show()
            }
        )

        rvlf.adapter = adaptador

        return layout
    }

}