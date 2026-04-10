package br.com.trabalho.faculdade.backend.Backend.service;

import br.com.trabalho.faculdade.backend.Backend.dto.request.PedidoRequestDto;
import br.com.trabalho.faculdade.backend.Backend.dto.response.PedidoResponseDto;
import br.com.trabalho.faculdade.backend.Backend.mapper.PedidoMapper;
import br.com.trabalho.faculdade.backend.Backend.model.Pedido;
import br.com.trabalho.faculdade.backend.Backend.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoMapper pedidoMapper;
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoMapper pedidoMapper, PedidoRepository pedidoRepository) {
        this.pedidoMapper = pedidoMapper;
        this.pedidoRepository = pedidoRepository;
    }

    public PedidoResponseDto create (PedidoRequestDto dto){
        Pedido pedido = pedidoMapper.toEntity(dto);
        pedido = pedidoRepository.save(pedido);
        return pedidoMapper.toDto(pedido);
    }
    public PedidoResponseDto getById (Long id){
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado!"));
        return pedidoMapper.toDto(pedido);
    }
    public List<PedidoResponseDto> getAll (){
        return pedidoRepository.findAll().stream()
                .map(pedidoMapper::toDto)
                .toList();
    }
    public void delete (Long id){
        pedidoRepository.deleteById(id);
    }
}
