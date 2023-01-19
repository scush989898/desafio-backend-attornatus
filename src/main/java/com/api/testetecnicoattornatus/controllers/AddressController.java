package com.api.testetecnicoattornatus.controllers;

import com.api.testetecnicoattornatus.errors.ApiError;
import com.api.testetecnicoattornatus.dtos.request.AddressDto;
import com.api.testetecnicoattornatus.models.Address;
import com.api.testetecnicoattornatus.models.Person;
import com.api.testetecnicoattornatus.services.AddressService;
import com.api.testetecnicoattornatus.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/address")
public class AddressController {

    final AddressService addressService;
    final PersonService personService;
    ApiError apiError;

    public AddressController(AddressService addressService, PersonService personService) {
        this.addressService = addressService;
        this.personService = personService;
        this.apiError = new ApiError();
    }

    @PostMapping("/{person_id}")
    public ResponseEntity<Object> createAddress(
            @PathVariable(value = "person_id") UUID person_id,
            @RequestBody @Valid AddressDto addressDto) {

        Optional<Person> person = personService.findById(person_id);
        if (person.isEmpty()) {
            apiError.setMessage("Person Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
        }

        Address address = addressService.create(addressDto, person.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(address);
    }

    @GetMapping("/{person_id}")
    public ResponseEntity<Object> getAllPersonAddresses(@PathVariable(value = "person_id") UUID person_id) {
        Optional<Person> person = personService.findById(person_id);
        if (person.isEmpty()) {
            apiError.setMessage("Person Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
        }
        return ResponseEntity.status(HttpStatus.OK).body(person.get().getAddresses());
    }

    @PatchMapping("/{person_id}/main/{address_id}")
    public ResponseEntity<Object> setPersonMainAddress(@PathVariable(value = "person_id") UUID person_id,
                                                       @PathVariable(value = "address_id") UUID address_id) {

        Optional<Person> person = personService.findById(person_id);
        if (person.isEmpty()) {
            apiError.setMessage("Person Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
        }

        Optional<Address> address = addressService.findById(address_id);

        if (address.isEmpty()) {
            apiError.setMessage("Address Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
        }

        person.get().setMainAddress(address.get());
        personService.save(person.get());
        return ResponseEntity.status(HttpStatus.OK).build();

    }

}







