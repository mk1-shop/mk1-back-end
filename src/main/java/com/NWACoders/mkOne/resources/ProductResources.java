package com.NWACoders.mkOne.resources;

import com.NWACoders.mkOne.models.Products;
import com.NWACoders.mkOne.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
@CrossOrigin(origins = "*")
public class ProductResources {

    //retrieving the services
    private final ProductServices productServices;

    @Autowired
    public ProductResources(ProductServices productServices) {
        this.productServices = productServices;
    }

    //when we go to this url address we want to get back a response with data
    //making th api call
    @GetMapping("/all")
    public ResponseEntity<Iterable<Products>> getAllAvaliableProducts(){
        //if we get a response then send the data back to the front end
        Iterable<Products> products = productServices.displayAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Products> findProductById(@PathVariable("id") int id){
        if(productServices.findProductById(id) == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Products foundProduct = productServices.findProductById(id);
        return new ResponseEntity<>(foundProduct, HttpStatus.OK);
    }

    //creating a request at products/add to take in information
    @PostMapping("/add")
    public ResponseEntity<Products> addProduct(@RequestBody Products products){
        //create a new product with information added to it
        Products newProduct = productServices.addNewProduct(products);
        if(newProduct.getDescription() == null || newProduct.getDescription().isEmpty()
                || newProduct.getName() == null || newProduct.getName().isEmpty()
                || newProduct.getImage() == null || newProduct.getImage().isEmpty()
                || Float.toString(newProduct.getPrice()) == null || Float.toString(newProduct.getPrice()).isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Products> editExistingProduct(@RequestBody Products products){
        Products updatedProduct = productServices.updateExistingProduct(products);
        if(updatedProduct.getDescription() == null || updatedProduct.getDescription().isEmpty()
                || updatedProduct.getName() == null || updatedProduct.getName().isEmpty()
                || updatedProduct.getImage() == null || updatedProduct.getImage().isEmpty()
                || Float.toString(updatedProduct.getPrice()) == null || Float.toString(updatedProduct.getPrice()).isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    //Deleting the product at products/delete/id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") int id){
        productServices.deletingExistingProducts(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
