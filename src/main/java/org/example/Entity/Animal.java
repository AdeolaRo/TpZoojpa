package org.example.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private int id;
    private String name;
    private LocalDate arrival;
    private int age;
    @Enumerated
    private RegimeFood regimeFood;


}

