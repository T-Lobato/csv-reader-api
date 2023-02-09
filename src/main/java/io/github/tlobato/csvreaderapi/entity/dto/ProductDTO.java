package io.github.tlobato.csvreaderapi.entity.dto;

import com.opencsv.bean.CsvBindByName;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @CsvBindByName(column = "NAME")
    private String name;

    @CsvBindByName(column = "CATEGORY")
    private String category;

    @CsvBindByName(column = "PRICE")
    private BigDecimal price;

    @CsvBindByName(column = "QUANTITY")
    private Integer quantity;
}