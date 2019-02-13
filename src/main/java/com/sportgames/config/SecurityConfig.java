package com.sportgames.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@ComponentScan("com.sportgames")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;

//    @Autowired
//    private  AppAuthenticationSuccessHandler appAuth;

        private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//    @Bean
//    public DaoAuthenticationProvider authProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
//        return authProvider;
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return passwordEncoder;
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/registration","/css/**","/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
               // .successHandler(appAuth)
                .usernameParameter("user")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .permitAll();
//                        .defaultSuccessUrl("/", true);

    }

//    @Configuration
//    protected static class AuthenticationConfiguration extends
//            GlobalAuthenticationConfigurerAdapter {
//
////        @Override
////        public void init(AuthenticationManagerBuilder auth) throws Exception {
////            auth
////                    .inMemoryAuthentication()
////                    .withUser("user").password("password").roles("USER");
////        }
//
//    }
}


//=============================
//    @Autowired
//    @Qualifier("userDetailsService")
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private AppAuthenticationSuccessHandler appHandler;
//
//    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authProvider());
//    }
//
//
//    @Bean
//    public DaoAuthenticationProvider authProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
//        return authProvider;
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return passwordEncoder;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http
//////                .csrf().disable() uncomment for test
////                .authorizeRequests()
////                .antMatchers("/", "/login").permitAll()
////                .antMatchers("/welcome/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
////                .antMatchers("/registration").hasAnyAuthority( "ROLE_ADMIN")
////                .and()
////                .exceptionHandling().accessDeniedPage("/error")
////                .and();
////
////        http
////                .formLogin()
////                // указываем страницу с формой логина
////                .loginPage("/login")
////                .successHandler(appHandler)
////                // указываем action с формы логина
//////                .loginProcessingUrl("/j_spring_security_check")
////                // указываем URL при неудачном логине
////                .failureUrl("/login?error")
////                // Указываем параметры логина и пароля с формы логина
////                .usernameParameter("user")
////                .passwordParameter("password")
////                // даем доступ к форме логина всем
////                .permitAll();
//
////        http
////                .logout()
////                // разрешаем делать логаут всем
////                .permitAll()
////                // указываем URL логаута
////                .logoutUrl("/logout")
////                // указываем URL при удачном логауте
////                .logoutSuccessUrl("/login?logout")
////                // делаем не валидной текущую сессию
////                .invalidateHttpSession(true);
//
////        http.logout()
////                .permitAll()
////                .logoutUrl("/logout")
////                .logoutSuccessUrl("/")
////                .invalidateHttpSession(true);
//
//        http
//                 .authorizeRequests()
//                .antMatchers("/registration","/css/**","/js/**").permitAll()
//                .antMatchers("/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
//                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//                .anyRequest().authenticated()
//                .and().formLogin()
//                .permitAll()
//                .loginPage("/login")
//                .usernameParameter("user")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/", true);
////                .loginProcessingUrl("/auth");
////        http
////                .formLogin()
////                // указываем страницу с формой логина
////                .loginPage("/login")
////                .successHandler(appHandler)
////                // указываем action с формы логина
////            //    .loginProcessingUrl("/j_spring_security_check")
////                // указываем URL при неудачном логине
////                .failureUrl("/login?error")
////                // Указываем параметры логина и пароля с формы логина
////                .usernameParameter("user")
////                .passwordParameter("password")
////                // даем доступ к форме логина всем
////                .permitAll();
//    }

