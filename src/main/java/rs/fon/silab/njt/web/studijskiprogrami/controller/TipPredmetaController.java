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
import rs.fon.silab.njt.web.studijskiprogrami.dto.PredmetDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.TipPredmetaDto;
import rs.fon.silab.njt.web.studijskiprogrami.service.TipPredmetaService;

/**
 *
 * @author Milica
 */
@RestController
@RequestMapping(path = "/tip-predmeta")
public class TipPredmetaController {
   
    private final TipPredmetaService tpService;

    @Autowired
    public TipPredmetaController(TipPredmetaService tpService) {
        this.tpService = tpService;
    }
    
    
    
    @GetMapping
    public ResponseEntity<List<TipPredmetaDto>> getAll() {
        List<TipPredmetaDto> predmeti = new ArrayList<>();
        try {
            predmeti = tpService.getAll();

        } catch (Exception ex) {
//            ex.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(predmeti, HttpStatus.OK);
    }
    
    
}
