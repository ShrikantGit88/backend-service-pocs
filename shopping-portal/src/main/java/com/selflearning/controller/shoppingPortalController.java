package com.selflearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/shopping")
public class shoppingPortalController {

    @Autowired
    public RestTemplate restTemplate;

    @Value("${spring.serviceProvider.url}")
    public String paymentServiceUrl;

    @GetMapping("/order-request/itemId/{itemId}/price/{price}")
    public String buyProduct(@PathVariable int itemId, @PathVariable int price) {
        String url = "http://"+paymentServiceUrl+""+ price;
        System.out.println("url "+url);
        System.out.println("Shopping done for itemId "+itemId);
        return restTemplate.getForObject(url, String.class);
    }

}
