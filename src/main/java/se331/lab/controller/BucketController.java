package se331.lab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import se331.lab.util.CloudStorageHelper;

import javax.servlet.ServletException;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class BucketController {
    private final CloudStorageHelper cloudStorageHelper;

    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestPart(value = "file") MultipartFile file)
            throws IOException, ServletException {
        // ใช้ bucket name ของ Firebase
        String bucketName = "component-based-lab.appspot.com";

        String imageUrl = cloudStorageHelper.uploadFile(file, bucketName);

        return ResponseEntity.ok(imageUrl);
    }
}
