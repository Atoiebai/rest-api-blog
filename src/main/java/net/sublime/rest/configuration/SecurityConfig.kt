package net.sublime.rest.configuration

import net.sublime.rest.configuration.encoder.EncoderConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService


@EnableWebSecurity
@Configuration
open class SecurityConfig(
    private val userDetailsService: UserDetailsService,
    private val passwordEncoder: EncoderConfig
) : WebSecurityConfigurerAdapter() {


    override fun configure(http: HttpSecurity) {
        http
            .csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/api/blog/users/create", "/api/blog/users")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()

    }

    @Bean
    protected open fun daoAuthenticationProvider(): DaoAuthenticationProvider? {
        val daoAuthenticationProvider = DaoAuthenticationProvider()
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder.bcryptPasswordEncoder())
        daoAuthenticationProvider.setUserDetailsService(userDetailsService)
        return daoAuthenticationProvider
    }


}
