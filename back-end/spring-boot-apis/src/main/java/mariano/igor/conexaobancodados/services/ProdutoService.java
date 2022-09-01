package mariano.igor.conexaobancodados.services;

import mariano.igor.conexaobancodados.dtos.ProdutoDto;
import mariano.igor.conexaobancodados.dtos.SubcategoriaDto;
import mariano.igor.conexaobancodados.models.ProdutoModel;
import mariano.igor.conexaobancodados.models.SubcategoriaModel;
import mariano.igor.conexaobancodados.repositories.IProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    IProdutoRepository produtoRepository;

    public ProdutoDto cadastroProduto(ProdutoModel produtoModel) {
        return produtoRepository.findAll().stream().anyMatch
                (x -> x.getDescricao().equals(produtoModel.getDescricao()))
                ? null : new ProdutoDto(produtoRepository.save
                (produtoModel).getSku(), produtoModel.getNome(), produtoModel.getDescricao(),
                produtoModel.getValor(), produtoModel.getEspecificacoes(), produtoModel.getImagens(),
                produtoModel.getSubcategorias());
    }
}
