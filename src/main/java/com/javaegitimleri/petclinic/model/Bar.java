package com.javaegitimleri.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**
 * User: salbayrak
 * Date: 5/26/13
 * Time: 2:16 PM
 */
@Embeddable
public class Bar {
    @Column(nullable = true)
    private boolean b;

    private Baz baz;

    @Transient
    private Bat bat;
}
