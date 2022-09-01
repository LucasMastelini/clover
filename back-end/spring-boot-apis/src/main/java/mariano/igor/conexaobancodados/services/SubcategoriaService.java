package mariano.igor.conexaobancodados.services;

import mariano.igor.conexaobancodados.dtos.CategoriaDto;
import mariano.igor.conexaobancodados.dtos.SubcategoriaDto;
import mariano.igor.conexaobancodados.models.CategoriaModel;
import mariano.igor.conexaobancodados.models.SubcategoriaModel;
import mariano.igor.conexaobancodados.repositories.ISubcategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubcategoriaService {

    @Autowired
    ISubcategoriaRepository subcategoriaRepository;


    public SubcategoriaDto cadastroSubcategoria(SubcategoriaModel subcategoriaModel) {
        return subcategoriaRepository.findAll().stream().anyMatch
                (x -> x.getDescricao().equals(subcategoriaModel.getDescricao()))
                ? null : new SubcategoriaDto(subcategoriaRepository.save
                (subcategoriaModel).getId(), subcategoriaModel.getDescricao());
    }


    public List<SubcategoriaDto> getListaSubcategoriasPorCategoria(long id) {
       List<SubcategoriaDto> subcategoriaDtos = new ArrayList<>();
        subcategoriaRepository.findByCategoriaId(id).forEach
                (subcategoria -> subcategoriaDtos.add
                        (new SubcategoriaDto(subcategoria.getId(), subcategoria.getDescricao())));

        return subcategoriaDtos;
    }

    public SubcategoriaDto atualizarSubcategoria(long id, SubcategoriaModel subcategoriaModel) {
        SubcategoriaModel subcategoria = subcategoriaRepository.findById(id).orElse(null);
        if(subcategoria != null){
            subcategoria.setDescricao(subcategoriaModel.getDescricao());
            return new SubcategoriaDto(subcategoriaRepository.save(subcategoria).getId(), subcategoria.getDescricao());
        }
        return null;
    }

    public boolean deletarSubcategoria(long id) {
        SubcategoriaModel subcategoria = subcategoriaRepository.findById(id).orElse(null);
        if(subcategoria != null){
            subcategoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
