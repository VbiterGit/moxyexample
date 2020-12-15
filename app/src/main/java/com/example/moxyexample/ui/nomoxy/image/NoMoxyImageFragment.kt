package com.example.moxyexample.ui.nomoxy.image

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.moxyexample.R
import kotlinx.android.synthetic.main.layout_nomoxy_image.*

class NoMoxyImageFragment: Fragment(R.layout.layout_nomoxy_image) {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        iv_android.setImageResource(R.drawable.ic_start_load_image)

        btn_recolor.setOnClickListener {
            iv_android.setImageResource(R.drawable.ic_load_image)
        }

        btn_calc_sum.setOnClickListener {
            val term1 = if (term1.text.isEmpty()) 0 else term1.text.toString().toInt()
            val term2 = if (term2.text.isEmpty()) 0 else term2.text.toString().toInt()
            sum.text = term1.plus(term2).toString()
        }
    }
}