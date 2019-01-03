package tatun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    UserDetailsService userDetailsService;
//
//    @Autowired
//    public PasswordEncoder passwordEncoder;
//
//    private void configAuthenticaton(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests().antMatchers(HttpMethod.GET,"/category/*")
//                .hasAuthority("admin")
//                .and()
//                .formLogin().loginPage("/login")
//                .loginProcessingUrl("/login")
//                .usernameParameter("login")
//                .passwordParameter("password")
//                .failureUrl("/loginfailed")
//                .and()
//                .logout()
//                .logoutSuccessUrl("/")
//                .and()
//                .csrf().disable();
//    }

}
