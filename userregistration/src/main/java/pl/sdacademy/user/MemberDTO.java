package pl.sdacademy.user;

/**
 * Created by adam.
 */
public class MemberDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private AddressDTO addressDTO;

    public MemberDTO() {
    }

    public MemberDTO(MemberAccount memberAccount) {
        this.id = memberAccount.getId();
        this.firstName = memberAccount.getFirstName();
        this.lastName = memberAccount.getLastName();
        this.addressDTO = new AddressDTO(memberAccount.getAddress());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }
}
