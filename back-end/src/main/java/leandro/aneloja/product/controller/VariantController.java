package leandro.aneloja.product.controller;

import leandro.aneloja.product.DTOs.Request.VariantRequestDTO;
import leandro.aneloja.product.DTOs.Response.VarianteResponseDTO;
import leandro.aneloja.product.service.VariantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/variants")
@AllArgsConstructor
public class VariantController {

    private final VariantService variantService;

    @PostMapping("/products/{idProduct}/variants")
    public ResponseEntity<Void> createProductVariants(
            @PathVariable Long idProduct,
            @RequestBody VariantRequestDTO variantRequestDTO) {
        variantService.createProductVariant(idProduct, variantRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/products/{idProduct}/variants")
    public ResponseEntity<List<VarianteResponseDTO>> listVariantsByProduct(
            @PathVariable Long idProduct) {
        return ResponseEntity.ok(variantService.listVariantsByProduct(idProduct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVariant(@PathVariable Long id) {
        variantService.deleteVariant(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<VarianteResponseDTO> updateVariant(
            @PathVariable Long id,
            @RequestBody VariantRequestDTO dto) {
        return ResponseEntity.ok(variantService.updateVariant(id, dto));
    }
}