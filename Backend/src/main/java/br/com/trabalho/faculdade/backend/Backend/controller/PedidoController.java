package br.com.trabalho.faculdade.backend.Backend.controller;

import br.com.trabalho.faculdade.backend.Backend.dto.request.PedidoRequestDto;
import br.com.trabalho.faculdade.backend.Backend.dto.response.PedidoResponseDto;
import br.com.trabalho.faculdade.backend.Backend.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedido/v1")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDto> create (@Valid @RequestBody PedidoRequestDto dto){
        URI uri = URI.create("/uri/" + pedidoService.create(dto));
        return ResponseEntity.created(uri).body(pedidoService.create(dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> getById (@PathVariable Long id){
        return ResponseEntity.ok(pedidoService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<PedidoResponseDto>> getAll(){
        return ResponseEntity.ok(pedidoService.getAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
