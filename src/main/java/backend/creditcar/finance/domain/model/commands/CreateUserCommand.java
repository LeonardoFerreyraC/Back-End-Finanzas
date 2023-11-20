package backend.creditcar.finance.domain.model.commands;

public record CreateUserCommand(String name, String lastName, String email, String password) {
}
