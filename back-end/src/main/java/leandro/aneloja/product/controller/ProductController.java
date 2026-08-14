package leandro.aneloja.product.controller;

import jakarta.validation.Valid;
import leandro.aneloja.product.DTOs.Request.ProductRequestDTO;
import leandro.aneloja.product.DTOs.Response.ProductResponseDTO;
import leandro.aneloja.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "")
@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService service;

//    Listagem de produtos para painel e usuario
    @GetMapping
    public ResponseEntity<Page<ProductResponseDTO>> listProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(service.listProducts(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(service.findProductById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(
            @RequestBody @Valid ProductRequestDTO productDTO){
        service.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(
            @RequestBody @Valid ProductRequestDTO productDTO,
            @PathVariable Long id) {
        service.updateProduct(productDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}