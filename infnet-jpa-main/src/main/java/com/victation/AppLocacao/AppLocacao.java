package com.victation.AppLocacao;

import com.victation.AppLocacao.model.domain.*;
import com.victation.AppLocacao.model.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class AppLocacao {

    public static void main(String[] args) {
        SpringApplication.run(AppLocacao.class, args);
    }

    @Bean
    public CommandLineRunner run(CarroRepository carroRepository, MotoRepository motoRepository, CaminhaoRepository caminhaoRepository, UsuarioRepository usuarioRepository, LocacaoRepository locacaoRepository, LocatarioRepository locatarioRepository) {
        System.out.println("--------------------CommandLineRunner------------------");
        return args -> {
            System.out.println("--------------------Inserindo no banco------------------");

            carroRepository.save(new Carro("BMW", "AFK-4000", 4));
            motoRepository.save(new Moto(500, "DT-3"));
            caminhaoRepository.save(new Caminhao("Tipo A", 4, 3000));
            usuarioRepository.save(new Usuario("Pessoa", "email@gmail.com", "123123"));
            locatarioRepository.save(new Locatario("Locatario", "Sobrenome", "123.123.123.89", "email@email.com"));

            List<Carro> carros = (List<Carro>) carroRepository.findAll();
            List<Caminhao> caminhaos = (List<Caminhao>) caminhaoRepository.findAll();
            List<Moto> motos = (List<Moto>) motoRepository.findAll();
            List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
            List<Locatario> locatario = (List<Locatario>) locatarioRepository.findAll();

            System.out.println(locatario);
            System.out.println(carros);
            System.out.println(caminhaos);
            System.out.println(motos);
            System.out.println(usuarios);


        };
    }

}

