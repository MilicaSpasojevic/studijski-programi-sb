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
import rs.fon.silab.njt.web.studijskiprogrami.domain.Predmet;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PredmetDto;
import rs.fon.silab.njt.web.studijskiprogrami.service.PredmetService;
import rs.fon.silab.njt.web.studijskiprogrami.service.TipPredmetaService;
/**
 *
 * @author Milica
 */
@RestController
@RequestMapping(path="/predmet")
public class PredmetController {
    private final PredmetService predmetService;
    private final TipPredmetaService tpService;

    @Autowired
    public PredmetController(PredmetService predmetService, TipPredmetaService tpService) {
        this.predmetService = predmetService;
        this.tpService=tpService;
    }
    
    @GetMapping
    public List<PredmetDto> getAll() {
        List<PredmetDto> predmeti = new ArrayList<>();
        try {
            predmeti = predmetService.getAll();
            for (PredmetDto predmet : predmeti) {
                System.out.println(predmet);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
       
        return predmeti;
    }
    
    @PostMapping
    public void save(@RequestBody PredmetDto predmetDto){
        
        try {
            predmetService.save(predmetDto);
        } catch (Exception ex) {
            Logger.getLogger(PredmetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PutMapping("/{id}")
    public void update(@RequestBody PredmetDto predmetDto, @PathVariable Long id){
        try {
            predmetDto.setPredmetid(id);
            predmetService.update(predmetDto);
        } catch (Exception ex) {
            Logger.getLogger(PredmetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        try {
            predmetService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(PredmetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
}
