//package clover.mlclover.config;
//
////import clover.mlclover.security.JWTAuthenticationFilter;
////import clover.mlclover.security.JWTAuthorizationFilter;
////import clover.mlclover.security.JWTUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private Environment env;
//
//    @Autowired
//    UserDetailsService userDetailsService;
//
//    @Autowired
//    JWTUtil jwtUtil;
//
//    public static final String[] PUBLIC_MATCHERS = {
//            "/h2-console/**",
//    };
//
//    public static final String[] PUBLIC_MATCHERS_GET = {
//            "/produtos/**",
//            "/categorias/**"
//    };
//
//    public static final String[] PUBLIC_MATCHERS_POST= {
//            "/clientes/**",
//            "/auth/forgot/**"
//    };
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        // se eu estiver no profile de teste, ele libera o H2 console
////        if(Arrays.asList(env.getActiveProfiles()).contains("test")){
////            http.headers().frameOptions().disable();
////        }
//        http.headers().frameOptions().disable();
//
//        // Liberar o CORS para que seja acessado pro outras aplicações e libera contra ataque CSRF
//        http.cors().and().csrf().disable();
//
//        // autoriza os PUBLIC_MATCHERS e solicita autenticação para qualquer outro endpoint
//        http.authorizeRequests()
//                .antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
//                .antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
//                .antMatchers(PUBLIC_MATCHERS).permitAll()
//                .anyRequest().authenticated();
//        http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
//        http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
//
//        // garante que não está gerando Stateless
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }
//
    // permite acesso de outras aplicações configurando o CORS
//    @Bean
//    CorsConfigurationSource corsConfigurationSource(){
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//        return source;
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception{
//        // especifico quem é o service e quem é o encoder
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
//    }

    // sistema terá disponível na forma de bean um componente  bCrypt que poderá ser injetado em qualquer classe do sistema
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//}
