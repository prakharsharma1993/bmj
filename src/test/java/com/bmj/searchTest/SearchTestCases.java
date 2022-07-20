package com.bmj.searchTest;


import com.bmj.dto.SearchDTO;
import com.bmj.service.SearchService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SearchTestCases {


    private int port = 8080;

    private static final String uri_1 = "/search/courses";

    private static final String uri_2 = "/search/totalHours";


    @MockBean
    private SearchService searchService;


    @Autowired
    TestRestTemplate testRestTemplate;
    List<String> mockCourse = new ArrayList<>();

    SearchDTO searchDTO = new SearchDTO();

    private HttpHeaders createJsonHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json;");
        return httpHeaders;
    }
    @Test
    public void getCoursesTest() throws Exception {

        Mockito.when(searchService.getInfo(Mockito.anyString())).thenReturn(mockCourse);

        HttpEntity<String> requestEntity = new HttpEntity<String>(createJsonHeaders());

        UriComponentsBuilder builder = UriComponentsBuilder.fromPath(uri_1)
                .queryParam("keyWord", "intro");
        ResponseEntity responseEntity = testRestTemplate.exchange
                (builder.toUriString(), HttpMethod.GET, requestEntity, String.class);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void getCoursesWithTimeTest() throws Exception {

        Mockito.when(searchService.getMoreInfo(Mockito.anyString())).thenReturn(searchDTO);

        HttpEntity<String> requestEntity = new HttpEntity<String>(createJsonHeaders());

        UriComponentsBuilder builder = UriComponentsBuilder.fromPath(uri_2)
                .queryParam("keyWord", "intro");
        ResponseEntity responseEntity = testRestTemplate.exchange
                (builder.toUriString(), HttpMethod.GET, requestEntity, String.class);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }
}
