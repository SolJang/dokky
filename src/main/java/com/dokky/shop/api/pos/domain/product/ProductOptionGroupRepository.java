package com.dokky.shop.api.pos.domain.product;

import com.dokky.shop.api.pos.infra.product.ProductOptionGroupRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductOptionGroupRepository extends JpaRepository<ProductOptionGroup, ProductOptionGroupId>, ProductOptionGroupRepositoryCustom {
    @Query( nativeQuery = true, value = "SELECT LPAD(NEXT VALUE FOR SQ_PRODUCT_OPTION_GROUP, 7, '0') FROM DUAL;" )
    String nextId();
}
