package com.pascaline.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pascaline.myposts.databinding.ActivityCommentsBinding

class CommentsActivity : AppCompatActivity() {
    var postId=0
    lateinit var binding:ActivityCommentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
    }
    fun obtainPostId(){
        postId=intent.extras?.getInt("POST_ID")?:0
    }
}