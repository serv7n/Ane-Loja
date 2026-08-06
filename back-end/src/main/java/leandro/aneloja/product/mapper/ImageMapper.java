package leandro.aneloja.product.mapper;

import leandro.aneloja.product.DTOs.Response.ImageResponseDTO;
import leandro.aneloja.product.model.ProductImage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImageMapper {

    public ImageResponseDTO toDTO(ProductImage i) {
        return new ImageResponseDTO(
                i.getIsMain(),
                i.getImageUrl()
        );
    }

    protected <T> List<T> safeList(List<T> list) {
        return list == null ? List.of() : list;
    }
}