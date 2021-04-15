package com.NWACoders.mkOne.repos;

import com.NWACoders.mkOne.models.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Products, Integer> {
}
