package net.sublime.rest.service

import net.sublime.rest.model.Post

interface PostService {
    fun getAll(): List<Post>
    fun getPost(id: Long): Post
    fun createPost(post: Post): Post
    fun archivePost(post: Post)
    fun archivePost(id: Long)
 }
