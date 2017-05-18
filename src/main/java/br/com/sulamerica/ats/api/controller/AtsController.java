package br.com.sulamerica.ats.api.controller;

import br.com.sulamerica.ats.api.beans.Ats;
import br.com.sulamerica.ats.api.beans.Protocolo;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "ats-api")
@Lazy(value = true)
public class AtsController {


    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Protocolo upload(@RequestBody Ats Ats) {

        Protocolo protocolo = new Protocolo();
        protocolo.setNumeroProtocolo(11l);

        return protocolo;
    }

}
