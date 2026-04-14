package br.com.trabalho.faculdade.backend.Backend.service;

import br.com.trabalho.faculdade.backend.Backend.dto.request.ProdutoRequestDto;
import br.com.trabalho.faculdade.backend.Backend.dto.response.ProdutoResponseDto;
import br.com.trabalho.faculdade.backend.Backend.mapper.ProdutoMapper;
import br.com.trabalho.faculdade.backend.Backend.model.Produto;
import br.com.trabalho.faculdade.backend.Backend.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    public ProdutoResponseDto create (ProdutoRequestDto dto){
        if (dto.preco().compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("O preço não pode ser menor que 0");
        }
        Produto produto = produtoMapper.toEntity(dto);

        produto = produtoRepository.save(produto);

        return produtoMapper.toDto(produto);
    }
    public ProdutoResponseDto getById (Long id){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id do produto não encontrada"));

        return produtoMapper.toDto(produto);
    }
    public List<ProdutoResponseDto> getAll (){
        return produtoRepository.findAll().stream()
                .map(produtoMapper :: toDto)
                .toList();
    }
    public List<ProdutoResponseDto> getByName (String nome){
        return produtoRepository.findAll().stream()
                .filter(n -> n.getNome().toLowerCase().contains(nome.toLowerCase()))
                .map(n -> new ProdutoResponseDto(
                        n.getId(),
                        n.getNome(),
                        n.getPreco(),
                        n.getEstoque()
                        )
                )
                .toList();
    }
    public ProdutoResponseDto update (Long id, ProdutoRequestDto dto){
        if (id < 0){
            throw new RuntimeException("Id não pode ser negativo");
        }
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Id não pode ser encontrado"));
        if (dto.preco().compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("O preço não pode ser menor que 0");
        }

        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setEstoque(dto.estoque());

        produto = produtoRepository.save(produto);

        return produtoMapper.toDto(produto);
    }
    public void delete (Long id){
        produtoRepository.deleteById(id);
    }
}
