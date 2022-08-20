package com.pascaline.myposts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pascaline.myposts.databinding.PostListsItemBinding

class PostAdapter(var postList:List<Post>):
RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var binding= PostListsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPost=postList.get(position)
        holder.binding.tvTitle?.text=currentPost.title.toString()
        holder.binding.tvBody?.text=currentPost.body.toString()

    }

    override fun getItemCount(): Int {
        return postList.size
    }
}
class PostViewHolder(var binding:PostListsItemBinding):RecyclerView.ViewHolder(binding.root)
