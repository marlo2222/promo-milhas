package com.promomilhas.controller;

import com.promomilhas.model.Publicacao;
import com.promomilhas.service.PromocoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PromocoesController {
    @Autowired
    PromocoesService promocoesService;

    @RequestMapping(method = RequestMethod.GET, value = "/promocoes")
    public ResponseEntity listarPromocoes() throws IOException {
        List<Publicacao> response = promocoesService.buscarPromocoes();
        if (response.isEmpty()){
            return new ResponseEntity("Sem promoções diponiveis", HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }

}
