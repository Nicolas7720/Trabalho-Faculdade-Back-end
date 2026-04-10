package br.com.trabalho.faculdade.backend.Backend.controller;

import br.com.trabalho.faculdade.backend.Backend.dto.request.ClienteRequestDto;
import br.com.trabalho.faculdade.backend.Backend.dto.response.ClienteResponseDto;
import br.com.trabalho.faculdade.backend.Backend.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cliente/v1")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDto> create (@Valid @RequestBody ClienteRequestDto dto){
        URI uri = URI.create("/uri/" + clienteService.create(dto));
        return ResponseEntity.created(uri).body(clienteService.create(dto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> getById (@PathVariable Long id){
        return ResponseEntity.ok(clienteService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> getAll (){
        return ResponseEntity.ok(clienteService.getAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.notFound().build();
    }

}
