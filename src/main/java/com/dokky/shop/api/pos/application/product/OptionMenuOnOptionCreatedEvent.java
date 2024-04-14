package com.dokky.shop.api.pos.application.product;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OptionMenuOnOptionCreatedEvent {

    private final OptionMenuRepository repository;
    @EventListener
    public void createOptionMenu() {
        ProductOptionMenu

    }
}
