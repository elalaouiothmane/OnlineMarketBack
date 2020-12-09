package com.example.market.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Category implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String photoCategory;
    @OneToMany(mappedBy = "category")
    private Collection<Product> products;
}
