package fairfinance.pocketpartners.backend.users.interfaces.rest.transform;

import fairfinance.pocketpartners.backend.users.domain.model.aggregates.UserInformation;
import fairfinance.pocketpartners.backend.users.interfaces.rest.resources.UserInformationResource;

public class UserInformationResourceFromEntityAssembler {
    public static UserInformationResource toResourceFromEntity(UserInformation userInformation) {
        return new UserInformationResource(userInformation.getId(), userInformation.getFullName(), userInformation.getPhoneNumber(), userInformation.getPhoto(), userInformation.getEmailAddress(), userInformation.getUser().getId());
    }
}
