package com.api.testetecnicoattornatus.services;

import com.api.testetecnicoattornatus.dtos.request.PersonDto;
import com.api.testetecnicoattornatus.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.api.testetecnicoattornatus.models.Person;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {

        this.personRepository = personRepository;
    }

    @Transactional
    public Person save(Person person) {

        return personRepository.save(person);
    }


    @Transactional
    public Person update(Person person) {

        return this.save(person);
    }

    public List<Person> findAll() {

        return personRepository.findAll();
    }

    public Optional<Person> findById(UUID id) {

        return personRepository.findById(id);
    }

    public Person create(PersonDto personDto) {
        Person person = new Person();
        BeanUtils.copyProperties(personDto, person);
        return this.save(person);
    }


}
