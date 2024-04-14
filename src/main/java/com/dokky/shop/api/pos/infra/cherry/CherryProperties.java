package com.dokky.shop.api.pos.infra.cherry;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
@ConfigurationProperties(prefix = "infra.external.cherry")
@Getter @Setter
public class CherryProperties {
    URI categoryUrl;
    URI productUrl;
}
