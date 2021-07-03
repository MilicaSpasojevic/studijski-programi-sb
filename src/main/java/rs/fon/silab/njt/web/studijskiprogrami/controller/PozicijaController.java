/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.controller;

import java.awt.PageAttributes;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PozicijaDto;
import rs.fon.silab.njt.web.studijskiprogrami.service.PozicijaService;

/**
 *
 * @author Milica
 */
@RestController
@RequestMapping(path="/pozicija")
public class PozicijaController {
    private final PozicijaService pozicijaService;

    @Autowired
    public PozicijaController(PozicijaService pozicijaService) {
        this.pozicijaService = pozicijaService;
    }
    
    @GetMapping()
    //@Produces(MediaType.APPLICATION_JSON_VALUE)
    public List<PozicijaDto>  getAll() {
        List<PozicijaDto> pozicije = new ArrayList<>();
        try {
            pozicije = pozicijaService.getAll();
            for (PozicijaDto pozicija : pozicije) {
                System.out.println(pozicija);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        
        return pozicije;
    }
    
    
}
