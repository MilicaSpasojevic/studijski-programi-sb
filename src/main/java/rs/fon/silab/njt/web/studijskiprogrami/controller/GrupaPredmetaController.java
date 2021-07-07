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
import rs.fon.silab.njt.web.studijskiprogrami.dto.GrupaPredmetaDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PredmetDto;
import rs.fon.silab.njt.web.studijskiprogrami.service.GrupaPredmetaService;

/**
 *
 * @author Milica
 */
@RestController
@RequestMapping(path = "/grupa-predmeta")
public class GrupaPredmetaController {
    private final GrupaPredmetaService grupaService;

    @Autowired
    public GrupaPredmetaController(GrupaPredmetaService grupaService) {
        this.grupaService = grupaService;
    }
    
    @GetMapping
    public ResponseEntity<List<GrupaPredmetaDto>> getAll() {
        List<GrupaPredmetaDto> predmeti = new ArrayList<>();
        try {
            predmeti = grupaService.getAll();

        } catch (Exception ex) {
//            ex.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(predmeti, HttpStatus.OK);
    }
    
}
