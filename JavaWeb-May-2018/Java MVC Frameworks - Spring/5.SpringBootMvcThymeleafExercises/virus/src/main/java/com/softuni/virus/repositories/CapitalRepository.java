package com.softuni.virus.repositories;

import com.softuni.virus.entities.Capital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapitalRepository extends JpaRepository<Capital,String> {
    Capital findByName(String name);
}
