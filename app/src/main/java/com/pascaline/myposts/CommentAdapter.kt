package com.pascaline.myposts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pascaline.myposts.databinding.CommentListItemBinding

class CommentAdapter(var comments:List<Comment>):RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding=CommentListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentComment=comments.get(position)
        holder.binding.tvTitleC.text=currentComment.name
        holder.binding.tvBodyC.text=currentComment.body
    }

    override fun getItemCount(): Int {
        return comments.size
    }
}
class CommentViewHolder(var binding:CommentListItemBinding):RecyclerView.ViewHolder(binding.root)