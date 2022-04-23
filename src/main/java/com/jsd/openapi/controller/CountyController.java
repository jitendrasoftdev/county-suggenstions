package com.jsd.openapi.controller;

import com.jsd.openapi.exception.ResultNotFoundException;
import com.jsd.openapi.model.County;
import com.jsd.openapi.service.CountyService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/suggest")
public class CountyController {

    private final CountyService countyService;

    public CountyController(CountyService countyService) {
        this.countyService = countyService;
    }

    @PostMapping("/save")
    public List<County> saveAll(@RequestBody @Valid Iterable<County>  counties) {
        return countyService.saveAll(counties);
    }

    @GetMapping("{keyword}")
    public List<County> analiseKeywordAndGetAllCountySuggestions(@PathVariable String keyword) throws ResultNotFoundException {
        return countyService.analiseKeywordAndGetAllCountySuggestions(keyword);
    }

}
