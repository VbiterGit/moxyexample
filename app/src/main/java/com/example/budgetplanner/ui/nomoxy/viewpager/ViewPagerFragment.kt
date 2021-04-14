package com.example.budgetplanner.ui.nomoxy.viewpager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.budgetplanner.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.layout_nomoxy_image.*
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