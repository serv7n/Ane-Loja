package leandro.aneloja.product.service;

import jakarta.transaction.Transactional;
import leandro.aneloja.product.DTOs.Request.VariantRequestDTO;
import leandro.aneloja.product.DTOs.Response.VarianteResponseDTO;
import leandro.aneloja.product.mapper.VariantMapper;
import leandro.aneloja.product.model.Product;
import leandro.aneloja.product.model.ProductVariant;
import leandro.aneloja.product.repository.ProductRepository;
import leandro.aneloja.product.repository.ProductVariantRepository;
import leandro.aneloja.shared.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VariantService {
    private  final ProductRepository productRepository;
    private  final ProductVariantRepository productVariantRepository;
    private final VariantMapper mapper;
        private Product findProductOrThrow(Long id) {
            return productRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
        }
        @Transactional
        public VarianteResponseDTO createProductVariant(Long idProduct, VariantRequestDTO variantRequestDTO){
            Product p = findProductOrThrow(idProduct);
            ProductVariant variant = mapper.toEntity(variantRequestDTO);
            variant.setProduct(p);
            p.getVariants().add(variant);
            productVariantRepository.save(variant);
            return mapper.toDTO(variant);
        }

        public   List<VarianteResponseDTO> listVariantsByProduct(Long id){
            Product p = findProductOrThrow(id);
            List<VarianteResponseDTO> variantDTO = p.getVariants().stream().map(mapper::toDTO).toList();
            return variantDTO;
        }

        @Transactional
        public VarianteResponseDTO updateVariant(Long id, VariantRequestDTO dto){
            ProductVariant  v  = findVariantByIdOrThrow(id);
            v.setSize(dto.size());
            v.setStock(dto.stock());
            v.setPrice(dto.price());
            v.setColor(dto.color());
            return mapper.toDTO(v);
        }
        @Transactional
        public void deleteVariant(Long id){
            ProductVariant v = findVariantByIdOrThrow(id);
            productVariantRepository.delete(v);
        }
        public ProductVariant findVariantByIdOrThrow(Long id){
            return productVariantRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Variant não encontrado"));
        }

}
