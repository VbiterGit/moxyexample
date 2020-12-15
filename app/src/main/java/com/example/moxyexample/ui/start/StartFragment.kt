package com.example.moxyexample.ui.start

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.moxyexample.R
import kotlinx.android.synthetic.main.layout_start.*

class StartFragment: Fragment(R.layout.layout_start) {
    private lateinit var navController: NavController

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navController = findNavController()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_exmp_nomoxy_1.setOnClickListener { navController.navigate(R.id.action_startFragment_to_noMoxyImageFragment) }
        btn_exmp_moxy_1.setOnClickListener { navController.navigate(R.id.action_startFragment_to_moxyImageFragment) }
        btn_exmp_nomoxy_2.setOnClickListener { navController.navigate(R.id.action_startFragment_to_noMoxyRvFragment) }
        btn_exmp_moxy_2.setOnClickListener { navController.navigate(R.id.action_startFragment_to_moxyRvFragment) }
    }
}