package com.jsd.openapi.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsd.openapi.exception.ResultNotFoundException;
import com.jsd.openapi.model.County;
import com.jsd.openapi.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class CountyService {
    private final CountyRepository countyRepository;

    public CountyService(CountyRepository countyRepository) {
        this.countyRepository = countyRepository;
    }

    public List<County> saveAll(Iterable<County> counties) {
        return countyRepository.saveAll(counties);
    }

    @PostConstruct
    public void initWithDataJsonFile() throws IOException {
        List<County> data = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(ResourceUtils.getFile("classpath:data/data.json"));
        node.forEach(i -> data.add(County.builder()
                .name(i.get("name").asText())
                .state(i.get("state").asText())
                .fips(i.get("fips").asInt())
                .build()));
         countyRepository.saveAll(data);
    }

    public List<County> findAllSuggestions(String name, String state) {
        return countyRepository.findAllSuggestions(name.toLowerCase(Locale.ROOT), state.toLowerCase(Locale.ROOT));
    }

    public List<County> findAllLikeName(String name) {
        return countyRepository.findAllLikeName(name.toLowerCase(Locale.ROOT));
    }

    public List<County> findAllByState(String state) {
        return countyRepository.findAllByState(state);
    }

    public List<County> analiseKeywordAndGetAllCountySuggestions(String keyword) throws ResultNotFoundException {
        String [] params = keyword.split(",");
        List<County> counties;
        if(params.length == 1) {
            counties = params[0].length() == 2
                    ? countyRepository.findAllByState(params[0])
                    : countyRepository.findAllLikeName(params[0]);
        } else {
            counties = countyRepository.findAllSuggestions(params[0], params[1]);
        }
        if(counties.isEmpty()) {
            throw new ResultNotFoundException("Result(s) not found using state or county : " + keyword);
        } else
            return counties;
    }
}
