package com.board;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers(
						"/",
						"/login",
						"/join",
						"/js/**",
                        "/css/**",
                        "/img/**",
						"/webjars/**").permitAll()
				.antMatchers("/board/**").hasAuthority("MEMBER")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/authorized")
				.defaultSuccessUrl("/login_success")
				.failureUrl("/login_fail")
				.usernameParameter("id")
				.passwordParameter("password")
				.and()
			.logout()
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.and()
			.httpBasic();
	}
	@Bean
	public PasswordEncoder passworkEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
