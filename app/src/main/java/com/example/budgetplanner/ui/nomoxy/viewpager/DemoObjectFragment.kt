package com.example.budgetplanner.ui.nomoxy.viewpager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.budgetplanner.R
import com.example.budgetplanner.ui.nomoxy.viewpager.DemoCollectionAdapter.Companion.KEY_OBJECT
import kotlinx.android.synthetic.main.layout_demo_object.*

class DemoObjectFragment: Fragment(R.layout.layout_demo_object) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arg = arguments?.getInt(KEY_OBJECT)
        textView.text = arg.toString()
    }
}