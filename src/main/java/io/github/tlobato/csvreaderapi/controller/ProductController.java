package io.github.tlobato.csvreaderapi.controller;

import com.opencsv.bean.CsvToBeanBuilder;
import io.github.tlobato.csvreaderapi.entity.dto.ProductDTO;
import io.github.tlobato.csvreaderapi.service.ProductService;
import java.io.InputStreamReader;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @SneakyThrows
    @PostMapping("/create-product")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestParam("file") MultipartFile file) {
        InputStreamReader reader = new InputStreamReader(file.getInputStream());
        List<ProductDTO> beans = new CsvToBeanBuilder(reader)
                .withType(ProductDTO.class)
                .build()
                .parse();

        beans.stream().map(productService::save).toList();
        reader.close();
    }
}