package leandro.aneloja.product.mapper;

import leandro.aneloja.product.DTOs.Request.ProductRequestDTO;
import leandro.aneloja.product.DTOs.Response.ProductResponseDTO;
import leandro.aneloja.product.DTOs.Response.VarianteResponseDTO;
import leandro.aneloja.product.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {

    private final VariantMapper variantMapper;

    public ProductMapper(VariantMapper variantMapper) {
        this.variantMapper = variantMapper;
    }

    public ProductResponseDTO toDTO(Product p) {

        List<VarianteResponseDTO> variants =
                safeList(p.getVariants()).stream()
                        .map(variantMapper::toDTO)
                        .toList();

        return new ProductResponseDTO(
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getBasePrice(),
                variants
        );
    }

    private <T> List<T> safeList(List<T> list) {
        return list == null ? List.of() : list;
    }


    public Product  toEntity(ProductRequestDTO dto){
        Product p = new Product();
        p.setName(dto.name());
        p.setDescription(dto.description());
        p.setBasePrice(dto.basePrice());
        return p;
    }
}