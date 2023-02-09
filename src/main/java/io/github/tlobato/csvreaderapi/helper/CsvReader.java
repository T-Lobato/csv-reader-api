package io.github.tlobato.csvreaderapi.helper;

import com.opencsv.bean.CsvToBeanBuilder;
import io.github.tlobato.csvreaderapi.entity.dto.ProductDTO;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class CsvReader {

    public List<ProductDTO> csvFileReader(MultipartFile file)  {
        try (InputStreamReader reader = new InputStreamReader(file.getInputStream())) {
            return new CsvToBeanBuilder<ProductDTO>(reader)
                    .withType(ProductDTO.class)
                    .build()
                    .parse();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
