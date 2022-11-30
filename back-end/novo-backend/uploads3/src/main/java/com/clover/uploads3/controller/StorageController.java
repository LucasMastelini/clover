package com.clover.uploads3.controller;

import com.clover.uploads3.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/file")
public class StorageController {

    @Autowired
    private StorageService service;

//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file){
//        return new ResponseEntity<>(service.uploadFile(file), HttpStatus.OK);
//    }

    @PostMapping("/file/upload")
    public ResponseEntity<String> uploadFile(
            @RequestParam(value = "file") MultipartFile file,
            @RequestParam(value = "idProduto") Integer id,
            @RequestParam(value = "hexadecimal") String hexadecimal
    ){
        URI uri = service.uploadFile(file);
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
