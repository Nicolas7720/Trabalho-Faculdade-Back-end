package br.com.trabalho.faculdade.backend.Backend.mapper;

import br.com.trabalho.faculdade.backend.Backend.dto.request.ProdutoRequestDto;
import br.com.trabalho.faculdade.backend.Backend.dto.response.ProdutoResponseDto;
import br.com.trabalho.faculdade.backend.Backend.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {
    public Produto toEntity (ProdutoRequestDto dto){
        Produto produto = new Produto();

        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setEstoque(dto.estoque());

        return produto;
    }
    public ProdutoResponseDto toDto (Produto produto){
        return new ProdutoResponseDto(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getEstoque()
        );
    }
}
