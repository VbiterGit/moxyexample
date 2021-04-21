package com.example.moxyexample.ui.viewmodel.viewpager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.moxyexample.R
import com.example.moxyexample.ui.adapter.DemoCollectionAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.layout_viewpager.*

class ViewPagerFragment: Fragment(R.layout.layout_viewpager) {
    lateinit var demoCollectionAdapter: DemoCollectionAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        demoCollectionAdapter = DemoCollectionAdapter(this)
        pager.adapter = demoCollectionAdapter
        TabLayoutMediator(tab_layout, pager) { tab, position ->
            tab.text = "Object ${position + 1}"
        }.attach()
    }
}