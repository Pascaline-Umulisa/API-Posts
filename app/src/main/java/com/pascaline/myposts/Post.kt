package com.pascaline.myposts

data class Post(
    var userId:Int,
    var id:Int,
    var title:String,
    var body:String
)

data class Comment(
    var postId:Int,
    var id:Int,
    var name:String,
    var email:String,
    var body:String
)
//fun comparePosts(post1:Post,post2:Post):Post{
//    //Do something
//    return post1
//}
//fun compareComments(comment1:Comment,comment2:Comment):Comment{
//    //Do something
//    return comment1
//}
