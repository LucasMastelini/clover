package mariano.igor.conexaobancodados.services;

import mariano.igor.conexaobancodados.dtos.UsuarioDto;
import mariano.igor.conexaobancodados.models.UsuarioModel;
import mariano.igor.conexaobancodados.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    IUsuarioRepository usuarioRepository;

    public List<UsuarioModel> getListaUsuarios() {
        return usuarioRepository.findAll();
    }

    public UsuarioModel cadastrarUsuario(UsuarioDto usuarioDto) {

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setCelular(usuarioDto.getCelular());
        usuarioModel.setCpf(usuarioDto.getCpf());
        usuarioModel.setNome(usuarioDto.getNome());
        usuarioModel.setEmail(usuarioDto.getEmail());
        usuarioModel.setSexo(usuarioDto.getSexo());
        usuarioModel.setTelefone(usuarioDto.getTelefone());
        usuarioModel.setSenha(usuarioDto.getSenha());


        return usuarioRepository.save(usuarioModel);
    }


    public Optional<UsuarioModel> getPorId(long id) {
        return usuarioRepository.findById(id);
    }
}
