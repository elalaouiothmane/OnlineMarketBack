package com.example.market.Repository;

import com.example.market.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface ProductRepository extends JpaRepository<Product,Long> {
    @RestResource(path = "selectedProducts")
    public List<Product> findBySelectedIsTrue();

    @RestResource(path = "productsByKeyword")
    public List<Product> findByNameContains(@Param("name") String mc);

}
