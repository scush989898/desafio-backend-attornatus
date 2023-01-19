package com.api.testetecnicoattornatus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.testetecnicoattornatus.models.Address;
import org.springframework.stereotype.Repository;
import java.util.UUID;


@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {

}


