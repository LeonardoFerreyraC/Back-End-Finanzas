package backend.creditcar.finance.interfaces.rest.resources;

public record CreateCarResource(String name, Integer year, String color, Float price, String imageURL) {
}
