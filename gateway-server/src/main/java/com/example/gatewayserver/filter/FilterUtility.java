package com.example.gatewayserver.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Component
public class FilterUtility {

    protected final static String CORRELATION_ID_HEADER = "eazybank-correlation-id";


    public String getCorrelationId(HttpHeaders requestHeaders) {
        if (requestHeaders.get(CORRELATION_ID_HEADER) != null) {
            List<String> requestHeaderList = requestHeaders.get(CORRELATION_ID_HEADER);
            return requestHeaderList.get(0);
        }
        return null;
    }

    public ServerWebExchange setRequestHeader(ServerWebExchange exchange, String headerName, String headerValue) {
        return exchange
                .mutate()
                .request(exchange.getRequest()
                                .mutate()
                                .header(headerName, headerValue)
                                .build())
                .build();
    }

    public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId) {
        return this.setRequestHeader(exchange, CORRELATION_ID_HEADER, correlationId);
    }
}
