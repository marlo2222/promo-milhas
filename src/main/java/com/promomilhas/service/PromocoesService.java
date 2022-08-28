package com.promomilhas.service;

import com.promomilhas.model.Publicacao;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PromocoesService {

    public List<Publicacao> listaPublicacoes = new ArrayList<>();

    public List<Publicacao> buscarPromocoes() throws IOException {
        Elements publicacoes =  Jsoup.connect(url()).get().body().select("article");
        for(Element publicacao : publicacoes){
            if(publicacao.hasText()){
                listaPublicacoes.add(new Publicacao(
                        publicacao.select("h1").text(),
                        publicacao.select("time").attr("datetime"),
                        publicacao.select("a").get(1).text()
                ));
            }
        };
        return listaPublicacoes;
    }

    private String url(){
        return "https://passageirodeprimeira.com/categorias/promocoes/";
    }
}
