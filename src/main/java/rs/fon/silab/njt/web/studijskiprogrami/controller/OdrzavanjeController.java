/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Modul;
import rs.fon.silab.njt.web.studijskiprogrami.dto.ModulDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.OdrzavanjeBackDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.OdrzavanjeDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.impl.ModulMapper;
import rs.fon.silab.njt.web.studijskiprogrami.service.ModulService;
import rs.fon.silab.njt.web.studijskiprogrami.service.OdrzavanjeService;

/**
 *
 * @author Milica
 */
@RestController
@RequestMapping(path = "/odrzavanje")
public class OdrzavanjeController {

    private final OdrzavanjeService odrzavanjeService;
    private final ModulService modulService;
    private final ModulMapper modulMapper;

    @Autowired
    public OdrzavanjeController(OdrzavanjeService odrzavanjeService, ModulService modulService, ModulMapper modulMapper) {
        this.odrzavanjeService = odrzavanjeService;
        this.modulService = modulService;
        this.modulMapper = modulMapper;
    }

    @PostMapping("/{modulId}")
    public ResponseEntity<String> save(@RequestBody List<OdrzavanjeDto> odrzavanja, @PathVariable Long modulId) {
        System.out.println("MODUL JE: " + modulId);
        for (OdrzavanjeDto odrz : odrzavanja) {
            odrz.setModulId(modulId);
        }

        try {
            odrzavanjeService.save(odrzavanja);
            return new ResponseEntity<>("Uspesno uneseno odrzavanje", HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(OdrzavanjeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Neuspesno unosenje odrzavanja", HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/{modulId}/{godinaId}")
    public ResponseEntity<List<OdrzavanjeBackDto>> getAll(@PathVariable Long modulId, @PathVariable Long godinaId) {
        List<OdrzavanjeBackDto> odrzavanja = new ArrayList<>();
        try {
            odrzavanja = odrzavanjeService.getAll(modulId, godinaId);

        } catch (Exception ex) {
            Logger.getLogger(OdrzavanjeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(odrzavanja, HttpStatus.OK);
    }

    @GetMapping("/modul")
    public ResponseEntity<List<OdrzavanjeBackDto>> getByModul(@RequestParam(required = true, name = "modul") Long modul) {
        List<OdrzavanjeBackDto> odrzavanja = new ArrayList<>();
        try {
            ModulDto m = modulService.findById(modul);
            odrzavanja = odrzavanjeService.getByModul(modulMapper.toEntity(m));

        } catch (Exception ex) {
            Logger.getLogger(OdrzavanjeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(odrzavanja, HttpStatus.OK);
    }
}
