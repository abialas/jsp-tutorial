package pl.sdacademy.registration;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by adam.
 */
@Singleton
public class UserService {

    @Inject
    private UserDao userDao;

    void saveUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());

        AddressDTO addressDTO = userDTO.getAddressDTO();
        if (addressDTO != null) {
            Address address = new Address();
            address.setCity(addressDTO.getCity());
            address.setStreet(addressDTO.getStreet());
            address.setHouseNo(addressDTO.getHouseNo());
            user.setAddress(address);
        }
        userDao.saveUser(user);
    }

    Collection<UserDTO> getUsers() {
        return userDao.getUsers().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

}
