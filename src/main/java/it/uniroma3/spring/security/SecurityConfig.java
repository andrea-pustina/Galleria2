package it.uniroma3.spring.security;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
//    @Autowired
//    private DataSource dataSource;
// 
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.jdbcAuthentication().dataSource(dataSource)
//		
//		.passwordEncoder(new BCryptPasswordEncoder())
//		.usersByUsernameQuery("SELECT username,password,1 FROM users where username=?")
//		.authoritiesByUsernameQuery("SELECT username,authority FROM authorities where username=?");
//	}
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .authorizeRequests()
        	.antMatchers("/", "/index").permitAll()
        	.antMatchers("/css/**",
	                     "/js/**",
	                     "/img/**",
	                     "/**/favicon.ico",
	                     "/webjars/**").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/index")
            .permitAll()
            .and()
        .logout()
	        .invalidateHttpSession(true)
	        .logoutUrl("/logout")
	        .deleteCookies("JSESSIONID,SPRING_SECURITY_REMEMBER_ME_COOKIE")
	        .logoutSuccessUrl("/index")
           .permitAll();
        
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("pass").roles("USER");
    }
}