package net.sublime.rest.service.post

import net.sublime.rest.dto.post.PostDTO
import net.sublime.rest.repository.PostRepository
import org.springframework.stereotype.Service

@Service
open class PostServiceImpl(
    private val postRepository: PostRepository
) : PostService {

    override fun getAll(): List<PostDTO> = postRepository
        .findAll()
        .map { it.toPostDTO() }


    override fun getPost(id: Long): PostDTO = postRepository.getOne(id).toPostDTO()

    override fun createPost(post: PostDTO): PostDTO {
        postRepository.save(post.toEntity())
        return post
    }

    override fun archivePost(post: PostDTO) {
        TODO("Not yet implemented")
    }

    override fun archivePost(id: Long) {
        TODO("Not yet implemented")
    }
}
