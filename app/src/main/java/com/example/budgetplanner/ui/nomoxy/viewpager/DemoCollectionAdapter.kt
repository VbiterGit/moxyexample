package com.example.budgetplanner.ui.nomoxy.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class DemoCollectionAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 100

    override fun createFragment(position: Int): Fragment {
        return DemoObjectFragment().apply {
            this.arguments = Bundle().apply { putInt(KEY_OBJECT, position + 1) }
        }
    }

    companion object {
        const val  KEY_OBJECT = "KEY_OBJECT"
    }
}