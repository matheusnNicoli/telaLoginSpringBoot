package com.example.telaLoginMat;

//dentro do sprint entramos no boot(é oq vamos trabalhar)
import org.springframework.boot.SpringApplication;

//auto config ja organiza automaticamente coisas como web, servidor http sem eu ficar fazendo manualmente
import org.springframework.boot.autoconfigure.SpringBootApplication;

//org.springframework organização e qual, data -> parte de db, mongodb-> especifica qual
//.repository-> entra no sistema de repositorios, .config-> entra na config e dps ativa
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//isso fala pro springboot scanear a partir do com.example, em vez de so ver aq ele vai ver controler model e etc
@SpringBootApplication(scanBasePackages = {"com.example"})

//chama o mongo e fala onde vai ter os repos, ja tem um pra usuario
@EnableMongoRepositories("com.example.telaLoginMat.repository")

public class TelaLoginMatApplication {
	public static void main(String[] args) {
		SpringApplication.run(TelaLoginMatApplication.class, args);
	}

}
