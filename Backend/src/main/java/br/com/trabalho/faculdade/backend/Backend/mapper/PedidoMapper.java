package br.com.trabalho.faculdade.backend.Backend.mapper;

import br.com.trabalho.faculdade.backend.Backend.dto.request.PedidoRequestDto;
import br.com.trabalho.faculdade.backend.Backend.dto.response.PedidoResponseDto;
import br.com.trabalho.faculdade.backend.Backend.model.Cliente;
import br.com.trabalho.faculdade.backend.Backend.model.Pedido;
import br.com.trabalho.faculdade.backend.Backend.model.Produto;
import br.com.trabalho.faculdade.backend.Backend.repository.ClienteRepository;
import br.com.trabalho.faculdade.backend.Backend.repository.ProdutoRepository;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoMapper(ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public Pedido toEntity (PedidoRequestDto dto){
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
        Produto produto = produtoRepository.findById(dto.produtoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));


        Pedido pedido = new Pedido();

        pedido.setClienteId(cliente);
        pedido.setProdutoId(produto);
        pedido.setQuantidade(dto.quantidade());

        return pedido;

    }
    public PedidoResponseDto toDto (Pedido pedido){
        return new PedidoResponseDto(
                pedido.getId(),
                pedido.getClienteId().getId(),
                pedido.getProdutoId().getId(),
                pedido.getQuantidade()
        );
    }
}
