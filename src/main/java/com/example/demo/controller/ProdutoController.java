package com.example.demo.controller;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    // Injeção de dependência via construtor
    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // 1. GET - Listar todos os produtos do banco
    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    // 2. GET - Buscar produto por ID no banco
    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    // 3. POST - Cadastrar novo produto no banco
    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
}