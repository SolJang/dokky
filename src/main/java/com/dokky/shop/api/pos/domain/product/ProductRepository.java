package com.dokky.shop.api.pos.domain.product;


import com.dokky.shop.api.pos.infra.product.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository< Product, ProductId >, ProductRepositoryCustom {
    @Query( nativeQuery = true, value = "SELECT LPAD(NEXT VALUE FOR SQ_PRODUCT, 7, '0') FROM DUAL;" )
    long nextId();
}
