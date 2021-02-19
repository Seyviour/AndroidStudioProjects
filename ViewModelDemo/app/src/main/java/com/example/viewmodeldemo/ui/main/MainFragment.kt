package com.example.viewmodeldemo.ui.main

import androidx.lifecycle.ViewModelProvider

import androidx.databinding.DataBindingUtil
import com.example.viewmodeldemo.databinding.MainFragmentBinding
import com.example.viewmodeldemo.BR.myViewModel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewmodeldemo.R


/**
 * Button with id - convertButton
 * **/

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var binding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //var viewModelProvider : ViewModelProvider = ViewModelProvider(this)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.setVariable(myViewModel, viewModel)






    }

}