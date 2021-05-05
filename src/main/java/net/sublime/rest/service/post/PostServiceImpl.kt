package net.sublime.rest.service.post

import net.sublime.rest.model.post.Post
import net.sublime.rest.repository.PostRepository
import net.sublime.rest.service.post.PostService
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
open class PostServiceImpl(private val postRepository: PostRepository) : PostService {
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
