package com.javaegitimleri.petclinic.model;

import javax.persistence.*;

/**
 * User: salbayrak
 * Date: 5/26/13
 * Time: 11:40 AM
 */
@Entity(name="fool")
@Table(name="T_FOO")
public class Foo {

    @Column(name="C_NAME")
    private String name;

    @Embedded
    private Bar bar;

    public Foo() {

    }

    public Foo(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
