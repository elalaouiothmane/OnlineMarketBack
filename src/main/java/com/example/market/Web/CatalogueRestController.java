package com.example.market.Web;

import com.example.market.Entities.Category;
import com.example.market.Entities.Product;
import com.example.market.Metier.CategoryService;
import com.example.market.Metier.ProductService;
import com.example.market.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin("*")
@RestController
public class CatalogueRestController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/photoProduct/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable Long id) throws Exception{
        Product p = productRepository.findById(id).get();
        return  Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Market/products/"+p.getPhotoName()));

    }

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
}
