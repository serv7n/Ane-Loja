package leandro.aneloja.product.service;

import jakarta.transaction.Transactional;
import leandro.aneloja.product.DTOs.Request.ProductRequestDTO;
import leandro.aneloja.product.DTOs.Response.ProductResponseDTO;
import leandro.aneloja.product.mapper.ProductMapper;
import leandro.aneloja.product.model.Product;
import leandro.aneloja.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;
    public Page<ProductResponseDTO> listProducts(int page, int size) {
        Page<Product> products = repository.findAll(PageRequest.of(page, size));
        return products.map(mapper::toDTO);
    }

    @Transactional
    public void createProduct(ProductRequestDTO productDTO){
            Product p = mapper.toEntity(productDTO);
            repository.save(p);
    }
    @Transactional
    public void updateProduct(ProductRequestDTO pDTO, Long id){
        Product p = findProductOrThrow(id);

        p.setName(pDTO.name());
        p.setDescription(pDTO.description());
        p.setBasePrice(pDTO.basePrice());
    }
    private Product findProductOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
    @Transactional
    public void deleteProduct(Long id){
        Product p = findProductOrThrow(id);
        repository.delete(p);
    }
    public ProductResponseDTO findProductById(Long id){
        return mapper.toDTO(findProductOrThrow(id));
    }
}
