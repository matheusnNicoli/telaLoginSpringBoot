package com.example.telaLoginMat.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
//vai associar solicitações get a metodos especificos
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//notação pra injeção de dependencia
import org.springframework.beans.factory.annotation.Autowired;
//a annotation RestController retorna Json por ser tipo rest, por isso está comentada
//.stereotype é um pacote que tem anotações pra falar papeis de classe, um esteriotipo pra cada coisa no caso uma controller
//.Controller diz q vai controlar as requisições web, mas aqui vamos retornar pags HTML por ser Thymeleaf
import org.springframework.stereotype.Controller;
//indica que a classe é um controller
//import org.springframework.web.bind.annotation.RestController;

import com.example.telaLoginMat.model.UserEntity;
//importamos o service pra mandarmos pro caminho certo e la é decidido oq é feito 
import com.example.telaLoginMat.service.UserService;

//.web parte do spring pra web;.bind vem de conectar, conectar a requisição com os metodos daqui
//.PostMapping uma das anotações que vai mostrar qual metodo vai receber um post
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//mais uma anotação, servie pra pegar um valor que veio na url e colocar na variavel que tem a anotação
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import pra fazer a lista de usuarios
import java.util.List;

@RestController 
//pra tudo começar cm /users, se for pesquiser /id, vai automaticamente ser/user/id
@RequestMapping("/users")
public class UserController {
    
    

    //injeção de dependencia
    //spring qnd inicia ja cria o obj service, e qnd encontrar essa notação
    //injeta o objeta o obj na variavel userService
    @Autowired
    private UserService userService;
    //se criassemos o obj aqui, o acoplamento seria alto, se o service precisasse de outras coisas
    // como repository e etc, precisariamos criar aq tbm

   @GetMapping //ja temos o endpoint base ja definido
   //aqui vamos retornar um tipo lista com usuarios
   public List<UserEntity> obterTodos(){
    return userService.obterTodos();
   }

   @GetMapping ("/{id}")//aq agnt fala q o id vai ser um valor especifico
   //o @PathVariable pega o valor dentro de {} e coloca no id
   public UserEntity obterPorId(@PathVariable String id) {
        return userService.obterPorId(id);
    }
    
    @PostMapping 
    //vai pegar oq a requisição tem pra enviar (corpo/body), e vai colocar dentro do obj
    public UserEntity inserir (@RequestBody UserEntity user){
        return userService.inserir(user);
    }
    //pegamos o id,pedimos o corpo da requisição e atualizamos com o proprio
    @PutMapping("/{id}")
    public UserEntity atualizar(
            @PathVariable String id,
            @RequestBody UserEntity user) {

        return userService.atualizar(id, user);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable String id) {
        userService.excluir(id);
    }

}
