package ch.csbe.productmanager.resources.product;

import ch.csbe.productmanager.resources.product.dto.ProductCreateDto;
import ch.csbe.productmanager.resources.product.dto.ProductDetailDto;
import ch.csbe.productmanager.resources.product.dto.ProductShowDto;
import ch.csbe.productmanager.resources.product.dto.ProductUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
     * @param productMapper     der Mapper zur Konvertierung von Produktdaten
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
    public List<ProductShowDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductShowDto> productShowDtos = new ArrayList<>();
        for (Product product : products) {
            productShowDtos.add(productMapper.toShowDto(product));
        }
        return productShowDtos;
    }

    /**
     * Holt ein einzelnes Produkt anhand der ID aus der Datenbank.
     *
     * @param id die ID des Produkts
     * @return ein Optional mit dem Produkt, falls vorhanden
     */
    public Optional<ProductDetailDto> getProductById(Integer id) {
        return productRepository.findById(id)
                .map(productMapper::toDetailDto);
    }

    /**
     * Fügt ein neues Produkt in die Datenbank ein.
     *
     * @param productDto das zu speichernde Produkt
     * @return das gespeicherte Produkt
     */
    public ProductDetailDto addProduct(ProductCreateDto productDto) {
        Product savedProduct = productRepository.save(productMapper.toEntity(productDto));
        return productMapper.toDetailDto(savedProduct);
    }

    /**
     * Aktualisiert ein Produkt in der Datenbank.
     *
     * @param id               die ID des Produkts
     * @param updateProductDto die aktualisierten Produktdaten
     * @return das aktualisierte Produkt
     */
    public ProductDetailDto updateProduct(Integer id, ProductUpdateDto updateProductDto) {
        return productRepository.findById(id)
                .map(product -> {
                    productMapper.update(updateProductDto, product);
                    Product savedProduct = productRepository.save(product);
                    return productMapper.toDetailDto(savedProduct);
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
