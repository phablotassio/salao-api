package com.phablo.tassio.salao.api.repository;

import com.phablo.tassio.salao.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
