package com.rapidsystems.shop_service.service.s3;

import com.rapidsystems.shop_service.dto.UploadImageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@Service
@RequiredArgsConstructor
public class S3UploadService {

    private final S3Client s3Client;

    @Value("${s3.url}")
    private String s3url;

    public UploadImageResponse uploadFile(String bucketName,
                                          String key,
                                          MultipartFile file) {
        try {
            // Создание временного файла
            Path tempFile = Files.createTempFile("upload-", file.getOriginalFilename());
            file.transferTo(tempFile.toFile());

            // Загрузка файла в S3
            PutObjectResponse putObjectResponse = s3Client.putObject(
                    PutObjectRequest.builder()
                            .bucket(bucketName)
                            .key(key)
                            .acl("public-read")
                            .build(),
                    RequestBody.fromFile(tempFile)
            );

            log.info("File uploaded to S3: " + key);

            Files.deleteIfExists(tempFile);

            String fileUrl = s3url + bucketName + "/" + key;

            return UploadImageResponse.builder()
                    .name(key)
                    .url(fileUrl)
                    .build();
        } catch (IOException e) {
            log.error("Failed to upload file to S3: " + e.getMessage(), e);
            throw new RuntimeException("Failed to upload file to S3", e);
        }
    }

}
