package org.showroom.showroom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.support.HttpHeaders;

import java.util.function.Supplier;

@Configuration
public class Config extends ElasticsearchConfiguration {

    @Override
    public ClientConfiguration clientConfiguration() {

        HttpHeaders compatibilityHeaders = new HttpHeaders();

        Supplier<HttpHeaders> headersSupplier = () -> compatibilityHeaders;

        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .withHeaders(headersSupplier)
                .build();
    }
}
