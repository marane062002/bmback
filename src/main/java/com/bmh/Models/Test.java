package com.bmh.Models;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "marche_test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
