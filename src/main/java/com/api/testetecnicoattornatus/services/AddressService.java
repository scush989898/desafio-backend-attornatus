package com.api.testetecnicoattornatus.services;

import com.api.testetecnicoattornatus.dtos.request.AddressDto;
import com.api.testetecnicoattornatus.models.Address;
import com.api.testetecnicoattornatus.models.Person;
import com.api.testetecnicoattornatus.repositories.AddressRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {
    final AddressRepository addressRepository;
    final PersonService personService;

    public AddressService(AddressRepository addressRepository, PersonService personService) {
        this.addressRepository = addressRepository;
        this.personService = personService;
    }

    @Transactional
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public Optional<Address> findById(UUID id) {
        return addressRepository.findById(id);
    }

    public Address create (AddressDto addressDto, Person person){

        Address address = new Address();
        BeanUtils.copyProperties(addressDto, address);

        address.setAddressOwner(person);
        Address newAddress = this.save(address);
        person.setMainAddress(newAddress);
        personService.save(person);

        return newAddress;


    }
}
