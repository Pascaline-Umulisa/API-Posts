package com.pascaline.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.pascaline.myposts.databinding.ActivityCommentsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {
    var postId=0
    lateinit var binding:ActivityCommentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPostId()
        setUpToolbar()
        fetchComments()
    }
    fun obtainPostId(){
        postId=intent.extras?.getInt("POST_ID")?:0
    }
    fun fetchPostId(){
        val apiClient=APIclient.buildApiClient(ApiInterface::class.java)
        val request=apiClient.getPostById(postId)
        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if(response.isSuccessful){
                    var post=response.body()
                    binding.tvBodyP.text=post?.body
                    binding.tvTitleP.text=post?.title
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }
    fun setUpToolbar(){
        setSupportActionBar(binding.tbComments)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
//        supportActionBar?.g
    }
    fun fetchComments(){
        var apiClient=APIclient.buildApiClient(ApiInterface::class.java)
       var request=apiClient.getComments()
        request.enqueue(object : Callback<List<Comment>> {
            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                if(response.isSuccessful){
                    var comments=response.body()
                    Toast.makeText(baseContext,"fetched ${comments!!.size} posts",Toast.LENGTH_LONG).show()

                    var commentAdapter=CommentAdapter(comments)
                    binding.rvComments.layoutManager= LinearLayoutManager(this@CommentsActivity)
                    binding.rvComments.adapter=commentAdapter
                }
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_SHORT).show()
            }
        })
    }
}