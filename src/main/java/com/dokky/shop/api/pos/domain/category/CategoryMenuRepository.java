package com.dokky.shop.api.pos.domain.category;


import com.dokky.shop.api.pos.infra.category.CategoryMenuRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryMenuRepository extends JpaRepository<CategoryMenu, CategoryMenuId>, CategoryMenuRepositoryCustom {
}
