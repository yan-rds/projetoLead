package com.example.lead.Lead;

import com.example.lead.Lead.DTOs.LeadDto;
import com.example.lead.Lead.DTOs.ProdutoDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeadService {

    List <LeadDto> leads = new ArrayList<>();
    List <ProdutoDto> produtos = new ArrayList<>();

    public List <LeadDto> exibirLeads (){
        return leads;
    }



}
