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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rs.fon.silab.njt.web.studijskiprogrami.dto.StudijskiProgramDto;
import rs.fon.silab.njt.web.studijskiprogrami.service.FakultetService;
import rs.fon.silab.njt.web.studijskiprogrami.service.NivoStudijaService;
import rs.fon.silab.njt.web.studijskiprogrami.service.StudijskiProgramService;

/**
 *
 * @author milos
 */
@RestController
@RequestMapping(path = "/studijski-program")
public class StudijskiProgramController {

    private final StudijskiProgramService studijskiProgramService;
    private final FakultetService fakultetService;
    private final NivoStudijaService nivoStudijaService;

    @Autowired
    public StudijskiProgramController(StudijskiProgramService spService, FakultetService fakultetService, NivoStudijaService nivoStudijaService) {
        this.studijskiProgramService = spService;
        this.fakultetService = fakultetService;
        this.nivoStudijaService = nivoStudijaService;
    }

    @GetMapping
    public ResponseEntity<List<StudijskiProgramDto>> getAll() {
        List<StudijskiProgramDto> studijskiProgrami = new ArrayList<>();
        try {
            studijskiProgrami = studijskiProgramService.getAll();
            for (StudijskiProgramDto sp : studijskiProgrami) {
                System.out.println(sp);
            }

        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(studijskiProgrami, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody StudijskiProgramDto spDto) {

        try {
            studijskiProgramService.save(spDto);
            return new ResponseEntity<>("Uspesno sacuvan", HttpStatus.CREATED);
        } catch (Exception ex) {
//            Logger.getLogger(StudijskiProgramController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Neuspesno sacuvan", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody StudijskiProgramDto spDto, @PathVariable Long id) {
        try {
            spDto.setStudijskiProgramId(id);
            studijskiProgramService.update(spDto);
            return new ResponseEntity<>("Uspesno sacuvan", HttpStatus.OK);

        } catch (Exception ex) {
//            Logger.getLogger(StudijskiProgramController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Neuspesno sacuvan", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            studijskiProgramService.delete(id);
            return new ResponseEntity<>("Uspesno brisanje", HttpStatus.OK);
        } catch (Exception ex) {
//            Logger.getLogger(StudijskiProgramController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Neuspesno brisanje", HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/status")
    public ResponseEntity<List<StudijskiProgramDto>> getByStatus(@RequestParam(required = true, name ="status") int status) {
        List<StudijskiProgramDto> studijskiProgrami = new ArrayList<>();
        try {
            studijskiProgrami = studijskiProgramService.findByStatus(status);
            for (StudijskiProgramDto sp : studijskiProgrami) {
                System.out.println(sp);
            }

        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(studijskiProgrami, HttpStatus.OK);
    }
}
