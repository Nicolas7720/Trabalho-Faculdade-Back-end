package br.com.trabalho.faculdade.backend.Backend.mapper;

import br.com.trabalho.faculdade.backend.Backend.dto.request.ClienteRequestDto;
import br.com.trabalho.faculdade.backend.Backend.dto.response.ClienteResponseDto;
import br.com.trabalho.faculdade.backend.Backend.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntity (ClienteRequestDto dto){
        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());

        return cliente;
    }
    public ClienteResponseDto toDto (Cliente cliente){
        return new ClienteResponseDto(
                cliente.getId(),
                cliente.getNome(),
                cliente.getClienteDesde()
        );
    }
}
