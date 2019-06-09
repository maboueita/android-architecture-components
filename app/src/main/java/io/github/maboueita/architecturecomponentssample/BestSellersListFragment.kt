package io.github.maboueita.architecturecomponentssample


import androidx.lifecycle.ViewModelProviders

import android.os.Bundle

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

import io.github.maboueita.architecturecomponentssample.data.OverviewViewModel

class BestSellersListFragment : Fragment() {

    private var overviewViewModel: OverviewViewModel? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        overviewViewModel = ViewModelProviders.of(this).get(OverviewViewModel::class.java)
        overviewViewModel!!.init()
        Log.d("YOLO", "do we get here?")
        if (overviewViewModel!!.results != null) {
            overviewViewModel!!.results!!.observe(this, Observer {
                Log.d("YOLO", "Results are back? ${it.Lists().books?.size}")
            })

        } else {
            Log.d("YOLO ", "we back but results are null.")
        }

        fun onCreateView(inflater: LayoutInflater, container: ViewGroup,
                         savedInstanceState: Bundle): View {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_best_sellers_list, container, false)
        }
    }
}
