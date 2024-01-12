package tech.kitucode.spring.tdd.domain;

import jakarta.persistence.*;
import lombok.Data;
import tech.kitucode.spring.tdd.domain.enumerations.Gender;

@Entity
@Table(name = "tbl_friends")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String msisdn;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Friend() {
    }

    public Friend(String name, String email, String msisdn, Gender gender) {
        this.name = name;
        this.email = email;
        this.msisdn = msisdn;
        this.gender = gender;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", gender=" + gender +
                '}';
    }
}
