package net.sublime.rest.dto.user

import net.sublime.rest.model.user.Sex

data class UserDTO(
    var id: Long? = null,
    var username: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var age: Int? = null,
    var email: String? = null,
    var password: String? = null,
    var sex: Sex? = null
) {
    // TODO: 2/13/2021 Create DTO if it there will be a case to use it


}