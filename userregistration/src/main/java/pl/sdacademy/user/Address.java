package pl.sdacademy.user;

import javax.persistence.*;

/**
 * Created by adam.
 */
@Entity
public class Address {
    private Long id;
    private String city;
    private String street;
    private String houseNo;

    @Id
    @SequenceGenerator(name = "address_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_seq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column
    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }
}
