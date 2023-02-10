package io.github.tlobato.csvreaderapi.helper;

import com.opencsv.bean.CsvToBeanBuilder;
import io.github.tlobato.csvreaderapi.entity.dto.ProductDTO;
import io.github.tlobato.csvreaderapi.enums.ErrorCode;
import io.github.tlobato.csvreaderapi.exception.InvalidCSVException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class CsvReader {

    public List<ProductDTO> csvFileReader(MultipartFile file) {
        checkFileExtension(file);
        try (InputStreamReader reader = new InputStreamReader(file.getInputStream())) {
            return new CsvToBeanBuilder<ProductDTO>(reader)
                    .withType(ProductDTO.class)
                    .build()
                    .parse();

        } catch (IOException e) {
            throw new InvalidCSVException(ErrorCode.EC002.getMessage(), ErrorCode.EC002.getCode());
        }
    }

    private void checkFileExtension(MultipartFile file) {
        if (!file.getOriginalFilename().endsWith(".csv")) {
            throw new InvalidCSVException(ErrorCode.EC002.getMessage(), ErrorCode.EC002.getCode());
        }
    }
}