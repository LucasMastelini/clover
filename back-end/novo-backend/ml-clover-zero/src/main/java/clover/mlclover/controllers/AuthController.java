//package clover.mlclover.controllers;
//
//import clover.mlclover.dtos.EmailDTO;
//import clover.mlclover.security.JWTUtil;
//import clover.mlclover.security.UserSS;
//import clover.mlclover.services.AuthService;
//import clover.mlclover.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping(value = "/auth")
//public class AuthController {
//
//    @Autowired
//    JWTUtil jwtUtil;
//
//    @Autowired
//    AuthService service;
//
//    @PostMapping("/refresh-token")
//    public ResponseEntity<Void> refreshToken(HttpServletResponse response){
//        UserSS user = UserService.authenticated();
//        String token = jwtUtil.generateToken(user.getUsername());
//        response.addHeader("Authorization", "Bearer " + token);
//        return ResponseEntity.status(204).build();
//    }
//
////    @PostMapping("/forgot")
////    public ResponseEntity<Void> esqueceuSenha(@Valid @RequestBody EmailDTO obj){
////
////        service.sendNewPassword(obj.getEmail());
////
////        return ResponseEntity.status(204).build();
////    }
//}
