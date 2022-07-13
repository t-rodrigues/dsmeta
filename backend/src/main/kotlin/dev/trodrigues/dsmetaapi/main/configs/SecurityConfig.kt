package dev.trodrigues.dsmetaapi.main.configs

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun filterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        httpSecurity.headers().frameOptions().disable()
        httpSecurity.cors().and().csrf().disable()
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        httpSecurity.authorizeHttpRequests { auth ->
            auth.anyRequest().permitAll()
        }
        return httpSecurity.build()
    }

    @Bean
    fun corsConfiguratjionSource(): UrlBasedCorsConfigurationSource {
        val configuration = CorsConfiguration().applyPermitDefaultValues()
        configuration.apply {
            allowedMethods = listOf("POST", "GET", "PUT", "DELETE", "OPTIONS")
        }
        val urlSource: UrlBasedCorsConfigurationSource = UrlBasedCorsConfigurationSource()
        urlSource.apply {
            registerCorsConfiguration("/**", configuration)
        }
        return urlSource
    }

}
