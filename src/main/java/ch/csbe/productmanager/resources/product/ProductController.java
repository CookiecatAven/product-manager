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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ProductDetailDto> getProductById(@PathVariable Integer id) {
        Optional<ProductDetailDto> foundProduct = productService.getProductById(id);
        return foundProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
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
    public ResponseEntity<ProductDetailDto> addProduct(@RequestBody ProductCreateDto product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
    }

    /**
     * Aktualisiert ein bestehendes Produkt.
     *
     * @param id             die ID des Produkts
     * @param updatedProduct die aktualisierten Produktdaten
     * @return das aktualisierte Produkt in Form eines ProductDetailDto
     */
    @Operation(summary = "Aktualisiert ein bestehendes Produkt", description = "Aktualisiert die Daten eines Produkts basierend auf der ID und gibt die aktualisierten Produktdetails zurück.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produkt erfolgreich aktualisiert."),
            @ApiResponse(responseCode = "404", description = "Produkt mit dieser ID nicht gefunden.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ProductDetailDto> updateProduct(@PathVariable Integer id, @RequestBody ProductUpdateDto updatedProduct) {
        Optional<ProductDetailDto> storedUpdatedProduct = productService.updateProduct(id, updatedProduct);
        return storedUpdatedProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Löscht ein Produkt basierend auf der ID.
     *
     * @param id die ID des Produkts, das gelöscht werden soll
     * @return ResponseEntity mit HTTP Code
     */
    @Operation(summary = "Löscht ein Produkt", description = "Löscht ein Produkt aus dem System basierend auf der angegebenen ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produkt erfolgreich gelöscht."),
            @ApiResponse(responseCode = "404", description = "Produkt mit dieser ID nicht gefunden.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        boolean deleteResult = productService.deleteProduct(id);
        return deleteResult ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
