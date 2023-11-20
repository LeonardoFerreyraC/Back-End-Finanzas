package backend.creditcar.finance.interfaces.rest.resources;

public record CarResource(Long id, String name, Integer year, String color, Float price, String imageURL) {
}
