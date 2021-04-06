package com.example.budgetplanner.ui.nomoxy.image

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.budgetplanner.R
import kotlinx.android.synthetic.main.layout_nomoxy_image.*

class NoMoxyImageFragment: Fragment(R.layout.layout_nomoxy_image) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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