//package com.gulchan.manage.config;
/*
import com.gulchan.manage.security.UserDetailsServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsServiceImpl())
                        .passwordEncoder(new PasswordEncoder() {
                            @Override
                            public String encode(CharSequence rawPassword) {
                                return rawPassword.toString();
                            }

                            @Override
                            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                                return encodedPassword.equals(rawPassword.toString());
                            }
                        });
//                .inMemoryAuthentication()
//                .withUser("高骞").password("123456").roles("admin").and()
//                .withUser("刘亦菲").password("123456").roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").
        and() //2
                .authorizeRequests() //下面的都是授权的配置 3
                .antMatchers("/login").permitAll()//访问此地址就不需要进行身份认证了，防止重定向死循环
                .anyRequest() //任何请求 4
                .authenticated(); //访问任何资源都需要身份认证 5
//                .failureUrl("/login?error")
//                .defaultSuccessUrl("/home/index")
        super.configure(http);
    }
}
*/
