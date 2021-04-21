package com.example.moxyexample.ui.viewmodel.viewpager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.moxyexample.R
import com.example.moxyexample.ui.adapter.DemoCollectionAdapter.Companion.KEY_OBJECT
import kotlinx.android.synthetic.main.layout_demo_object.*

class DemoObjectFragment: Fragment(R.layout.layout_demo_object) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arg = arguments?.getInt(KEY_OBJECT)
        textView.text = arg.toString()
    }
}