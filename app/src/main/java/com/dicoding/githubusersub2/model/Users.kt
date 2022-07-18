package com.dicoding.githubusersub2.model

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Parcelable
import com.dicoding.githubusersub2.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Users(
    var username: String,
    var name: String,
    var location: String,
    var repository: String,
    var company: String,
//    var followers: String,
//    var following: String,
    var avatar: Int
): Parcelable {
    companion object {
        @SuppressLint("Recycle")
        fun loadData(resources: Resources): ArrayList<Users>{
            val dataUsername = resources.getStringArray(R.array.username)
            val dataName = resources.getStringArray(R.array.name)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataCompany = resources.getStringArray(R.array.company)
//            val dataFollowers = resources.getStringArray(R.array.followers)
//            val dataFollowing = resources.getStringArray(R.array.following)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)

            val listUsers = ArrayList<Users>()
            for(i in dataUsername.indices){
                val users = Users(
                    dataUsername[i],
                    dataName[i],
                    dataLocation[i],
                    dataRepository[i],
                    dataCompany[i],
//                    dataFollowers[i],
//                    dataFollowing[i],
                    dataAvatar.getResourceId(i, -1)
                )

                listUsers.add(users)

            }
            return listUsers
        }
    }
}
