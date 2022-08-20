package com.pascaline.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.pascaline.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchPost()
    }
    fun fetchPost(){
        var apiClient=APIclient.buildApiClient(ApiInterface::class.java)
        var request=apiClient.getPosts()
        request.enqueue(object: Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if(response.isSuccessful){
                    var posts=response.body()
                    Toast.makeText(baseContext,"fetched ${posts!!.size} posts",Toast.LENGTH_LONG).show()

                    var postAdapter=PostAdapter(posts)
                    binding.rvPosts.layoutManager= LinearLayoutManager(this@MainActivity)
                    binding.rvPosts.adapter=postAdapter
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_SHORT).show()
            }
        })
    }
}