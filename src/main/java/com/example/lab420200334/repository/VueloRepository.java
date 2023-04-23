package com.example.lab420200334.repository;

import com.example.lab420200334.entity.Reserva;
import com.example.lab420200334.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo,Integer> {

}
