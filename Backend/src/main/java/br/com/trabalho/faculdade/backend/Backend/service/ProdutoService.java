package br.com.trabalho.faculdade.backend.Backend.service;

import br.com.trabalho.faculdade.backend.Backend.dto.request.ProdutoRequestDto;
import br.com.trabalho.faculdade.backend.Backend.dto.response.ProdutoResponseDto;
import br.com.trabalho.faculdade.backend.Backend.mapper.ProdutoMapper;
import br.com.trabalho.faculdade.backend.Backend.model.Produto;
import br.com.trabalho.faculdade.backend.Backend.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

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
    public void delete (Long id){
        produtoRepository.deleteById(id);
    }
}
