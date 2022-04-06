package com.example.training.service;

import com.example.training.domain.Person;

import java.util.List;

public interface IPersonService {
    public List<Person> getPersons();
    public void createPerson(Person person);
    public void deletePerson(Person person);
    public Person getPerson(Person person);
}
