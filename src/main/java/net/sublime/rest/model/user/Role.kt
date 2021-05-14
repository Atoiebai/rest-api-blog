package net.sublime.rest.model.user

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.util.stream.Collectors

enum class Role(
    private val permission: Set<Permission>
) {
    ADMIN(Permission.values().toSet()),
    USER(Permission.values().toSet());


    fun getAuthorities(): MutableSet<GrantedAuthority> {
        return permission.stream().map { x ->
            SimpleGrantedAuthority(x.permissions)
        }.collect(Collectors.toSet())
    }
}
