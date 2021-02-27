package net.sublime.rest.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@EnableWebSecurity
@Configuration
open class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
      http
          .csrf()
          .disable()
          .authorizeRequests()
          .antMatchers("/api/**")
          .permitAll()
          .anyRequest()
          .authenticated()
          
    }
}