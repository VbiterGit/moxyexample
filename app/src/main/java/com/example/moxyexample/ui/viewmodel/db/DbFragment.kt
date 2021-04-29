package com.example.moxyexample.ui.viewmodel.db

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.moxyexample.R
import kotlinx.android.synthetic.main.layout_db.*

class DbFragment: Fragment(R.layout.layout_db) {
    private val dbViewModel: DbViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_load_db.setOnClickListener {

        }
    }
}