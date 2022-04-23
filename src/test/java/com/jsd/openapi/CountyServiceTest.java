package com.jsd.openapi;


import com.jsd.openapi.exception.ResultNotFoundException;
import com.jsd.openapi.service.CountyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CountyServiceTest {
    @Autowired
    CountyService countyService;

    /* output according to spec.yaml
        q=cowlitz, wa:
        value:
      - fips: '53015'
        state: WA
        name: Cowlitz
    */

    @Test
    void getAllSuggestionsTest() {
        assertEquals(1, countyService.findAllSuggestions("cowlitz", "wa").size());
    }

    /*  output according to spec.yaml
        q=cowl:
        value:
      - fips: '20035'
        state: KS
        name: Cowley
      - fips: '53015'
        state: WA
        name: Cowlitz
    */

    @Test
    void findAllLikeNameTest() {
        assertEquals(2, countyService.findAllLikeName("cowl").size());
    }
    /*
    q=wa:
    value:
  - fips: '53001'
    state: WA
    name: Adams
  - fips: '53003'
    state: WA
    name: Asotin
  - fips: '53005'
    state: WA
    name: Benton
  - fips: '53007'
    state: WA
    name: Chelan
  - fips: '53009'
    state: WA
    name: Clallam
    */

    @Test
    void findAllByStateTest() {
        assertEquals(5, countyService.findAllByState("wa").size());
    }

    @Test
    void analiseKeywordAndGetAllCountySuggestionsTest() throws ResultNotFoundException {
        String keyword = "cowlitz, wa";
        String keyword2 = "cowl";
        String keyword3 = "wa";
        assertEquals(1, countyService.analiseKeywordAndGetAllCountySuggestions(keyword).size());
        assertEquals(2, countyService.analiseKeywordAndGetAllCountySuggestions(keyword2).size());
        assertEquals(5, countyService.analiseKeywordAndGetAllCountySuggestions(keyword3).size());
    }

}
