package leandro.aneloja.product.DTOs.Request;

import leandro.aneloja.product.enuns.Color;

import java.math.BigDecimal;

public record VariantRequestDTO(
        Color color,
         String size,
         BigDecimal price,
         Integer stock
) {
}
