package com.dokky.shop.api.pos.infra.cherry;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class CherryConfiguration {

    private final WebClient webClient;

    @Bean(name = "cherryWebClient")
    public WebClient cherryWebclient() {
        return webClient.mutate()
                .defaultHeader( HttpHeaders.AUTHORIZATION, "Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL2Rldi1hcGkuY2hlcnJ5Zm9yY2Uua3IiLCJleHAiOjE4NzA1NjMwMzQsImlhdCI6MTcxMjg4MzAzNCwidXNlcklkIjoyNDA0MTExNDU3MTEwNjIxLCJqdGkiOiI3NjJmMWYyYy00NzA3LTQ3YmMtOTg2ZS0zZmI2ZWNhN2IyOTQifQ.dXfLrwT5rpvZsAuNfSe97yMfok5jPFp52pbJ0HHFukABnOziv4rf4L4I3DLw4uKlQrVwv8I1SjlFRPLQWrE-bE-_4CUh6HymXkmyG7rET9q5qSV5i5vBOnWvxiIHWRbF8mpm6T6ze9pYmTfTnm9C0gJ-WH5hIcWJyH8WmO3-CcnNoj9JsJRZGYxRZtNXaOSE-UBNQKbzrkksgostdIEX_WKnRKferpm4KNAp_pQsmY84PM71EPc0w6qwKdg2HAJMlDh21uHKYwSFFXlnWWdClovC1HTQqe8Z9U6IRef5fOttWv0_B8mgTS_7oe2QfS6V0sBRfdmO_ruBh30zKfNdgw" )
                .build();
    }
}
