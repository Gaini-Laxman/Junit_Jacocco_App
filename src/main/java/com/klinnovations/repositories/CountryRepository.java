package com.klinnovations.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klinnovations.entities.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Serializable> {

}
