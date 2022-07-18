package com.dicoding.githubusersub2.activity

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.githubusersub2.R
import com.dicoding.githubusersub2.`interface`.ItemAdapterCallback
import com.dicoding.githubusersub2.adapter.UserAdapter
import com.dicoding.githubusersub2.databinding.ActivityGithubUserBinding
import com.dicoding.githubusersub2.model.Users

class GithubUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGithubUserBinding

//    Search Menu

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.searchHint)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

//            method ketika search selesai atau ok

            override fun onQueryTextSubmit(query: String): Boolean {
               Toast.makeText(this@GithubUserActivity, query, Toast.LENGTH_SHORT).show()
                searchView.clearFocus()
                return true
            }

//            method ketika terjadi perubahan huruf pada searchView

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

        })

        return true
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGithubUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showRecyclerList()
    }

    private fun showRecyclerList() {
        val userAdapter = UserAdapter(Users.loadData(resources))


        userAdapter.setAdapterItemCallback(object : ItemAdapterCallback<Users>{
            override fun onItemClicked(data: Users){
                val intent = Intent(this@GithubUserActivity, GithubUserDetailActivity::class.java)
                intent.putExtra("DATA", data)
                startActivity(intent)
            }
        })

        binding.apply {
            rvUsers.setHasFixedSize(true)
            rvUsers.layoutManager = LinearLayoutManager(this@GithubUserActivity)
            rvUsers.adapter = userAdapter
        }

    }
}