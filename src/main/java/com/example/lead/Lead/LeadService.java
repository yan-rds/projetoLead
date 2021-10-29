package com.example.lead.Lead;

import com.example.lead.Lead.DTOs.LeadDto;
import com.example.lead.Lead.DTOs.ProdutoDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LeadService {

    List <LeadDto> leads = new ArrayList<>();
    List <ProdutoDto> produtos = new ArrayList<>();

    public List <LeadDto> exibirLeads (){
        return leads;
    }

    public void cadastrarLead (LeadDto leadDto){
        leads.add(leadDto);
    }

    public LeadDto encontrarLead (String nome){
        Optional<LeadDto> leadEncontrada = leads.stream().filter(leadDto -> leadDto.getNome().equalsIgnoreCase(nome)).findFirst();
        if (leadEncontrada.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return leadEncontrada.get();
    }



}
