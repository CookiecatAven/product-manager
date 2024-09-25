package ch.csbe.productmanager.resources.product;

import ch.csbe.productmanager.resources.product.dto.ProductCreateDto;
import ch.csbe.productmanager.resources.product.dto.ProductDetailDto;
import ch.csbe.productmanager.resources.product.dto.ProductShowDto;
import ch.csbe.productmanager.resources.product.dto.ProductUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller zur Verwaltung der Produkte.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductShowDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<ProductDetailDto> getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductDetailDto addProduct(@RequestBody ProductCreateDto product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public ProductDetailDto updateProduct(@PathVariable Integer id, @RequestBody ProductUpdateDto updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }
}
