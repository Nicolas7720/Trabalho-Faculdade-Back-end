package br.com.trabalho.faculdade.backend.Backend.service;

import br.com.trabalho.faculdade.backend.Backend.dto.request.ClienteRequestDto;
import br.com.trabalho.faculdade.backend.Backend.dto.response.ClienteResponseDto;
import br.com.trabalho.faculdade.backend.Backend.mapper.ClienteMapper;
import br.com.trabalho.faculdade.backend.Backend.model.Cliente;
import br.com.trabalho.faculdade.backend.Backend.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteResponseDto create (ClienteRequestDto dto){
        Optional<Cliente> clienteToComparate = clienteRepository.findByNome(dto.nome().toLowerCase());
        if (clienteToComparate.isPresent() && clienteToComparate.get().getNome().toLowerCase().equals(dto.nome().toLowerCase())){
            throw new RuntimeException("Já existe um cliente com esse nome");
        }
        Cliente cliente = clienteMapper.toEntity(dto);

        cliente = clienteRepository.save(cliente);

        return clienteMapper.toDto(cliente);
    }

    public ClienteResponseDto getById (Long id){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não encontrado!"));

        return clienteMapper.toDto(cliente);
    }

    public List<ClienteResponseDto> getAll (){
        return clienteRepository.findAll().stream()
                .map(clienteMapper::toDto)
                .toList();
    }
    public List<ClienteResponseDto> getByName (String nome){
        return clienteRepository.findAll().stream().filter(n -> n.getNome().toLowerCase().contains(nome.toLowerCase()))
                .map(clienteMapper::toDto).toList();
    }
    public ClienteResponseDto update (Long id, ClienteRequestDto dto){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("O cliente com esse id não existe"));

        cliente.setNome(dto.nome());
        cliente.setClienteDesde(LocalDateTime.now());

        return clienteMapper.toDto(cliente);
    }
    public void delete (Long id){
        clienteRepository.deleteById(id);
    }
}
