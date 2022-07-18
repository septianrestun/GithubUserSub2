package com.dicoding.githubusersub2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.githubusersub2.`interface`.ItemAdapterCallback
import com.dicoding.githubusersub2.databinding.ItemUsersBinding
import com.dicoding.githubusersub2.model.Users

class UserAdapter(private val listUser: ArrayList<Users>): RecyclerView.Adapter<UserAdapter.ListViewHolder>() {

private lateinit var itemCallback: ItemAdapterCallback<Users>

   class ListViewHolder(var binding: ItemUsersBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemUsersBinding.inflate(LayoutInflater.from(viewGroup.context),  viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, pos: Int) {
        val (username, name, _, _, _, avatar) = listUser[pos]

        holder.binding.apply {
            tvUsername.text = username
            tvNama.text = name
            imgUser.setImageResource(avatar)

            holder.itemView.setOnClickListener{
                itemCallback.onItemClicked(listUser[holder.adapterPosition])
            }

        }


    }

    override fun getItemCount(): Int = listUser.size

    fun setAdapterItemCallback(callback: ItemAdapterCallback<Users>){
        this.itemCallback = callback
    }



}
