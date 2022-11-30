package clover.mlclover.controllers;

import clover.mlclover.dtos.*;
import clover.mlclover.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService service;

    // PRODUTOS

    @PostMapping("/produtos")
    public ResponseEntity<Void> cadastroProduto(@Valid @RequestBody ProdutoPostDTO obj){
        service.cadastroProduto(obj);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoDTO>> listaProdutos(){
        List<ProdutoDTO> produtos = service.listaProdutos();

        return produtos.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(produtos);
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Integer id){
        service.deleteProduto(id);
        return ResponseEntity.status(204).build();
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Void> updateProduto(@PathVariable Integer id, @RequestBody ProdutoPostDTO obj){
        service.updateProduto(id, obj);
        return ResponseEntity.status(204).build();

    }

    // CATEGORIAS

    @PostMapping("/categorias")
    public ResponseEntity<Void> cadastroCategoria(@RequestBody CategoriaPostDTO obj){
        service.cadastroCategoria(obj);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaDTO>> listaCategorias(){
        List<CategoriaDTO> categorias = service.listaCategorias();
        return categorias.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(categorias);
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Integer id){
        service.deleteCategoria(id);
        return ResponseEntity.status(204).build();
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<Void> updateCategoria(@PathVariable Integer id, @RequestBody CategoriaPostDTO obj){
        service.updateCategoria(id, obj);
        return ResponseEntity.status(204).build();
    }

    // SUBCATEGORIAS

    @PostMapping("/subcategorias")
    public ResponseEntity<Void> cadastroSubcategoria(@RequestBody SubcategoriaPostDTO obj){
        service.cadastroSubcategoria(obj);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/subcategorias")
    public ResponseEntity<List<SubcategoriaDTO>> listaSubcategorias(){
        List<SubcategoriaDTO> subcategorias = service.listaSubcategorias();
        return subcategorias.isEmpty() ? ResponseEntity.status(204).build() : ResponseEntity.status(200).body(subcategorias);
    }


    // ARQUIVOS

    @GetMapping("/gravar-arquivo-csv")
    public ResponseEntity<Void> gravarArquivoCsv() {
        return service.gerarArquivoCsv() ? ResponseEntity.status(200).build() : ResponseEntity.status(400).build();
    }

    @GetMapping("/gravar-arquivo-txt")
    public ResponseEntity<Void> gravarArquivoTxt() {

        service.gravarArquivoTxt();

        service.uploadFile(new File("arquivo.txt"), "txt");

        return ResponseEntity.status(200).build();

//        return service.gravarArquivoTxt() ? ResponseEntity.status(200).build() : ResponseEntity.status(400).build();
    }


    // S3


    @PostMapping("/file/upload")
    public ResponseEntity<String> uploadFile(
            @RequestParam(value = "file") MultipartFile file,
            @RequestParam(value = "idProduto") Integer idProduto,
            @RequestParam(value = "hexadecimal") String hexadecimal
    ){
        URI uri = service.uploadFile(file, idProduto, hexadecimal);
        return ResponseEntity.created(uri).build();
    }



    @GetMapping("/file")
    public List<String> getAllFiles(){
        return service.listAllFiles();
    }

    @GetMapping("/file/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName){
        byte[] data = service.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    @DeleteMapping("/file/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName){
        return new ResponseEntity<>(service.deleteFile(fileName), HttpStatus.OK);
    }
}
