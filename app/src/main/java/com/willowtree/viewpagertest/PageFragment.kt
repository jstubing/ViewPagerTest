package com.willowtree.viewpagertest

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.willowtree.viewpagertest.databinding.FragmentPageBinding

class PageFragment : Fragment() {

    companion object {
        private const val KEY_PAGE_NUMBER = "page_number"

        fun newInstance(pageNumber: Int) = PageFragment().apply {
            arguments = bundleOf(KEY_PAGE_NUMBER to pageNumber)
        }
    }

    lateinit var binding: FragmentPageBinding
    private val itemAdapter = ItemAdapter()

    private val itemCount: Int get() {
        val pageNumber = requireArguments().getInt(KEY_PAGE_NUMBER)
        return if (pageNumber % 2 == 0) 10 else 20
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPageBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = itemAdapter
    }

    override fun onResume() {
        super.onResume()
        fetchData()
    }

    private fun fetchData() {
        val data = mutableListOf<String>()
        repeat(itemCount) { data.add(it.toString()) }
        itemAdapter.setData(data)
    }
}