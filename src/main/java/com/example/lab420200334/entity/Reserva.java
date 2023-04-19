package com.example.lab420200334.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Entity
@Getter
@Setter
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreserva")
    private Integer idreserva;

    private Date fecha_reserva;

    private double precio_total;

    private String estado_pago;



    @ManyToOne
    @JoinColumn(name ="vuelo_idvuelo")
    private Vuelo vuelo;


    @ManyToOne
    @JoinColumn(name ="user_iduser")
    private User user;

}
