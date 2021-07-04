package com.willowtree.viewpagertest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.willowtree.viewpagertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.pager.adapter = PagerAdapter(supportFragmentManager, lifecycle)
    }
}