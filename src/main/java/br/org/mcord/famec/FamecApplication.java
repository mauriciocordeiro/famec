package br.org.mcord.famec;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import br.org.mcord.famec.config.JWTAuthorizationFilter;

@SpringBootApplication
public class FamecApplication extends SpringBootServletInitializer {
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	       return application.sources(FamecApplication.class);
	    }

	public static void main(String[] args) {
		SpringApplication.run(FamecApplication.class, args);
	}
	
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/api/login", "/api/init").permitAll()
				.anyRequest();
			
			http.cors().configurationSource(new CorsConfigurationSource() {
	            @Override
	            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
	                return new CorsConfiguration().applyPermitDefaultValues();
	            }
	        });
		}
		
//		@Autowired
//	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	        auth
//	            .inMemoryAuthentication()
//	                .withUser("user").password("password").roles("USER");
//	    }
	}

}
