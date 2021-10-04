package com.example.sneakyserver.controllers;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class ShoeController {
  @RequestMapping(value = "/api", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public String sendShoes() {
    String url = "https://v1-sneakers.p.rapidapi.com/v1/sneakers?limit=15";
    String charset = "UTF-8";
    String host = "v1-sneakers.p.rapidapi.com";
    String key = "324525e47dmshe4ac5f7930cff96p17f69cjsnd84de699ff4e>";

    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("x-rapidapi-host", "v1-sneakers.p.rapidapi.com")
            .header("x-rapidapi-key", "97138efc7dmsh4ffe9107d7be744p16626ejsnf9b9ca4489b6")
            .method("GET", HttpRequest.BodyPublishers.noBody())
            .build();
    try {
      HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
      System.out.println(response.body());
    } catch (Exception e) {
      System.out.println(e);
    }


    return "Greetings from Spring Boot!";
  }
}
