/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.fon.silab.njt.web.studijskiprogrami.dto.KorisnikDto;
import rs.fon.silab.njt.web.studijskiprogrami.service.KorisnikService;

/**
 *
 * @author Milica
 */
@RestController
@RequestMapping(path = "/login")
public class KorisnikController {
    private final KorisnikService korisnikService;

    @Autowired
    public KorisnikController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }
    
    
    @GetMapping
    public ResponseEntity<String> login(@RequestBody KorisnikDto korisnik){
        KorisnikDto kor;
        try {
            kor = korisnikService.findById(korisnik.getUsername());
            if(kor.getPassword().equals(korisnik.getPassword())){
                return new ResponseEntity<>("Uspesno ste se ulogovali!", HttpStatus.OK);
            } else return new ResponseEntity<>("Pogresni kredencijali", HttpStatus.UNAUTHORIZED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
        }
        
    }
    
}
