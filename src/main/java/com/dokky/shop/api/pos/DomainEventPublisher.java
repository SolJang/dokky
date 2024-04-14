package com.dokky.shop.api.pos;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;

public class DomainEventPublisher {

    private static final Logger log = LoggerFactory.getLogger(DomainEventPublisher.class);

    private static ApplicationEventPublisher publisher;

    private DomainEventPublisher() {}

    public static void init(ApplicationEventPublisher publisher) {
        if(DomainEventPublisher.publisher == null) {
            DomainEventPublisher.publisher = publisher;
        }
    }

    public static void publish(@NonNull Object event) {
        String eventName = event.getClass().getSimpleName();

//        if(log.isDebugEnabled()){
//            log.debug("Publishing Event.. Type: '{}'", eventName);
//        }
        requiredPublisher().publishEvent(event);
    }

    private static ApplicationEventPublisher requiredPublisher() {
        if(publisher == null)
            throw new IllegalStateException("ApplicationEventPublisher must not be null.");

        return publisher;
    }
}
