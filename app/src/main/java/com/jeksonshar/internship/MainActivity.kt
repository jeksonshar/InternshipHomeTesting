package com.jeksonshar.internship

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jeksonshar.internship.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel  by viewModels<ActivityViewModel> {
        ViewModelFactory(TestDataStore(this), this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.activityViewModel = viewModel

    }

    // test

    override fun finish() {
        super.finish()
        viewModel.onSinging()
    }
}