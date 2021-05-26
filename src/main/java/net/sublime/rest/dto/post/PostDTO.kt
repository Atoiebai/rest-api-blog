package net.sublime.rest.dto.post

import net.sublime.rest.dto.user.UserDTO

data class PostDTO(
    var id: Long? = null,
    var title: String? = null,
    var content: String? = null,
    var user: UserDTO? = null
)
