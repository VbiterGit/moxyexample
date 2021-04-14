package com.example.budgetplanner.ui.start

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.budgetplanner.R
import com.example.budgetplanner.ui.moxy.recview.MoxyRvOneFragment
import kotlinx.android.synthetic.main.layout_start.*

class StartFragment: Fragment(R.layout.layout_start) {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController = findNavController()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_exmp_nomoxy_1.setOnClickListener { navController.navigate(
                R.id.action_startFragment_to_noMoxyImageFragment,
                null,
                navOptions {
                    anim {
                        enter = R.anim.nav_default_enter_anim
                        exit = R.anim.nav_default_exit_anim
                    }
                }
            )
        }
        btn_exmp_moxy_1.setOnClickListener { navController.navigate(R.id.action_startFragment_to_moxyImageFragment) }
        btn_exmp_nomoxy_2.setOnClickListener { navController.navigate(R.id.action_startFragment_to_noMoxyRvFragment, bundleOf("KEY_FLOAT" to 1.0f)) }
        btn_exmp_moxy_2.setOnClickListener {
            val action = StartFragmentDirections.actionStartFragmentToMoxyRvFragment(0)
            navController.navigate(action)
//            navController.navigate(R.id.action_startFragment_to_moxyRvFragment)
        }
        btn_view_pager.setOnClickListener { navController.navigate(R.id.action_startFragment_to_viewPagerFragment) }
    }
}