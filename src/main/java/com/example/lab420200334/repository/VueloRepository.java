package com.example.lab420200334.repository;

import com.example.lab420200334.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo,Integer> {
}
