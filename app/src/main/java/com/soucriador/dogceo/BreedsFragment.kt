package com.soucriador.dogceo

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.soucriador.dogceo.breeds.BreedsAdapter
import com.soucriador.dogceo.breeds.BreedsViewModel
import com.soucriador.dogceo.data.Breed
import com.soucriador.dogceo.databinding.BreedsFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel


class BreedsFragment : Fragment() {

    val vm: BreedsViewModel by viewModel()

    companion object {
        fun newInstance(): BreedsFragment {
            return BreedsFragment()
        }
    }

    override fun onStart() {
        super.onStart()
        vm.load()
    }

    override fun onCreateView(@NonNull inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : BreedsFragmentBinding = BreedsFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = vm
        binding.recyclerView.adapter = BreedsAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        val observer =  object : Observer<MutableList<Breed>> {
            override fun onChanged(t: MutableList<Breed>?) {
                BindingAdapters.setItems(binding.recyclerView, t!!.toMutableList())
            }

        }
        vm.breeds.observe(this, observer)

        return binding.root
    }

}


