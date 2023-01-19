package com.api.testetecnicoattornatus.controllers;

import com.api.testetecnicoattornatus.dtos.request.PersonDto;
import com.api.testetecnicoattornatus.errors.ApiError;
import com.api.testetecnicoattornatus.models.Person;
import com.api.testetecnicoattornatus.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {

    final PersonService personService;
    ApiError apiError;

    public PersonController(PersonService personService) {
        this.personService = personService;
        this.apiError = new ApiError();
    }

    @PostMapping
    public ResponseEntity<Object> createPerson(@RequestBody @Valid PersonDto personDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.create(personDto));

    }

    @GetMapping
    public ResponseEntity<Object> getAllPersons() {
        return ResponseEntity.status(HttpStatus.OK).body(personService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePerson(@PathVariable(value = "id") UUID id) {
        Optional<Person> person = personService.findById(id);
        if (person.isEmpty()) {
            apiError.setMessage("Person Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
        }
        return ResponseEntity.status(HttpStatus.OK).body(person.get());
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Object> updatePerson(@PathVariable(value = "id") UUID id,
                                               @RequestBody @Valid PersonDto personDto) {
        Optional<Person> person = personService.findById(id);
        if (person.isEmpty()) {
            apiError.setMessage("Person Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
        }

        BeanUtils.copyProperties(personDto, person.get());
        return ResponseEntity.status(HttpStatus.OK).body(personService.update(person.get()));
    }

}
