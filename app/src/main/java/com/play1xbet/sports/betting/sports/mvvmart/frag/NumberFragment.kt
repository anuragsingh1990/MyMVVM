package com.play1xbet.sports.betting.sports.mvvmart.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.play1xbet.sports.betting.sports.mvvmart.AdapterClass
import com.play1xbet.sports.betting.sports.mvvmart.R
import com.play1xbet.sports.betting.sports.mvvmart.databinding.FragmentNumberBinding
import com.play1xbet.sports.betting.sports.mvvmart.local.NumberViewModel
import com.play1xbet.sports.betting.sports.mvvmart.local.response.Data
import com.play1xbet.sports.betting.sports.mvvmart.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NumberFragment : Fragment() {

    lateinit var binding: FragmentNumberBinding
    val viewModel: NumberViewModel by viewModels()

    val list = ArrayList<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNumberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.getNumberFacts()
        viewModel.fact.observe(viewLifecycleOwner) {
            when (it.getContentIfNotHandled()?.status) {
                Status.LOADING -> {
                    binding.loader.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {
                    binding.loader.visibility = View.GONE
                    /* binding.loader.visibility = View.GONE
                     binding.numberFact.text= it.peekContent().data?.data!![0].trans_amt*/
                    list.addAll(it.peekContent().data?.data!!)
                    var layoutManagr =
                        LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
                    binding.rvData.layoutManager = layoutManagr

                    var adapterData = activity?.let { it1 -> AdapterClass(it1, list) }
                    binding.rvData.adapter = adapterData

                }
                Status.ERROR -> {
                    binding.loader.visibility = View.GONE
                }
            }
        }
    }
}