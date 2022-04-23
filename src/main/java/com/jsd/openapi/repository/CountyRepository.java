package com.jsd.openapi.repository;

import com.jsd.openapi.model.County;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CountyRepository extends JpaRepository<County, Integer> {

    @Query(value = "select * from County where lower(name) like ?1% limit 5", nativeQuery = true)
    List<County> findAllLikeName( String name);

    @Query(value = "select * from County where lower(state) = trim(lower(?1)) limit 5", nativeQuery = true)
    List<County> findAllByState( String state);

    @Query(value = "select * from County where lower(name) like ?1% and lower(state) = trim(lower(?2)) limit 5", nativeQuery = true)
    List<County> findAllSuggestions( String name,  String state);
}
