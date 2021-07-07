/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.controller;

import java.awt.PageAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping(path = "/pozicija")
public class PozicijaController {

    private final PozicijaService pozicijaService;

    @Autowired
    public PozicijaController(PozicijaService pozicijaService) {
        this.pozicijaService = pozicijaService;
    }

    @GetMapping()
    //@Produces(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PozicijaDto>> getAll() {
        List<PozicijaDto> pozicije = new ArrayList<>();
        try {
            pozicije = pozicijaService.getAll();
            for (PozicijaDto pozicija : pozicije) {
                System.out.println(pozicija);
            }

        } catch (Exception ex) {
//            ex.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(pozicije, HttpStatus.OK);
    }

    @PostMapping("/{idsp}/{godina}")
    public ResponseEntity<String> save(@RequestBody List<PozicijaDto> pozdto, @PathVariable Long idsp, @PathVariable Long godina){
        try {
            for(PozicijaDto poz : pozdto){
                poz.setGodina(godina);
                poz.setStudijskiProgramId(idsp);
                
            }
            
            pozicijaService.save(pozdto);
            return new ResponseEntity<>("Uspesno unesena pozicija", HttpStatus.CREATED);
        } catch (Exception ex) {
//            Logger.getLogger(PozicijaController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Neuspesno unesena pozicija", HttpStatus.BAD_REQUEST);
        }
        
    }
}
