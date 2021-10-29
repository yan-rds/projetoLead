package com.example.lead.Lead;

import com.example.lead.Lead.DTOs.LeadDto;
import com.example.lead.Lead.DTOs.ProdutoDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class LeadService {

    List <LeadDto> leads = new ArrayList<>();

    public List <LeadDto> exibirLeads (){
        return leads;
    }

    public void verificarProdutosIguais (String nome, LeadDto leadDto){
        LeadDto leadExistente = encontrarLead(nome);
        int numeroDeProdutos = leadDto.getProdutos().size();
        while (numeroDeProdutos != 0){
          for (ProdutoDto produtosCadastrados : leadExistente.getProdutos()){
              if (produtosCadastrados.equals(leadDto.getProdutos().get(numeroDeProdutos - 1))){
                  throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
              }
              numeroDeProdutos --;
          }
        }
    }

    public void cadastrarLead (LeadDto leadDto){
        if (verificarLeadRepetido(leadDto)){
           String nome = leadDto.getNome();
           verificarProdutosIguais(nome, leadDto);
           atualizarProdutos(nome, leadDto);
        }
        else {
            leads.add(leadDto);
        }
    }

    public LeadDto encontrarLead (String nome){
        Optional<LeadDto> leadEncontrada = leads.stream().filter(leadDto -> leadDto.getNome().equalsIgnoreCase(nome)).findFirst();
        if (leadEncontrada.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return leadEncontrada.get();
    }

    public boolean verificarLeadRepetido (LeadDto leadDto){
        boolean leadCadastrado = false;
        for (LeadDto referencia : leads){
            if (referencia.getEmail().equalsIgnoreCase(leadDto.getEmail()) &
            referencia.getNome().equalsIgnoreCase(leadDto.getNome()) &
            referencia.getTelefone().equalsIgnoreCase(leadDto.getTelefone())){
                leadCadastrado = true;
            }
        }
        return leadCadastrado;
    }

    public LeadDto atualizarLead (String nome, LeadDto leadDto){
        LeadDto leadAAtualizar = encontrarLead(nome);
        leadAAtualizar.setEmail(leadDto.getEmail());
        leadAAtualizar.setNome(leadDto.getNome());
        leadAAtualizar.setTelefone(leadDto.getNome());
        atualizarProdutos(nome, leadDto);
        return leadAAtualizar;
    }

    public void atualizarProdutos (String nome, LeadDto leadDto){
        LeadDto leadEncontrado = encontrarLead(nome);
        for (ProdutoDto referencia : leadDto.getProdutos()){
            leadEncontrado.getProdutos().add(referencia);
        }
    }








}
