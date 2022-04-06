package com.example.training.service;

import com.example.training.dao.IPersonDAO;
import com.example.training.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImp implements IPersonService {
    @Autowired
    private IPersonDAO personDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Person> getPersons() {
        return (List<Person>) personDAO.findAll();
    }

    @Override
    @Transactional
    public void createPerson(Person person) {
        personDAO.save(person);
    }

    @Override
    @Transactional
    public void deletePerson(Person person) {
        personDAO.delete(person);
    }

    @Override
    @Transactional(readOnly = true)
    public Person getPerson(Person person) {
        return personDAO.findById(person.getId_person()).orElse(null);
    }
}
