package com.example.lab420200334.repository;

import com.example.lab420200334.entity.Reserva;
import com.example.lab420200334.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Integer> {

    @Query(value = "select * from reserva where user_iduser = ?1 ",
            nativeQuery = true)
    List<Reserva> encontrarReserva(int id_user);

}
