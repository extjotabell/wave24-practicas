package org.socialmeli.be_java_hisp_w24_g04.unittest.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.socialmeli.be_java_hisp_w24_g04.model.Product;
import org.socialmeli.be_java_hisp_w24_g04.repository.IProductRepository;
import org.socialmeli.be_java_hisp_w24_g04.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductRepositoryTests {

    private final IProductRepository productRepository = new ProductRepository();

    @Test
    public void testSaveProduct() {
        Product product = new Product();
        product.setProductId(1);

        Product savedProduct = productRepository.save(product);

        Assertions.assertEquals(product.getProductId(), savedProduct.getProductId());
        Assertions.assertTrue(productRepository.findAll().contains(product));
    }

    @Test
    public void testSaveNullProduct() {
        Product product = productRepository.save(null);
        Assertions.assertNull(product);
    }

    @Test
    public void testRemoveProduct() {
        Product product = new Product();
        product.setProductId(1);
        productRepository.save(product);

        Product removedProduct = productRepository.remove(1);

        Assertions.assertEquals(product.getProductId(), removedProduct.getProductId());
    }

    @Test
    public void testRemoveNonExistentProduct() {
        Product removedProduct = productRepository.remove(999);
        Assertions.assertNull(removedProduct);
    }

    @Test
    public void testGetProduct() {
        Product product = new Product();
        product.setProductId(1);

        Optional<Product> fetchedProduct = productRepository.get(1);

        Assertions.assertTrue(fetchedProduct.isPresent());
        Assertions.assertEquals(product.getProductId(), fetchedProduct.get().getProductId());
    }

    @Test
    public void testGetNonExistentProduct() {
        Optional<Product> fetchedProduct = productRepository.get(999);
        Assertions.assertTrue(fetchedProduct.isEmpty());
    }

    @Test
    public void testFindAllProducts() {
        Product product = new Product();
        product.setProductId(1);
        productRepository.save(product);

        List<Product> fetchedProducts = productRepository.findAll();

        Assertions.assertFalse(fetchedProducts.isEmpty());
        Assertions.assertTrue(fetchedProducts.contains(product));
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        product.setProductId(1);
        productRepository.save(product);
        product.setName("Updated Product");

        productRepository.update(product);
        Product updatedProduct = productRepository.get(1).get();

        Assertions.assertEquals(product, updatedProduct);
    }
}
