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
import rs.fon.silab.njt.web.studijskiprogrami.dto.StudijskiProgramDto;
import rs.fon.silab.njt.web.studijskiprogrami.service.FakultetService;
import rs.fon.silab.njt.web.studijskiprogrami.service.NivoStudijaService;
import rs.fon.silab.njt.web.studijskiprogrami.service.StudijskiProgramService;
/**
 *
 * @author milos
 */
@RestController
@RequestMapping(path="/studijski-program")
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
    public List<StudijskiProgramDto> getAll() {
        List<StudijskiProgramDto> studijskiProgrami = new ArrayList<>();
        try {
            studijskiProgrami = studijskiProgramService.getAll();
            for (StudijskiProgramDto sp : studijskiProgrami) {
                System.out.println(sp);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
       
        return studijskiProgrami;
    }
    
    @PostMapping
    public void save(@RequestBody StudijskiProgramDto spDto){
        
        try {
            studijskiProgramService.save(spDto);
        } catch (Exception ex) {
            Logger.getLogger(StudijskiProgramController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PutMapping("/{id}")
    public void update(@RequestBody StudijskiProgramDto spDto, @PathVariable Long id){
        try {
            spDto.setStudijskiProgramId(id);
            studijskiProgramService.update(spDto);
        } catch (Exception ex) {
            Logger.getLogger(StudijskiProgramController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        try {
            studijskiProgramService.delete(id);
        } catch (Exception ex) {
            Logger.getLogger(StudijskiProgramController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
}
