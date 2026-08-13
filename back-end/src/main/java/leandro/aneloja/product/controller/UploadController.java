package leandro.aneloja.product.controller;


import leandro.aneloja.product.DTOs.Response.ImageResponseDTO;
import leandro.aneloja.product.service.CloudinaryService;
import leandro.aneloja.product.service.ProductImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
@RequiredArgsConstructor
public class UploadController {

    private final CloudinaryService cloudinaryService;
    private final ProductImageService imageService;


    @PostMapping
    public ResponseEntity<ImageResponseDTO> upload(@RequestParam("file") MultipartFile file) {

        String urlImage = cloudinaryService.uploadImage(file);
        ImageResponseDTO response = imageService.newImage(urlImage);

        return ResponseEntity.ok(response);
    }
}