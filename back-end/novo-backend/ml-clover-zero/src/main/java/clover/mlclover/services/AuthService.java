//package clover.mlclover.services;
//
//import clover.mlclover.entities.Cliente;
//import clover.mlclover.repositories.ClienteRepository;
//import clover.mlclover.services.exceptions.ObjectNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Random;
//
//@Service
//public class AuthService {
//
//    @Autowired
//    ClienteRepository clienteRepository;
//
//    @Autowired
//    BCryptPasswordEncoder encoder;
//
//
//    private Random rand = new Random();
//
//
////    public void sendNewPassword(String email){
////
////        Cliente cliente = clienteRepository.findByEmail(email);
////        if(cliente == null){
////            throw new ObjectNotFoundException("E-mail não encontrado");
////        }
////
////        String newPass = newPassword();
////        cliente.setSenha(encoder.encode(newPass));
////        clienteRepository.save(cliente);
////        emailService.sendNewPasswordEmail(cliente, newPass);
////    }
//
//    private String newPassword(){
//        char[] vet = new char[10];
//        for(int i = 0; i < vet.length; i++){
//            vet[i] = randomChar();
//        }
//        return new String(vet);
//    }
//
//    private char randomChar(){
//        int opt = rand.nextInt(3);
//        if(opt == 0){ // gera um dígito
//            return (char) (rand.nextInt(10) + 48);
//        }
//        else if (opt == 1) { // gera letra maiúscula
//            return (char) (rand.nextInt(26) + 65);
//        }
//        else{ // gera letra minúscula
//            return (char) (rand.nextInt(26) + 97);
//        }
//    }
//}
