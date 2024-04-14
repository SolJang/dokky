package com.dokky.shop.api.pos.domain.category;


import com.dokky.shop.api.pos.domain.ShopId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryCreateService {

    private final CategoryRepository repository;

    public Category createdCategory( Long posCategoryCode, String name, Integer ordinal, ShopId shopId ) {

        Category category = Category.of( CategoryId.of( repository.nextId() ), name, ordinal, posCategoryCode, shopId );

        repository.save( category );

        return category;

    }
}
