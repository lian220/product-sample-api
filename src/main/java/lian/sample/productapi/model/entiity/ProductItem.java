package lian.sample.productapi.model.entiity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Entity
@Data
public class ProductItem {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productItemId;

    private String name;
    private int quantity;
    private long price;
    private String description;
    private boolean isUsed;

    @CreatedDate
    private Instant created = Instant.now();
    @LastModifiedDate
    private Instant updated = Instant.now();
    private Instant deleted;
}
