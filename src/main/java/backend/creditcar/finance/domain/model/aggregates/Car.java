package backend.creditcar.finance.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.net.URL;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer year;

    private String color;

    private Float price;

    private String imageURL;

    public Car(String name, Integer year, String color, Float price, String imageURL) {
        this.name = name;
        this.year = year;
        this.color = color;
        this.price = price;
        this.imageURL = imageURL;
    }

    public Car(){}
}
