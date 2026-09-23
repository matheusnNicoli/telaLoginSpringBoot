package com.example.telaLoginMat.repository;
import com.example.telaLoginMat.model.UserEntity;

//.repository é uma camada que acessa dados no db, mas .MongoRepository especifico pra mongodb
import org.springframework.data.mongodb.repository.MongoRepository;
//aq vamos fazer uma notação pra o spring entender que isso é um repository
//stereotype é usado pra definir o papel de classe na aplicação em si usando a anotação @Repository
//pode confundir com a annotation que usamos dentro de .data que serve pro banco
import org.springframework.stereotype.Repository;

@Repository 
//estamos criando uma interface que herda funçoes do mongo pra manipular o UserEntity e o id dele é string
public interface UserRepository extends MongoRepository<UserEntity, String>{

    
}
