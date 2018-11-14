package se.seb.mdm.buildstuff.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.seb.mdm.buildstuff.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@Slf4j
public class MasterDataController {

    private ArrangementService arrangementService;
    private CustomerService customerService;
    private ProductService productService;

    @Autowired
    public MasterDataController(
            ArrangementService arrangementService,
            CustomerService customerService,
            ProductService productService) {
        this.arrangementService = arrangementService;
        this.customerService = customerService;
        this.productService = productService;
    }

    @RequestMapping(value = "/customer/{customerId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Do a query for SEB customer information.")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Service request was successful " +
                            "and a response is returned."),
            @ApiResponse(code = 204,
                    message = "No content."),
            @ApiResponse(code = 500,
                    message = "An unexpected error " +
                            "in the service. ")
    })
    public ResponseEntity<Customer> getCustomer(
            @PathVariable("customerId") String customerId) {
        log.info("API GET /v1/customer/" + customerId);
        Customer customer = customerService.getCustomer(customerId);
        return ResponseEntity.ok().body(customer);
    }

    @RequestMapping(value = "/customer/{customerId}/arrangements",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Arrangement>> getArrangements(
            @PathVariable("customerId") String customerId) {
        log.info("API GET /v1/customer/" + customerId + "/arrangements");
        List<Arrangement> arrangements =
                arrangementService.getArrangements(customerId);
        return ResponseEntity.ok().body(arrangements);
    }

    @RequestMapping(value = "/product/{productId}/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProduct(
            @PathVariable("productId") String productId) {
        log.info("API GET /v1/product/" + productId);
        Product product = productService.getProduct(productId);
        return ResponseEntity.ok().body(product);
    }
}
