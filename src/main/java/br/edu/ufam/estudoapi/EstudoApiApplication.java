package br.edu.ufam.estudoapi;

import br.edu.ufam.estudoapi.domain.Usuario;
import br.edu.ufam.estudoapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class EstudoApiApplication implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    public static void main(String[] args) {
        SpringApplication.run(EstudoApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Usuario u1 = new Usuario(null, "Carlos Daniel", "cdaniel", "123456");
        Usuario u2 = new Usuario(null, "Albert Einstaein", "albert","123456");

        usuarioRepository.saveAll(Arrays.asList(u1, u2));

    }
}
