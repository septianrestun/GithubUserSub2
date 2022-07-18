package com.dicoding.githubusersub2.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2

import com.dicoding.githubusersub2.R
import com.dicoding.githubusersub2.`class`.IntegerHelper
import com.dicoding.githubusersub2.adapter.SectionPageAdapter

import com.dicoding.githubusersub2.databinding.ActivityGithubUserDetailBinding
import com.dicoding.githubusersub2.model.Users
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class GithubUserDetailActivity : AppCompatActivity() {

private lateinit var binding: ActivityGithubUserDetailBinding
private var userData: Users? = null

    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGithubUserDetailBinding.inflate(layoutInflater)

//        Tampilkan Tab

        val sectionPagerAdapter = SectionPageAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabs, viewPager){
            tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
        supportActionBar?.elevation = 0f

        userData = intent.getParcelableExtra("DATA")


        userData?.let {
            title = "@"+it.username.lowercase()
            binding.apply {
                imgDetUser.setImageResource(it.avatar)
                tvDetNama.text = it.name
                tvDetUsername.text = it.username
                tvDetCompany.text = it.company
                tvDetLocation.text = it.location
                tvRepository.text = IntegerHelper.readAbleInt(it.repository.toInt())
            }
        } ?: run{
            Toast.makeText(this@GithubUserDetailActivity, "Gagal mengambil data", Toast.LENGTH_SHORT).show()
            finish()
        }



        setContentView(binding.root)


    }




}