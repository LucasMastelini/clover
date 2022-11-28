package clover.mlclover.resources;

import clover.mlclover.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminResource {

    @Autowired
    ClienteService service;

    @GetMapping("/gravar-arquivo-csv")
    public ResponseEntity<Void> gravarArquivoCsv() {
        return service.gerarArquivoCsv() ? ResponseEntity.status(200).build() : ResponseEntity.status(400).build();
    }

    @GetMapping("/gravar-arquivo-txt")
    public ResponseEntity<Void> gravarArquivoTxt() {
        return service.gravarArquivoTxt() ? ResponseEntity.status(200).build() : ResponseEntity.status(400).build();
    }

}
