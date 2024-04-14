package com.dokky.shop.api.pos.domain.product;

import org.springframework.data.jpa.repository.Query;

public interface ProductImageRepository {
    @Query( nativeQuery = true, value = "SELECT LPAD(NEXT VALUE FOR SQ_PRODUCT_IMG, 7, '0') FROM DUAL;" )
    String nextId();
}
