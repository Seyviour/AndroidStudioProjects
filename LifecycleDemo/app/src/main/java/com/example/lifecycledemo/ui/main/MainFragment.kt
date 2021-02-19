package com.example.lifecycledemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifecycledemo.R
import com.example.lifecycledemo.DemoObserver
import com.example.lifecycledemo.DemoOwner



class MainFragment : Fragment() {

    private lateinit var demoOwner: DemoOwner
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        demoOwner = DemoOwner()
        demoOwner.startOwner()
        demoOwner.stopOwner()

        //lifecycle.addObserver(DemoObserver())
        // TODO: Use the ViewModel
    }

}