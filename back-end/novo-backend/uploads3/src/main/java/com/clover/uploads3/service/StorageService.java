package com.clover.uploads3.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StorageService {
    @Value("${application.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;


    public URI uploadFile(MultipartFile file) {
        try {
            File fileObj = convertMultiPartFileToFile(file);
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            String contentType = file.getContentType();
            InputStream is = file.getInputStream();
            return uploadFile(is, fileName, contentType);
        } catch (IOException e) {
            throw  new RuntimeException("Erro de IO: " + e.getMessage());
        }
            //s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
            // fileObj.delete();

    }


    public URI uploadFile(InputStream is, String fileName, String contentType){
        try {
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentType(contentType);
        s3Client.putObject(bucketName, fileName, is, meta);
        return s3Client.getUrl(bucketName, fileName).toURI();
        } catch (URISyntaxException e) {
           throw  new RuntimeException("Erro ao converter URL para URI");
        }
    }



    public byte[] downloadFile(String fileName){
       S3Object s3Object = s3Client.getObject(bucketName, fileName);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        try {
           byte[] content =  IOUtils.toByteArray(inputStream);
           return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deleteFile(String fileName){
        s3Client.deleteObject(bucketName,fileName);
        return fileName +" removed...";
    }

    public List<String> listAllFiles(){
        ListObjectsV2Result listObjectsV2Result = s3Client.listObjectsV2(bucketName);
        return listObjectsV2Result.getObjectSummaries().stream().map(S3ObjectSummary::getKey).collect(Collectors.toList());
    }

    private File convertMultiPartFileToFile(MultipartFile file){
        File convertedFile = new File(file.getOriginalFilename());
        try(FileOutputStream fos = new FileOutputStream(convertedFile)){
            fos.write(file.getBytes());
        } catch (IOException e){
            log.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }
}
