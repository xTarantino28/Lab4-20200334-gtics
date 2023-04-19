package com.example.lab420200334.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@Table(name = "aerolinea")
public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idaerolinea")
    private Integer idaerolinea;

    @Column(nullable = false)
    private String nombre;

    private String codigo;


}
