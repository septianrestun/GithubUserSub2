package com.dicoding.githubusersub2.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dicoding.githubusersub2.fragment.FollowersFragment


class SectionPageAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {

    var appName: String = ""

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {



        val fragment = FollowersFragment()
        fragment.arguments = Bundle().apply {

            putInt(FollowersFragment.ARG_SECTION_NUMBER, position + 1)
            putString(FollowersFragment.ARG_NAME, appName)

        }

        return fragment

    }
}