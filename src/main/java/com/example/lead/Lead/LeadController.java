package com.example.lead.Lead;

import com.example.lead.Lead.DTOs.LeadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lead")
public class LeadController {

    @Autowired
    LeadService leadService;

    @GetMapping
    public List<LeadDto> exibirLeads (){
        return leadService.exibirLeads();
    }

    @GetMapping("/{nome}")
    public LeadDto encontrarLead (@PathVariable String nome){
        return leadService.encontrarLead(nome);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarLead (@RequestBody LeadDto leadDto){
        leadService.cadastrarLead(leadDto);
    }

}
