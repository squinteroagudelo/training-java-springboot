package com.example.training.dao;

import com.example.training.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPersonDAO extends CrudRepository<Person, Long> {
}
