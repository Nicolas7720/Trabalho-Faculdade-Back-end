package br.com.trabalho.faculdade.backend.Backend.controller;

import br.com.trabalho.faculdade.backend.Backend.dto.request.ProdutoRequestDto;
import br.com.trabalho.faculdade.backend.Backend.dto.response.ProdutoResponseDto;
import br.com.trabalho.faculdade.backend.Backend.service.ProdutoService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
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
        ProdutoResponseDto response = produtoService.create(dto);
        URI uri = URI.create("/uri/" + response.id());
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> getById (@PathVariable Long id){
        return ResponseEntity.ok(produtoService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<ProdutoResponseDto>> getAll (){
        return ResponseEntity.ok(produtoService.getAll());
    }
    @GetMapping("/search/{nome}")
    public ResponseEntity<List<ProdutoResponseDto>> getByName (@PathVariable String nome){
        return ResponseEntity.ok(produtoService.getByName(nome));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> update (@PathVariable Long id, @Valid @RequestBody ProdutoRequestDto dto){
        return ResponseEntity.ok().body(produtoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
