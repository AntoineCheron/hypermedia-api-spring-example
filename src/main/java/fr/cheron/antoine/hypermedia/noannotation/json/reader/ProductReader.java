package fr.cheron.antoine.hypermedia.noannotation.json.reader;

import java.io.IOException;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.cheron.antoine.hypermedia.noannotation.domain.Product;

public class ProductReader implements ApplicationReader<Product> {

  public Optional<Product> read(String value) {
    try {
      final ObjectMapper JSON = new ObjectMapper();
      final JsonNode node = JSON.readTree(value);

      return Optional.of(new Product(
          node.get("id").asText(),
          node.get("title").asText(),
          node.get("price").asDouble(),
          node.get("thumbnail").asText()
      ));
    } catch (IOException e) {
      return Optional.empty();
    }
  }

}
