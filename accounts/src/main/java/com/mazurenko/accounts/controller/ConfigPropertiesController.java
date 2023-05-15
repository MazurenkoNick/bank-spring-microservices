package com.mazurenko.accounts.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mazurenko.accounts.config.AccountsServiceConfig;
import com.mazurenko.accounts.model.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/properties")
public class ConfigPropertiesController {

    @Autowired
    private AccountsServiceConfig accountsServiceConfig;

    @GetMapping("/details/")
    private String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(accountsServiceConfig);
        return ow.writeValueAsString(properties);
    }
}
