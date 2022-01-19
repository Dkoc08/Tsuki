package com.ogusuku.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import com.ogusuku.demo.models.service.UsuarioServiceImpl;
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioServiceImpl userSerive;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/dashboard/css/bootstrap.min.css","/dashboard/css/estilos.css",
				"/dashboard/js/jquery-3.5.1.min.js","/dashboard/js/bootstrap.bundle.min.js",
				"/dashboard/imagenes/**","/dashboard/fonts/**").permitAll()
		//.antMatchers("/usuarios/**").hasAnyRole("ADMIN")
		.antMatchers("/categoria/**","/usuarios/**","/distrito/**").hasAnyRole("ADMIN")
		.antMatchers().hasAnyRole("USER")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/autenticacion/").defaultSuccessUrl("/dashboard",true) .permitAll()
		.and()
		.logout().permitAll();
		
	}
	
	@Override

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userSerive).passwordEncoder(passwordEncoder);
		
	}

}
