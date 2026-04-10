package br.com.trabalho.faculdade.backend.Backend.service;

import br.com.trabalho.faculdade.backend.Backend.dto.request.ClienteRequestDto;
import br.com.trabalho.faculdade.backend.Backend.dto.response.ClienteResponseDto;
import br.com.trabalho.faculdade.backend.Backend.mapper.ClienteMapper;
import br.com.trabalho.faculdade.backend.Backend.model.Cliente;
import br.com.trabalho.faculdade.backend.Backend.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteResponseDto create (ClienteRequestDto dto){
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
    public void delete (Long id){
        clienteRepository.deleteById(id);
    }
}
