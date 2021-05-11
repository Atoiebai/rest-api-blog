package net.sublime.rest.model.user

enum class Permission(
    val permissions: String
    ) {

    CAN_READ("can:read"),
    CAN_WRITE("can:write"),
    CAN_POST("can:post"),
    CAN_DELETE("can:delete"),
    CAN_MANAGE_USERS("can:manage:users"),
    CAN_MANAGE_ADMINS("can:manage:admins");

}