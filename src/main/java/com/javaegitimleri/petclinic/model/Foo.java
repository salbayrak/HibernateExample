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

    /**
     * varchar ın tutabileceğinden çok daha fazla bir alana
     * ihtiyaç duyuyorsak Lob kullanıyoruz. sql tipi text için
     * buna clob diyoruz. Tanımlarken direkt "private clop name"
     * diye tanımlayabiliriz. Bir de blob var. blob ve clop
     * alanlar pointer'dır. Veritabanı conn'ı açık olduğu müddetçe
     * içeriklerine ulaşabiliriz. Hibernate için session'ın açık
     * olması gerekir.
     */
    @Lob
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
