package com.dokky.shop.api.pos.infra.cherry;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CherryApi {
    private final WebClient webClient;
    private final CherryProperties properties;

    public CherryApi( CherryProperties properties, @Qualifier( "cherryWebClient" ) WebClient webClient ) {
        this.properties = properties;
        this.webClient = webClient;
    }


    public List< CherryCategoryResponse.Category > getCategories() {

        // TODO : store id 동적으로 변경
        Mono< CherryCategoryResponse > mono = webClient.get()
                .uri( properties.getCategoryUrl() + "?storeId=415" )
                .retrieve()
                .bodyToMono( CherryCategoryResponse.class );

        mono.subscribe(
                response -> {
                    System.out.println( response );
                },
                throwable -> {

                }
        );

        CherryCategoryResponse category = mono.block();

        return category.categories();
    }

    public List< CherryTitlesResponse.Title > getTitlesAndProducts( Long categoryId ) {
        // TODO : category id, store id 동적으로 변경
        Mono< CherryTitlesResponse > mono = webClient.get()
                .uri( properties.getCategoryUrl() + "/" + categoryId + "/titles/products?storeId=415" )
                .retrieve()
                .bodyToMono( CherryTitlesResponse.class );

        mono.subscribe(
                response -> {

                },
                throwable -> {

                }
        );

        return mono.block().titles();
    }

    public List< CherryProductResponse.OptionGroup > getOptionGroups( Long productId ) {
        Mono< CherryProductResponse > mono = webClient.get()
                .uri( properties.getProductUrl() + "/" + productId )
                .retrieve()
                .bodyToMono( CherryProductResponse.class );

        mono.subscribe(
                response -> {

                },
                throwable -> {

                }
        );

        return mono.block().optionGroups();
    }
}
