package com.javaegitimleri.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User: salbayrak
 * Date: 5/26/13
 * Time: 11:40 AM
 */
@Entity
public class Foo {

    private String name;

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
