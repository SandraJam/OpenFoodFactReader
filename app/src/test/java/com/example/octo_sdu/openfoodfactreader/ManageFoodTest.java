package com.example.octo_sdu.openfoodfactreader;

import com.example.octo_sdu.openfoodfactreader.bean.Product;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ManageFoodTest {
    ManageFood manageFood;
    Product product;
    List<Product> products;

    @Before
    public void setUp() throws Exception {
        manageFood = new ManageFood();
        product = new Product();
        products = new ArrayList<>();
    }

    @Test
    public void testCheckProductWhenNull(){
        assertNull(manageFood.checkProduct(null));
    }

    @Test
    public void testCheckProductWhenImageNull(){
        product.setImage_url(null);
        assertEquals("", manageFood.checkProduct(product).getImage_url());
    }

    @Test
    public void testCheckProductWhenBrandNull(){
        product.setBrands(null);
        assertEquals("", manageFood.checkProduct(product).getBrands());
    }

    @Test
    public void testCheckProductWhenIngredientsNull(){
        product.setIngredients_text_fr(null);
        assertEquals("", manageFood.checkProduct(product).getIngredients_text_fr());
    }

    @Test
    public void testCheckProductWhenNameNull(){
        product.setProduct_name(null);
        assertEquals("", manageFood.checkProduct(product).getProduct_name());
    }

    @Test
    public void testCheckProductWhenNameFrNull(){
        product.setProduct_name_fr(null);
        assertEquals("", manageFood.checkProduct(product).getProduct_name_fr());
    }

    @Test
    public void testCheckProductWhenNameFrEmpty(){
        product.setProduct_name_fr("");
        product.setProduct_name("art");
        assertEquals("art", manageFood.checkProduct(product).getProduct_name_fr());
    }

    @Test
    public void testCheckProductsWhenNullList() {
        products = null;
        assertNull(manageFood.checkProducts(products));
    }

    @Test
    public void testCheckProductWhenListEmpty(){
        assertEquals(0, manageFood.checkProducts(products).size());
    }

    @Test
    public void testCheckProductsWhenOneProductIsNull(){
        products.add(product);
        products.add(null);
        products.add(product);
        assertEquals(2, manageFood.checkProducts(products).size());
    }
}