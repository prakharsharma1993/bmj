package com.bmj.repository;


import com.bmj.entity.BMJData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepo extends JpaRepository<BMJData, Long> {

    @Query(value = "SELECT course_name FROM tb_bmj where course_name LIKE %:keyWord%",
            nativeQuery = true)
    List<String> getInfo(@Param("keyWord") String keyWord);

    // So we have two ways to query database
// JPA and Native Query

    List<BMJData> findAllByCourseNameContaining(String keyWord);

    @Query(value = "SELECT * FROM tb_bmj where course_name LIKE %:keyWord%",
            nativeQuery = true)
    List<BMJData> getMoreInfo(@Param("keyWord") String keyWord);

}
