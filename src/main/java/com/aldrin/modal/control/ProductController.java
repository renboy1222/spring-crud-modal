/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.modal.control;

/**
 *
 * @author Java Programming with Aldrin
 */
import com.aldrin.modal.model.Product;
import com.aldrin.modal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "list";
    }

    @PostMapping("/add")
    public String addProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @PostMapping("/update")
    public String updateProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }



    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
