package com.dokky.shop.api.pos.domain.product;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductTreeRepository extends JpaRepository<ProductTree, ProductTreeId>, ProductTreeRepositoryCustom {
    @Query( nativeQuery = true, value = "SELECT LPAD(NEXT VALUE FOR SQ_PRODUCT_TREE, 7, '0') FROM DUAL;" )
    long nextId();
}
