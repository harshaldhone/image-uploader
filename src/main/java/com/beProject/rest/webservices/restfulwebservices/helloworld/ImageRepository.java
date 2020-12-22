package com.beProject.rest.webservices.restfulwebservices.helloworld;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ImageRepository extends JpaRepository<ImageModel, Long> {

     Optional<ImageModel> findBypreHash(String name) ;


}