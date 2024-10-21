package Service;

import com.comercio.loja.service.ProductService;
import com.comercio.loja.product.Product;
import com.comercio.loja.product.ProductRepository;
import com.comercio.loja.product.ProductRequestDTO;
import com.comercio.loja.product.ProductResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveProduct() {
        ProductRequestDTO requestDTO = new ProductRequestDTO("Produto teste", 199.99, "URL");
        Product product = new Product(requestDTO);

        productService.saveProduct(requestDTO);
        verify(repository, times(1)).save(any(Product.class));
    }

    @Test
    public void testGetAll() {

        List<Product> mockProductList = Arrays.asList(new Product(), new Product());

        when(repository.findAll()).thenReturn(mockProductList);

        List<ProductResponseDTO> result = productService.getAll();

        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testDeleteProduct() {
        Long productId = 1L;

        productService.deleteProduct(productId);

        verify(repository, times(1)).deleteById(productId);
    }
}
