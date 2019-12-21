package com.mindly.crypto.repositories;

import com.mindly.crypto.entities.Portfolio;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;


@Configuration
public interface PortfolioRepository extends CrudRepository<Portfolio, Integer> {

}
