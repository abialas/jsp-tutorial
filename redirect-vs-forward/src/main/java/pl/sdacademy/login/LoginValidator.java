package pl.sdacademy.login;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by adam.
 */
public class LoginValidator {

    Collection<String> getLoginValidationMessages(String userName, String password) {
        Collection<String> validationMessages = new ArrayList<>();
        if (StringUtils.isBlank(userName)) {
            validationMessages.add("User cannot be empty");
        }
        if (StringUtils.isBlank(password)) {
            validationMessages.add("Password cannot be empty");
        }
        if (!"JavaKtw9".equals(userName) || !"Sda".equals(password)) {
            validationMessages.add("Invalid login or password");
        }
        return validationMessages;
    }

}
