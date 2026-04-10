package br.com.trabalho.faculdade.backend.Backend.controller;

import br.com.trabalho.faculdade.backend.Backend.dto.request.ProdutoRequestDto;
import br.com.trabalho.faculdade.backend.Backend.dto.response.ProdutoResponseDto;
import br.com.trabalho.faculdade.backend.Backend.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produto/v1")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDto> create(@Valid @RequestBody ProdutoRequestDto dto){
        URI uri = URI.create("/uri/" + produtoService.create(dto));
        return ResponseEntity.created(uri).body(produtoService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> getById (@PathVariable Long id){
        return ResponseEntity.ok(produtoService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<ProdutoResponseDto>> getAll (){
        return ResponseEntity.ok(produtoService.getAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
