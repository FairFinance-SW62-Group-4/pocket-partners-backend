package fairfinance.pocketpartners.backend.users.domain.model.commands;

public record UpdateUserInformationCommand(Long userId, String firstName, String lastName, String phoneNumber, String photo, String email) {
}