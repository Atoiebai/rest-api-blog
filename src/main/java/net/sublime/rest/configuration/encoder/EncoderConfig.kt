package net.sublime.rest.configuration.encoder

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
open class EncoderConfig {
    @Bean
    open fun bcryptPasswordEncoder(): PasswordEncoder = BCryptPasswordEncoder(12)
}