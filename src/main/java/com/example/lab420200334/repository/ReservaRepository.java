package com.example.lab420200334.repository;

import com.example.lab420200334.entity.Reserva;
import com.example.lab420200334.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Integer> {

    @Query(value = "select * from `lab4`.`reserva` where user_iduser = ?1 ",
            nativeQuery = true)
    List<Reserva> encontrarReserva(int id_user);

    @Transactional
    @Modifying
    @Query(value = "insert into `lab4`.`reserva` (`fecha_reserva`, `precio_total`, `estado_pago`, `vuelo_idvuelo`, `user_iduser`) values ( CURRENT_TIMESTAMP, ?3, 'procesado' , ?1 , ?2) ",
            nativeQuery = true)
    void guardarReserva(int vuelo_idvuelo, int user_iduser, double precio_total);

}
