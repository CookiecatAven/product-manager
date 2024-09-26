package ch.csbe.productmanager.resources.product;

import ch.csbe.productmanager.resources.product.dto.ProductCreateDto;
import ch.csbe.productmanager.resources.product.dto.ProductDetailDto;
import ch.csbe.productmanager.resources.product.dto.ProductShowDto;
import ch.csbe.productmanager.resources.product.dto.ProductUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller zur Verwaltung der Produkte.
 * Dokumentiert mit SpringDoc für OpenAPI/Swagger.
 */
@RestController
@RequestMapping("/products")
@Tag(name = "ProductController", description = "Verwaltung der Produkte im System")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Holt alle Produkte.
     *
     * @return Liste von ProductShowDto
     */
    @Operation(summary = "Holt alle Produkte", description = "Gibt eine Liste von allen im System vorhandenen Produkten zurück.")
    @ApiResponse(responseCode = "200", description = "Erfolgreich alle Produkte erhalten.")
    @GetMapping
    public List<ProductShowDto> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Holt ein einzelnes Produkt basierend auf der ID.
     *
     * @param id die ID des Produkts
     * @return das Produkt in Form eines ProductDetailDto
     */
    @Operation(summary = "Findet ein Produkt nach ID", description = "Gibt ein Produkt zurück, das der angegebenen ID entspricht.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produkt erfolgreich gefunden."),
            @ApiResponse(responseCode = "404", description = "Produkt mit dieser ID nicht gefunden.")
    })
    @GetMapping("/{id}")
    public Optional<ProductDetailDto> getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    /**
     * Fügt ein neues Produkt hinzu.
     *
     * @param product die Daten für das zu erstellende Produkt
     * @return das erstellte Produkt in Form eines ProductDetailDto
     */
    @Operation(summary = "Erstellt ein neues Produkt", description = "Fügt ein neues Produkt in das System ein und gibt die Details des erstellten Produkts zurück.")
    @ApiResponse(responseCode = "201", description = "Produkt erfolgreich erstellt.")
    @PostMapping
    public ProductDetailDto addProduct(@RequestBody ProductCreateDto product) {
        return productService.addProduct(product);
    }

    /**
     * Aktualisiert ein bestehendes Produkt.
     *
     * @param id die ID des Produkts
     * @param updatedProduct die aktualisierten Produktdaten
     * @return das aktualisierte Produkt in Form eines ProductDetailDto
     */
    @Operation(summary = "Aktualisiert ein bestehendes Produkt", description = "Aktualisiert die Daten eines Produkts basierend auf der ID und gibt die aktualisierten Produktdetails zurück.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produkt erfolgreich aktualisiert."),
            @ApiResponse(responseCode = "404", description = "Produkt mit dieser ID nicht gefunden.")
    })
    @PutMapping("/{id}")
    public ProductDetailDto updateProduct(@PathVariable Integer id, @RequestBody ProductUpdateDto updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }

    /**
     * Löscht ein Produkt basierend auf der ID.
     *
     * @param id die ID des Produkts, das gelöscht werden soll
     */
    @Operation(summary = "Löscht ein Produkt", description = "Löscht ein Produkt aus dem System basierend auf der angegebenen ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produkt erfolgreich gelöscht."),
            @ApiResponse(responseCode = "404", description = "Produkt mit dieser ID nicht gefunden.")
    })
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }
}
