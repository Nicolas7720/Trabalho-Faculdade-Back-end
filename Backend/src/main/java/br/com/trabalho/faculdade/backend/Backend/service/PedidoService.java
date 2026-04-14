package br.com.trabalho.faculdade.backend.Backend.service;

import br.com.trabalho.faculdade.backend.Backend.dto.request.PedidoRequestDto;
import br.com.trabalho.faculdade.backend.Backend.dto.response.PedidoResponseDto;
import br.com.trabalho.faculdade.backend.Backend.mapper.PedidoMapper;
import br.com.trabalho.faculdade.backend.Backend.model.Cliente;
import br.com.trabalho.faculdade.backend.Backend.model.Pedido;
import br.com.trabalho.faculdade.backend.Backend.model.Produto;
import br.com.trabalho.faculdade.backend.Backend.repository.ClienteRepository;
import br.com.trabalho.faculdade.backend.Backend.repository.PedidoRepository;
import br.com.trabalho.faculdade.backend.Backend.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoMapper pedidoMapper;
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoService(PedidoMapper pedidoMapper, PedidoRepository pedidoRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.pedidoMapper = pedidoMapper;
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
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
    public PedidoResponseDto update (Long id, PedidoResponseDto dto){
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Id não encontrado"));
        Cliente cliente = clienteRepository.findById(dto.clienteId()).orElseThrow(() -> new RuntimeException("Id do cliente não encontrado"));
        Produto produto = produtoRepository.findById(dto.produtoId()).orElseThrow(() -> new RuntimeException("Id do Produto não encontrado"));

        pedido.setCliente(cliente);
        pedido.setProduto(produto);
        pedido.setQuantidade(dto.quantidade());

        pedido = pedidoRepository.save(pedido);

        return pedidoMapper.toDto(pedido);
    }
    public void delete (Long id){
        pedidoRepository.deleteById(id);
    }
}
