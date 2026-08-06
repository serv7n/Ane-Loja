package leandro.aneloja.product.mapper;

import leandro.aneloja.product.DTOs.Request.VariantRequestDTO;
import leandro.aneloja.product.DTOs.Response.ImageResponseDTO;
import leandro.aneloja.product.DTOs.Response.VarianteResponseDTO;
import leandro.aneloja.product.model.ProductVariant;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VariantMapper {

    private final ImageMapper imageMapper;

    public VariantMapper(ImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    public VarianteResponseDTO toDTO(ProductVariant v) {

        List<ImageResponseDTO> images =
                imageMapper.safeList(v.getImages()).stream()
                        .map(imageMapper::toDTO)
                        .toList();

        return new VarianteResponseDTO(
                v.getColor(),
                v.getSize(),
                v.getPrice(),
                v.getStock(),
                images
        );
    }

    public ProductVariant toEntity(VariantRequestDTO dto){
        ProductVariant variant = new ProductVariant();
        variant.setSize(dto.size());
        variant.setColor(dto.color());
        variant.setPrice(dto.price());
        variant.setStock(dto.stock());
        return  variant;
    }
}