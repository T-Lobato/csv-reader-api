package io.github.tlobato.csvreaderapi.service;

import io.github.tlobato.csvreaderapi.entity.Product;
import io.github.tlobato.csvreaderapi.entity.dto.ProductDTO;
import io.github.tlobato.csvreaderapi.enums.ErrorCode;
import io.github.tlobato.csvreaderapi.exception.ProductNotFoundException;
import io.github.tlobato.csvreaderapi.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper mapper;

    @Transactional
    public Product save(ProductDTO productDTO) {
        return productRepository.save(mapper.map(productDTO, Product.class));
    }

    public ProductDTO getProductByCode(String code) {
        Product product = productRepository.findByCodeIgnoreCase(code);
        if (product != null) {
            return mapper.map(product, ProductDTO.class);
        } else {
            throw new ProductNotFoundException(ErrorCode.EC001.getMessage(), ErrorCode.EC001.getCode());
        }
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(p -> mapper.map(p, ProductDTO.class))
                .toList();
    }
}