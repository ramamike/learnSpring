package com.learn.SpringSecurity.rest;

import com.learn.SpringSecurity.model.Devoloper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/v1/developers")
public class DeveloperRestControllerV1 {

    private List<Devoloper> developers = Stream.of(
            new Devoloper(1l, "ivan", "ivanou"),
            new Devoloper(2l, "petr", "petrou"),
            new Devoloper(3l, "sidar", "sidarau")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Devoloper> getAll(){
        return developers;
    }

    @GetMapping("/{id}")
    public Devoloper getById(@PathVariable("id") Long id){
        return developers.stream().filter(devoloper -> devoloper.getId().equals(id))
                .findFirst().orElse(null);
    }

    @PostMapping
    public Devoloper create(@RequestBody Devoloper developer){
        this.developers.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        this.developers.removeIf(devoloper -> devoloper.getId().equals(id));
    }
}
