package net.sublime.rest.service.post

import net.sublime.rest.dto.post.PostDTO
import net.sublime.rest.model.post.Post

fun Post.toPostDTO() = PostDTO(
        id = this.id,
        title = this.title,
        content = this.content,
        user = this.user
        )

fun PostDTO.toEntity():Post  {
    val post = Post()
    post.id = this.id
    post.title = this.title
    post.user = this.user
    post.content = this.content

    return post
}
