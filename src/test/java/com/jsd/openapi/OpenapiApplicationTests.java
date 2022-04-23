package com.jsd.openapi;

import com.jsd.openapi.model.County;
import com.jsd.openapi.repository.CountyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//import org.junit.runner.RunWith;

@SpringBootTest
class OpenapiApplicationTests {

    @MockBean
    CountyRepository countyRepository;

    @Test
    void saveAllTest() {
        List<County> county = Arrays.asList(County.builder()
                .fips(14578)
                .state("AL")
                .name("Cowley")
                .build());

        when(countyRepository.saveAll(county)).thenReturn(county);
        assertEquals(1, countyRepository.saveAll(county).size());
    }
}
