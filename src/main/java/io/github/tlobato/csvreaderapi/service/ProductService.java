package io.github.tlobato.csvreaderapi.service;

import io.github.tlobato.csvreaderapi.entity.Product;
import io.github.tlobato.csvreaderapi.entity.dto.ProductDTO;
import io.github.tlobato.csvreaderapi.repository.ProductRepository;
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
        return mapper.map(productRepository.findByCodeIgnoreCase(code), ProductDTO.class);
    }
}