package br.com.trabalho.faculdade.backend.Backend.controller;

import br.com.trabalho.faculdade.backend.Backend.dto.request.ClienteRequestDto;
import br.com.trabalho.faculdade.backend.Backend.dto.response.ClienteResponseDto;
import br.com.trabalho.faculdade.backend.Backend.service.ClienteService;
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
    public ResponseEntity<ClienteResponseDto> create (@RequestBody ClienteRequestDto dto){
        ClienteResponseDto response = clienteService.create(dto);
        URI uri = URI.create("/uri/" + response.id());
        return ResponseEntity.created(uri).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> getById (@PathVariable Long id){
        return ResponseEntity.ok(clienteService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> getAll (){
        return ResponseEntity.ok(clienteService.getAll());
    }
    @GetMapping("/search/{nome}")
    public ResponseEntity<List<ClienteResponseDto>> getByName (@PathVariable String nome){
        return ResponseEntity.ok(clienteService.getByName(nome));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> update (@PathVariable Long id, @RequestBody ClienteRequestDto dto){
        return ResponseEntity.ok().body(clienteService.update(id, dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.notFound().build();
    }

}
