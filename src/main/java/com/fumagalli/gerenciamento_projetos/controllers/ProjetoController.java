package com.fumagalli.gerenciamento_projetos.controllers;

import com.fumagalli.gerenciamento_projetos.models.ProjetoModel;
import com.fumagalli.gerenciamento_projetos.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<List<ProjetoModel>> findAll(){
        List<ProjetoModel> requeste = projetoService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity<ProjetoModel> criarProjeto(@RequestBody ProjetoModel projetoModel){
        ProjetoModel novo = projetoService.criarProjeto(projetoModel);
        return ResponseEntity.status(201).body(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProjeto(@PathVariable Long id){
        projetoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoModel> buscarPorIdProjeto(@PathVariable Long id){
        Optional<ProjetoModel> projeto = projetoService.buscarPorId(id);

        if(projeto.isPresent()){
            return ResponseEntity.ok(projeto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoModel> atualizarProjeto(@PathVariable Long id, @RequestBody ProjetoModel projetoModel){
        ProjetoModel atualizado = projetoService.atualizar(id, projetoModel);
        return ResponseEntity.ok().body(atualizado);
    }
}
