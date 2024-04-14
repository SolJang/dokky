package com.dokky.shop.api.pos.domain.category;


import com.dokky.shop.api.pos.infra.category.CategoryRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, CategoryId>, CategoryRepositoryCustom {
    @Query( nativeQuery = true, value = "SELECT LPAD(NEXT VALUE FOR SQ_CATEGORY, 7, '0') FROM DUAL; " )
    long nextId();
}
