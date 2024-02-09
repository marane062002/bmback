package com.bmh.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestDTO {
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;
}
