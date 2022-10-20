package terceirosemestre.clover.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;

// https://stackoverflow.com/questions/71281032/spring-security-exposing-authenticationmanager-without-websecurityconfigureradap

@Configuration
public class SecurityConfig {

    @Autowired
    private Environment env;





    private static final String[] PUBLIC_MATCHERS = {
            "/h2-console/**",
    };

    private static final String[] PUBLIC_MATCHERS_GET = {
            "/produtos/**",
            "/categorias/**",
            "/clientes/**"
    };



//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        if(Arrays.asList(env.getActiveProfiles()).contains("test")){
//            http.headers().frameOptions().disable();
//        }
//
//
//        http
//                // disable CSRF as we do not serve browser clients
//                .csrf().disable()
//                // allow access restriction using request matcher
//                .authorizeRequests()
//                // authenticate requests to GraphQL endpoint
//                .antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
//                .antMatchers(PUBLIC_MATCHERS).permitAll()
//                // allow all other requests
//                .anyRequest().permitAll().and()
//                // JWT authorization filter
//                .apply(new JWTHttpConfigurer(jwtUtil)).and()
//                // make sure we use stateless session, session will not be used to store user's state
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        return http.build();
//    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
//            http.headers().frameOptions().disable();
//        }
//
//        http.cors().and().csrf().disable();
//        http.authorizeRequests()
//                .antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
//                .antMatchers(PUBLIC_MATCHERS).permitAll()
//                .anyRequest().authenticated();
//              http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }


//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
//    }

//    @Bean
//    CorsConfigurationSource corsConfigurationSource(){
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//        return source;
//    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
//            throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }

//    @Autowired
//    public void configureGlobalSecurity(AuthenticationManagerBuilder authentication) throws Exception {
//        authentication.userDetailsService(userDetailsServiceBean());
//        //authentication.authenticationProvider(authenticationProvider());
//    }


}
