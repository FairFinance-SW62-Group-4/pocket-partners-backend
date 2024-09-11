package fairfinance.pocketpartners.backend.users.domain.model.commands;

import fairfinance.pocketpartners.backend.users.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password, List<Role> roles) {
}
