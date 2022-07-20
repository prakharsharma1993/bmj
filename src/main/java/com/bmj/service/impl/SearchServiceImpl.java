package com.bmj.service.impl;

import com.bmj.dto.SearchDTO;
import com.bmj.entity.BMJData;
import com.bmj.repository.SearchRepo;
import com.bmj.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
@Slf4j
public class SearchServiceImpl implements SearchService {


    @Autowired
    SearchRepo searchRepo;

    @Override
    public List<String> getInfo(String keyWord) {

        List<String> name = searchRepo.getInfo(keyWord);
        SearchDTO searchDTO = new SearchDTO();
        if (Objects.isNull(name) || name.isEmpty()) {
            log.info("No data found");
            return new ArrayList<>();
        } else {
            searchDTO.setCourse(name);
            return searchDTO.getCourse();
        }

    }

    @Override
    public SearchDTO getMoreInfo(String keyWord) {
        List<BMJData> name = searchRepo.findAllByCourseNameContaining(keyWord);
        SearchDTO searchDTO = new SearchDTO();
        List<String> courseName= new ArrayList<>();
        Double totalHours=0D;
        if (Objects.isNull(name) || name.isEmpty()) {
            log.info("No data found");
        } else {

            for (BMJData bmjData : name) {

                courseName.add(bmjData.getCourseName());
                totalHours=totalHours+ (Objects.nonNull(bmjData.getCourseHours())? bmjData.getCourseHours():0);

            }
            searchDTO.setCourse(courseName);
            searchDTO.setHours(totalHours);

        }
        return searchDTO;
    }

  /*  public SearchDTO getData(List<String> data) {
        Double sum = 0D;
        SearchDTO searchDTOS = new SearchDTO();
        List<String> names = new ArrayList<>();

        for (String course : data) {
            String[] courseArray = course.split(",");
            if (courseArray.length == 2) {
                sum = sum + Double.parseDouble(courseArray[0]);
                names.add(courseArray[1]);
            } else {
                sum = sum + 0;
                names.add(courseArray[0]);
            }
        }
        searchDTOS.setHours(sum);
        searchDTOS.setCourse(names);
        return searchDTOS;
    }*/


}
