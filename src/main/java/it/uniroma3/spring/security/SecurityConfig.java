package it.uniroma3.spring.security;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .authorizeRequests()
        	.antMatchers("/",
   				 		 "/home",
   				 		 "/opera",
   				 		 "/author",
        				 "/css/**",
        				 "/images/**",
        				 "/js/**",
	                     "/**/favicon.ico",
	                     "/webjars/**").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/management")
            .permitAll()
            .and()
        .logout()
	        .invalidateHttpSession(true)
	        .logoutUrl("/logout")
	        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	        //.deleteCookies("JSESSIONID,SPRING_SECURITY_REMEMBER_ME_COOKIE")
	        .logoutSuccessUrl("/")
           .permitAll();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("pass").roles("USER");
    }
}