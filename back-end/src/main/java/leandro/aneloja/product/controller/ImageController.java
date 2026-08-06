package leandro.aneloja.product.controller;

import leandro.aneloja.product.model.ProductImage;

import leandro.aneloja.product.service.ProductImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
@AllArgsConstructor
public class ImageController {

    private final ProductImageService service;
//    todos os produtos sem variantes para serem selecionados
    @GetMapping("")
    public ResponseEntity<List<ProductImage>> getAllImageWhereNotVariant() {
        return ResponseEntity.ok(service.getAllImageWhereNotVariant());
    }

    @PostMapping("/{idImage}/variant/{idVariant}")
    public ResponseEntity<Void> setVariantImage(
            @PathVariable Long idImage,
            @PathVariable Long idVariant) {

        service.setVariantImage(idImage, idVariant);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        service.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}