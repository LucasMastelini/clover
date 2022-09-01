package mariano.igor.conexaobancodados.services;

import mariano.igor.conexaobancodados.dtos.CategoriaDto;
import mariano.igor.conexaobancodados.dtos.ProdutoDto;
import mariano.igor.conexaobancodados.dtos.SubcategoriaDto;
import mariano.igor.conexaobancodados.models.CategoriaModel;
import mariano.igor.conexaobancodados.repositories.ICategoriaRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
    @Autowired
    ICategoriaRepository categoriaRepository;

    public CategoriaDto cadastrarCategoria(CategoriaModel categoriaModel) {
        return categoriaRepository.findAll().stream().anyMatch
                (x -> x.getDescricao().equals(categoriaModel.getDescricao()))
                ? null :  new CategoriaDto(categoriaRepository.save
                (categoriaModel).getId(), categoriaModel.getDescricao());
    }

    public List<CategoriaDto> getListaCategorias() {
        List<CategoriaDto> categoriasDto = new ArrayList<>();
        categoriaRepository.findAll().stream().forEach
                (categoria -> categoriasDto.add
                        (new CategoriaDto(categoria.getId(), categoria.getDescricao())));
        return categoriasDto;
    }

    public CategoriaDto atualizarCategoria(long id, CategoriaModel categoriaModel) {
        CategoriaModel categoria = categoriaRepository.findById(id).orElse(null);
        if(categoria != null){
            categoria.setDescricao(categoriaModel.getDescricao());
            return new CategoriaDto(categoriaRepository.save(categoria).getId(), categoria.getDescricao());
        }
        return null;
    }

    public boolean deletarCategoria(long id) {
        CategoriaModel categoria = categoriaRepository.findById(id).orElse(null);
        if(categoria != null){
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
