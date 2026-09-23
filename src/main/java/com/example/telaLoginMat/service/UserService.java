//aqui recebemos os pedidos que a controler manda pra serem implementados aqui de acordo com as regras da aplicação

package com.example.telaLoginMat.service;

//Aqui vamos usar o repositorio de usuarios, o service usa o banco por ele
import com.example.telaLoginMat.repository.UserRepository;
//só salva no banco se sabe como é a classe, por isso estamos importando
import com.example.telaLoginMat.model.UserEntity;

import java.util.List;

//notação pra injeção de dependencia
import org.springframework.beans.factory.annotation.Autowired;

//importamos um steriotipo pra service, pra falar que isso é a camada de servico
import org.springframework.stereotype.Service;
@Service 
public class UserService {
    
   @Autowired 
   private UserRepository userRepository;

   //podemos ver que ja usamos um termo (findAll) da interface mongo
    public List<UserEntity> obterTodos() {
        return userRepository.findAll();
    }
   
    //recebemos o valor {id} e o @PathVariable coloca dentro dessa variavel de mesmo nome
    public UserEntity obterPorId(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity inserir(UserEntity user) {
        return userRepository.save(user);
    }
    
    public UserEntity atualizar(String id, UserEntity newUser) {
     //aqui criamos uma nova variavel do msm tipo pra salvar os dados do que procuramos
       UserEntity userExistente = userRepository.findById(id) //o find retorna um Optional, obviamente sendo opcional se vai ou n ter algo
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado")); 
        //se n encontra, lança um obj de erro criado cm o new

    //aqui dps q achou o user, setamos cada atributo com o get     
    userExistente.setNome(newUser.getNome());
    userExistente.setEmail(newUser.getEmail());
    userExistente.setSenha(newUser.getSenha());

    return userRepository.save(userExistente);

    }

    public void excluir(String id) {
        userRepository.deleteById(id);
    }
}
