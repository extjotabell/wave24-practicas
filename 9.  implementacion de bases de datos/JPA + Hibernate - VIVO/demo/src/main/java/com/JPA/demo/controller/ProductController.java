package com.JPA.demo.controller;

import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

//    @Autowired
//    private IProductService productService;

    @PostMapping("/")
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO){
        return null;
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>> getAll(){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Integer id){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteById(@PathVariable Integer id){
        return null;
    }
}
