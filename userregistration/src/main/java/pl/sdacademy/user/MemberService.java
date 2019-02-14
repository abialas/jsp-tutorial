package pl.sdacademy.user;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by adam.
 */
@Singleton
public class MemberService {

    @Inject
    private MemberDAO memberDAO;

    @Transactional
    void saveUser(MemberDTO memberDTO) {
        MemberAccount memberAccount = new MemberAccount();
        memberAccount.setId(memberDTO.getId());
        memberAccount.setFirstName(memberDTO.getFirstName());
        memberAccount.setLastName(memberDTO.getLastName());

        AddressDTO addressDTO = memberDTO.getAddressDTO();
        if (addressDTO != null) {
            Address address = new Address();
            address.setCity(addressDTO.getCity());
            address.setStreet(addressDTO.getStreet());
            address.setHouseNo(addressDTO.getHouseNo());
            memberAccount.setAddress(address);
        }
        memberDAO.saveMember(memberAccount);
    }

    Collection<MemberDTO> getMembers() {
        return memberDAO.getMembers().stream()
                .map(MemberDTO::new)
                .collect(Collectors.toList());
    }

    MemberDTO getMember(Long memberId) {
        MemberAccount memberAccount = memberDAO.findById(memberId);
        if (memberAccount != null) {
            return new MemberDTO(memberAccount);
        }
        return null;
    }

}
