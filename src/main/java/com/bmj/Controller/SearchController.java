package com.bmj.Controller;

import com.bmj.dto.SearchDTO;
import com.bmj.service.SearchService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    SearchService searchService;


    //Swagger URL::  http://localhost:8080/bmj/swagger-ui.html

    @ApiOperation("API is used to search all courses available in BMJ ")
    @GetMapping("/courses")
    ResponseEntity getCourses(@RequestParam String keyWord) {

        List<String> info = searchService.getInfo(keyWord);
        if(Objects.isNull(info) || info.isEmpty())
        {
            return new ResponseEntity("No data found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(info, HttpStatus.OK);

    }

    @ApiOperation("API is used to search courses and total course hours in BMJ")
    @GetMapping("/totalHours")
    ResponseEntity getCoursesWithTime(@RequestParam String keyWord) {

        SearchDTO info = searchService.getMoreInfo(keyWord);
        if(Objects.isNull(info.getCourse()) || info.getCourse().size()==0)
        {
            return new ResponseEntity("No data found",HttpStatus.OK);
        }
        return new ResponseEntity(info, HttpStatus.OK);    }





}
