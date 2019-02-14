package pl.sdacademy.user;

import javax.persistence.*;

/**
 * Created by adam.
 */
@Entity
public class MemberAccount {
    private Long id;
    private String firstName;
    private String lastName;
    private Address address;

    @Id
    @SequenceGenerator(name = "member_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_id_seq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
