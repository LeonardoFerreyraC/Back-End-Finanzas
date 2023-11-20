package backend.creditcar.finance.domain.model.commands;

public record CreateCarCommand(String name, Integer year, String color, Float price, String imageURL) {
}
