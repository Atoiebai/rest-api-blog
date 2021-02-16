package net.sublime.rest.model.user

enum class Role(
    val permission: Set<Permission>
) {
    ADMIN(Permission.values().toSet()),
    USER(Permission.values().toSet());
}