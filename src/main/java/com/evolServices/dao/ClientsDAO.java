package com.evolServices.dao;

import com.evolServices.model.Client;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Configurable
public interface ClientsDAO extends CrudRepository<Client, Long>{}

