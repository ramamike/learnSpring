package com.spring.microservices.moviecatalogservice.resources;

import com.spring.microservices.moviecatalogservice.models.CatalogItem;
import com.spring.microservices.moviecatalogservice.models.Movie;
import com.spring.microservices.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    private RestTemplate restTemplate;

    private WebClient.Builder webClientBuilder;
    @Autowired
    public MovieCatalogResource(RestTemplate restTemplate,
                                WebClient.Builder webClientBuilder) {
        this.restTemplate = restTemplate;
        this.webClientBuilder=webClientBuilder;
    }

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        WebClient.Builder builder=WebClient.builder();


        List<Rating> ratings= Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 3)
        );

        return ratings.stream().map(rating -> {
            Movie movie =restTemplate.getForObject("http://localhost:8083/movies/" + rating.getMovieId(),
                    Movie.class);
            return new CatalogItem(movie.getName(), "testDescr", rating.getRating());
        })
                .collect(Collectors.toList());
    }
}
