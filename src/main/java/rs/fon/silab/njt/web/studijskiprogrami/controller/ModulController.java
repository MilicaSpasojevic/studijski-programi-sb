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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.fon.silab.njt.web.studijskiprogrami.dto.ModulDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.StudijskiProgramDto;
import rs.fon.silab.njt.web.studijskiprogrami.service.FakultetService;
import rs.fon.silab.njt.web.studijskiprogrami.service.ModulService;
import rs.fon.silab.njt.web.studijskiprogrami.service.NivoStudijaService;
import rs.fon.silab.njt.web.studijskiprogrami.service.StudijskiProgramService;

/**
 *
 * @author milos
 */
@RestController
@RequestMapping(path = "/modul")
public class ModulController {

    private final StudijskiProgramService studijskiProgramService;
    private final ModulService modulService;

    @Autowired
    public ModulController(StudijskiProgramService spService, ModulService modulService) {
        this.studijskiProgramService = spService;
        this.modulService = modulService;
    }

    @GetMapping
    public ResponseEntity<List<ModulDto>> getAll() {
        List<ModulDto> moduli = new ArrayList<>();
        try {
            moduli = modulService.getAll();
            for (ModulDto modul : moduli) {
                System.out.println(modul);
            }

        } catch (Exception ex) {
//            ex.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(moduli, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody ModulDto modulDto) {

        try {
            modulService.save(modulDto);
            return new ResponseEntity<>("Uspesno upisan modul", HttpStatus.CREATED);
        } catch (Exception ex) {

            Logger.getLogger(ModulController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Neuspesno upisenje modula", HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody ModulDto modulDto, @PathVariable Long id) {
        try {
            modulDto.setModulId(id);
            modulService.update(modulDto);
            return new ResponseEntity<>("Uspesno izmenjen modul", HttpStatus.OK);

        } catch (Exception ex) {
            Logger.getLogger(ModulController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Neuspesno upisenje modula", HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            modulService.delete(id);
            return new ResponseEntity<>("Uspesno obrisan modul", HttpStatus.OK);

        } catch (Exception ex) {
            Logger.getLogger(ModulController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Neuspesno briisanje modula", HttpStatus.BAD_REQUEST);

        }
    }

}
