package com.example.gatewayserver.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class ResponseTraceFilter implements GlobalFilter {

    private final static Logger logger = LoggerFactory.getLogger(ResponseTraceFilter.class);

    @Autowired
    FilterUtility filterUtility;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        String correlationId = filterUtility.getCorrelationId(headers);

        return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {
                    logger.debug("Updating correlation-id in the Response Header");
                    exchange.getResponse().getHeaders().add(FilterUtility.CORRELATION_ID_HEADER, correlationId);
                    }
                )
            );
    }
}
