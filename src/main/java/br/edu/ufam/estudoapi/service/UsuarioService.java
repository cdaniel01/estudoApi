package br.edu.ufam.estudoapi.service;

import br.edu.ufam.estudoapi.domain.Usuario;
import br.edu.ufam.estudoapi.repository.UsuarioRepository;
import br.edu.ufam.estudoapi.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    public Usuario findById(Integer id){
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+Usuario.class.getName()));
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario update(Integer id, Usuario usuario) {
        Usuario obj = findById(id);
        obj.setNome(usuario.getNome());
        obj.setLogin(usuario.getLogin());
        obj.setSenha(usuario.getSenha());

        return usuarioRepository.save(obj);
    }
}
