package lian.sample.productapi.model.entiity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private int quantity;
    private long price;
    private String description;
    private boolean isUsed;
    @OneToMany(mappedBy = "product")
    private List<ProductItem> itemList;

    @Builder.Default
    @CreatedDate
    private Instant created = Instant.now();
    @Builder.Default
    @LastModifiedDate
    private Instant updated = Instant.now();
    private Instant deleted;
}
