package com.berkan.homework.repository;

import com.berkan.homework.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryRepository extends JpaRepository<Country, Long> {

}
