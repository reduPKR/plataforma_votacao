package br.com.eleitor.eleitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("eleitor")
public class EleitorControllerGet {
    @Autowired
    private EleitorService service;

    @GetMapping
    public List List(){
       return service.lista();
    }
}
