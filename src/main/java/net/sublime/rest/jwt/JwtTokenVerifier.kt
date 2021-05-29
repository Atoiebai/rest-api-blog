package net.sublime.rest.jwt

import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import java.util.stream.Collectors
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class JwtTokenVerifier : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authorizationHeader = request.getHeader(AUTHORIZATION_HEADER)
        if (authorizationHeader.isNullOrEmpty() || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response)
            return
        }

        val token = authorizationHeader.replace("Bearer ", "")
        try {
            val claimsJws = Jwts.parserBuilder()
                .setSigningKey(
                    Keys.hmacShaKeyFor(
                        SECRET_KEY.toByteArray()
                    )
                )
                .build()
                .parseClaimsJws(token)
            val body = claimsJws.body
            val username = body.subject

            @Suppress("UNCHECKED_CAST")
            val authorities = body["authorities"] as List<Map<String, String>>?
            val simpleGrantedAuthority = authorities!!.stream()
                .map { m: Map<String, String> ->
                    SimpleGrantedAuthority(
                        m["authority"]
                    )
                }
                .collect(Collectors.toList())
            val authentication: Authentication = UsernamePasswordAuthenticationToken(
                username,
                null,
                simpleGrantedAuthority
            )
            SecurityContextHolder.getContext().authentication = authentication
        } catch (e: JwtException) {
            throw IllegalStateException("Token cant be truest $token")
        }
        filterChain.doFilter(request, response)
    }
}
