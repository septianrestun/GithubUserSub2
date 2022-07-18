package com.dicoding.githubusersub2.fragment



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.dicoding.githubusersub2.R


class FollowersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_followers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val tvLabel: TextView = view.findViewById(R.id.section_followers)
        val index = arguments?.getInt(ARG_SECTION_NUMBER, 0)
        val name = arguments?.getString(ARG_NAME)

        tvLabel.text = getString(R.string.content_tab_followers, index)

    }

    companion object {
        const val ARG_SECTION_NUMBER = "section number"
        const val ARG_NAME = "app_name"
    }
}