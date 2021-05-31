package net.sublime.rest.service.post

import net.sublime.rest.dto.post.PostDTO
import net.sublime.rest.mapper.PostMapper
import net.sublime.rest.repository.PostRepository
import org.springframework.stereotype.Service

@Service
open class PostServiceImpl(
    private val postRepository: PostRepository,
    private val mapper: PostMapper
) : PostService {

    override fun getAll(): List<PostDTO> = postRepository
        .findAll()
        .map(mapper::toDTO)


    override fun getPost(id: Long): PostDTO = mapper.toDTO(postRepository.getOne(id))

    override fun createPost(post: PostDTO): PostDTO {
        postRepository.save(mapper.toEntity(post))
        return post
    }

    override fun archivePost(post: PostDTO) {
        TODO("Not yet implemented")
    }

    override fun archivePost(id: Long) {
        TODO("Not yet implemented")
    }
}
