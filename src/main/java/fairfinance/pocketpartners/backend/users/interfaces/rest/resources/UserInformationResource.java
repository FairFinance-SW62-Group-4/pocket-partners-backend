package fairfinance.pocketpartners.backend.users.interfaces.rest.resources;

import java.util.List;

public record UserInformationResource(Long id,
                                      String fullName,
                                      String phoneNumber,
                                      String photo,
                                      String email,
                                      Long userId) {
}
