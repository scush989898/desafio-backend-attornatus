package com.api.testetecnicoattornatus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.testetecnicoattornatus.models.Person;
import org.springframework.stereotype.Repository;
import java.util.UUID;


@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
}

