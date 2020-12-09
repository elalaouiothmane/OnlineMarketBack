package com.example.market;

import com.example.market.Entities.Category;
import com.example.market.Entities.Product;
import com.example.market.Repository.CategoryRepository;
import com.example.market.Repository.ProductRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class MarketApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(MarketApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        categoryRepository.save(new Category(null,"Computers",null,null,null));
        categoryRepository.save(new Category(null,"Electromenager",null,null,null));
        categoryRepository.save(new Category(null,"Smart Phones",null,null,null));
        Random random = new Random();
        categoryRepository.findAll().forEach(c->{
            for (int i =0; i<15; i++){
                Product p = new Product();
                p.setName(RandomString.make(15));
                p.setCurrentPrice(50 + random.nextInt(1000));
                p.setSelected(random.nextBoolean());
                p.setAvailable(random.nextBoolean());
                p.setPromotion(random.nextBoolean());
                p.setPhotoName("unknown.png");
                p.setCategory(c);
                productRepository.save(p);
            }

        });
    }
}
