package net.sublime.rest.mapper

import net.sublime.rest.model.post.Post
import net.sublime.rest.dto.post.PostDTO
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface PostMapper {
    fun toDTO(post: Post?): PostDTO
    fun toEntity(postDTO: PostDTO?): Post
}
