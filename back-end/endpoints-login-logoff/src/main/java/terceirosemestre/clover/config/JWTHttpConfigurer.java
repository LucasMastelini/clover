//package terceirosemestre.clover.config;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//import terceirosemestre.clover.security.JWTAuthenticationFilter;
//import terceirosemestre.clover.security.JWTAuthorizationFilter;
//import terceirosemestre.clover.security.JWTUtil;
//
//@Component
//public class JWTHttpConfigurer extends AbstractHttpConfigurer<JWTHttpConfigurer, HttpSecurity> {
//
//    private final JWTUtil jwtUtil;
//
//    @Autowired
//    UserDetailsService userDetailsService;
//
//
//    public JWTHttpConfigurer(JWTUtil jwtTokenUtils) {
//        this.jwtUtil = jwtTokenUtils;
//    }
//
//
//    @Override
//    public void configure(HttpSecurity http) {
//        final AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
//
//        http.antMatcher("/**").addFilter(new JWTAuthenticationFilter(authenticationManager, jwtUtil))
//                .addFilter(new JWTAuthorizationFilter(authenticationManager, jwtUtil, userDetailsService));
//    }
//}