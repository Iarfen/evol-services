package com.evolServices.dao;

import com.evolServices.model.Measurer;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Configurable
public interface MeasurersDAO extends CrudRepository<Measurer, Long>{}

