package ch.csbe.productmanager.resources.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service-Klasse zur Verwaltung von Produkten.
 * Diese Klasse verwendet einen Mapper zur Konvertierung von Produkten.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    /**
     * Konstruktor, um das Repository und den Mapper zu injizieren.
     *
     * @param productRepository das Produkt-Repository zur Datenbankoperation
     * @param productMapper der Mapper zur Konvertierung von Produktdaten
     */
    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    /**
     * Holt alle Produkte aus der Datenbank.
     *
     * @return Liste aller Produkte
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Holt ein einzelnes Produkt anhand der ID aus der Datenbank.
     *
     * @param id die ID des Produkts
     * @return ein Optional mit dem Produkt, falls vorhanden
     */
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    /**
     * Fügt ein neues Produkt in die Datenbank ein.
     *
     * @param product das zu speichernde Produkt
     * @return das gespeicherte Produkt
     */
    public Product addProduct(Product product) {
        Product mappedProduct = productMapper.toEntity(product);
        return productRepository.save(mappedProduct);
    }

    /**
     * Aktualisiert ein Produkt in der Datenbank.
     *
     * @param id die ID des Produkts
     * @param updatedProduct die aktualisierten Produktdaten
     * @return das aktualisierte Produkt
     */
    public Product updateProduct(Integer id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    Product mappedProduct = productMapper.toEntity(updatedProduct);
                    return productRepository.save(mappedProduct);
                })
                .orElseThrow(() -> new RuntimeException("Produkt mit ID " + id + " nicht gefunden."));
    }

    /**
     * Löscht ein Produkt aus der Datenbank.
     *
     * @param id die ID des zu löschenden Produkts
     */
    public void deleteProduct(Integer id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new RuntimeException("Produkt mit ID " + id + " nicht gefunden.");
        }
    }
}
