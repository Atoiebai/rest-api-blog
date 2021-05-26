package net.sublime.rest.service.post

import net.sublime.rest.dto.post.PostDTO
import net.sublime.rest.model.post.Post
import net.sublime.rest.service.user.toTransferObject
import net.sublime.rest.service.user.toUserEntity


fun Post.toPostDTO() = PostDTO(
    id = this.id,
    title = this.title,
    content = this.content,
    user = this.user?.toTransferObject()
)

fun PostDTO.toEntity(): Post {
    val post = Post()
        post.id = this.id
        post.title = this.title
        post.user = this.user?.toUserEntity()
        post.content = this.content

        return post

}
