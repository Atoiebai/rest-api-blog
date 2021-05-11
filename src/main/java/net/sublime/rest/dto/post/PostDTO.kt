package net.sublime.rest.dto.post

import net.sublime.rest.model.user.User

data class PostDTO(
    var id: Long?=null,
    var title: String?=null,
    var content: String?=null,
    var user: User?=null
) {
}
