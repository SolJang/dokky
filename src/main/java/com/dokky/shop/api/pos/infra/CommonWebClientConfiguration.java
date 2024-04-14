package com.dokky.shop.api.pos.infra;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Configuration
@RequiredArgsConstructor
public class CommonWebClientConfiguration {
    @Bean
    @Primary
    public WebClient commonWebClient() {
        ConnectionProvider provider = ConnectionProvider.builder("provider")
                .maxConnections(200)
                .maxIdleTime( Duration.ofSeconds(60))
                .maxLifeTime(Duration.ofSeconds(60))
                .pendingAcquireTimeout(Duration.ofSeconds(0))
                .pendingAcquireMaxCount(-1)
                .build();

        HttpClient httpClient = HttpClient.create(provider)
                .option( ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
                .responseTimeout(Duration.ofMillis(8000))
                .doOnConnected(connection ->
                        connection.addHandlerLast(new ReadTimeoutHandler(8000, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(8000, TimeUnit.MILLISECONDS)));

        ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);

        return WebClient.builder()
                .defaultHeader( HttpHeaders.ACCEPT, APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .clientConnector(connector)
                .build();
    }
}
