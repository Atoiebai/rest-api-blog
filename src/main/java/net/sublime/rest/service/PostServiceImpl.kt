package net.sublime.rest.service

import net.sublime.rest.repository.PostRepository

class PostServiceImpl(val postRepository: PostRepository) : PostService{
}