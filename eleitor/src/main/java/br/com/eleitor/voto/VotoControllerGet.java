package br.com.eleitor.voto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("votos")
public class VotoControllerGet {
    @Autowired
    private VotoService service;

    @GetMapping
    public List List(){
        return service.lista();
    }
}
