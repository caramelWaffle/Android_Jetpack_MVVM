package com.example.totorial.room.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.totorial.databinding.RoomItemBinding
import com.example.totorial.room.data.User

class RoomAdapter(private val users: List<User>, private val mClickListener: (User) -> Unit) :
    RecyclerView.Adapter<RoomAdapter.MyViewHolder>() {

//    fun setData(users: List<User>){
//        this.users = users
//        notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RoomItemBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindViewItem(position, users[position], mClickListener)
    }

    class MyViewHolder(val binding: RoomItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindViewItem(position: Int, user: User, mClickListener: (User) -> Unit) {
            binding.apply {
                tvName.text = user.name
                tvEmail.text = user.email
                cardLayout.setOnClickListener{
                    mClickListener(user)
                }
            }
        }
    }
}