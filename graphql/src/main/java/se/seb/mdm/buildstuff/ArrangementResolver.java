package se.seb.mdm.buildstuff;

import com.coxautodev.graphql.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArrangementResolver implements GraphQLResolver<Arrangement> {

    private ProductService productService;

    @Autowired
    public ArrangementResolver(ProductService productService) {
        this.productService = productService;
    }

    public Product product(Arrangement arrangement) {
        return productService.getProduct(arrangement.getProductId());
    }
}
