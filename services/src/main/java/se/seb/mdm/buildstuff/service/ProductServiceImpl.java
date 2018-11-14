package se.seb.mdm.buildstuff.service;

import com.github.javafaker.Faker;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.springframework.stereotype.Service;
import se.seb.mdm.buildstuff.Product;
import se.seb.mdm.buildstuff.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getProduct(String productId) {
        Faker faker = new Faker();
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName(faker.funnyName().name());
        product.setProductType(faker.finance().bic());
        return product;
    }
}
