/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.fon.silab.njt.web.studijskiprogrami.dto.NivoStudijaDto;
import rs.fon.silab.njt.web.studijskiprogrami.service.NivoStudijaService;

/**
 *
 * @author STEFAN PC
 */
@RestController
@RequestMapping(path="/nivo-studija")
public class NivoStudijaController {
    private final NivoStudijaService nivoStudijaService;

    @Autowired
    public NivoStudijaController(NivoStudijaService nivoStudijaService) {
        this.nivoStudijaService = nivoStudijaService;
    }
    
    @GetMapping
    public ResponseEntity<List<NivoStudijaDto>> getAll() {
        List<NivoStudijaDto> nivoiStudija = new ArrayList<>();
        try {
            nivoiStudija = nivoStudijaService.getAll();
            for (NivoStudijaDto ns : nivoiStudija) {
                System.out.println(ns);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        
       
        return new ResponseEntity<>(nivoiStudija,HttpStatus.OK);
    }
    
}
