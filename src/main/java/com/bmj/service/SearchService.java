package com.bmj.service;



import com.bmj.dto.SearchDTO;

import java.util.List;


public interface SearchService {

    public List<String> getInfo(String keyWord);

    public SearchDTO getMoreInfo(String keyWord);





}
