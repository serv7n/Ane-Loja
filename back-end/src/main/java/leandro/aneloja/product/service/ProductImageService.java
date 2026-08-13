package leandro.aneloja.product.service;

import jakarta.transaction.Transactional;
import leandro.aneloja.product.DTOs.Response.ImageResponseDTO;
import leandro.aneloja.product.mapper.ImageMapper;
import leandro.aneloja.product.model.ProductImage;
import leandro.aneloja.product.model.ProductVariant;
import leandro.aneloja.product.repository.ProductImageRepository;
import leandro.aneloja.product.repository.ProductVariantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductImageService {
    private  final ProductImageRepository repository;
    private  final ProductVariantRepository variantRepository;
    private final ImageMapper imageMapper;

    public List<ProductImage> getAllImageWhereNotVariant(){
        return  repository.findByVariantIsNull();
    }
    private ProductVariant findVariantOrThrow(Long id) {
        return variantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Variant não encontrado"));
    }
    private ProductImage findImageOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image não encontrado"));
    }
    @Transactional
    public void setVariantImage(Long idImage, Long idVariant){
        ProductVariant variant = findVariantOrThrow(idVariant);
        ProductImage image = findImageOrThrow(idImage);
        variant.getImages().add(image);
        image.setVariant(variant);
    }

    @Transactional
    public void  deleteImage(Long id ){
        repository.delete(findImageOrThrow(id));
    }
    public ImageResponseDTO newImage(String imageUrl){
        ProductImage image = new ProductImage();
        image.setImageUrl(imageUrl);
        repository.save(image);
        return imageMapper.toDTO(image);
    }
}
