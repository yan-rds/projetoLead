package com.example.lead.Lead;

import com.example.lead.Lead.DTOs.LeadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
