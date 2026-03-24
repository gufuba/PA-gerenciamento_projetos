package com.fumagalli.gerenciamento_projetos.services;

import com.fumagalli.gerenciamento_projetos.models.ProjetoModel;
import com.fumagalli.gerenciamento_projetos.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository projetoRepository;

    public List<ProjetoModel> findAll(){
        return projetoRepository.findAll();
    }

    public ProjetoModel criarProjeto(ProjetoModel projetoModel){
        return projetoRepository.save(projetoModel);
    }

    public Optional<ProjetoModel> buscarPorId(Long id){
        return projetoRepository.findById(id);
    }

    public ProjetoModel atualizar(long id, ProjetoModel projetoModel){
        ProjetoModel model = projetoRepository.findById(id).get();
        model.setNome(projetoModel.getNome());
        model.setDataInicio(projetoModel.getDataInicio());
        model.setDataFim(projetoModel.getDataFim());

        return projetoRepository.save(model);
    }

    public void deletar(Long id){
        projetoRepository.deleteById(id);
    }

}
