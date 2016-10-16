package com.ushara.dengigo.config.security;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    public void configurationDatabase(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/gnome/**").access("hasAnyRole('ROLE_ADMIN')")
                .and()
                .formLogin().defaultSuccessUrl("/", false)
                .loginPage("/login").permitAll()
                .loginProcessingUrl("/j_spring_security_check")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .failureUrl("/login?error=true")
//                .and()
//                    .requiresChannel()
//                        .antMatchers("/login").requiresSecure()
                .and()
                .rememberMe()
                .key("RememberMe").tokenValiditySeconds(60*60*24)
                .and()
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies()
                .and()
                .csrf().disable()
                .sessionManagement().maximumSessions(1).sessionRegistry(sessionRegistry());
    }

    @Bean
    public SessionRegistry sessionRegistry(){
        return new SessionRegistryImpl();
    }

}
