package net.sublime.rest.service

import net.sublime.rest.model.Post
import net.sublime.rest.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostServiceImpl(private val postRepository: PostRepository) : PostService{
    override fun getAll(): List<Post> = postRepository.findAll()

    override fun getPost(id: Long): Post = postRepository.getOne(id)

    override fun createPost(post: Post): Post = postRepository.save(post)

    override fun archivePost(post: Post) {
        TODO("Not yet implemented")
    }

    override fun archivePost(id: Long) {
        TODO("Not yet implemented")
    }
}