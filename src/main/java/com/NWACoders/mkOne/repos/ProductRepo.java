package com.NWACoders.mkOne.repos;

import com.NWACoders.mkOne.models.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Products, Integer> {
    public List<Products> findAll(Sort sort);
}
