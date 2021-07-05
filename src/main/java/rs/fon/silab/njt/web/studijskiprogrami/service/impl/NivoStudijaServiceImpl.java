/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Fakultet;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Nivostudija;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Tippredmeta;
import rs.fon.silab.njt.web.studijskiprogrami.repository.FakultetRepository;
import rs.fon.silab.njt.web.studijskiprogrami.repository.NivoStudijaRepository;
import rs.fon.silab.njt.web.studijskiprogrami.repository.TipPredmetaRepository;
import rs.fon.silab.njt.web.studijskiprogrami.service.FakultetService;
import rs.fon.silab.njt.web.studijskiprogrami.service.NivoStudijaService;
import rs.fon.silab.njt.web.studijskiprogrami.service.TipPredmetaService;

/**
 *
 * @author milos
 */
@Service
public class NivoStudijaServiceImpl implements NivoStudijaService{

    private final NivoStudijaRepository nsRepository;

    @Autowired
    public NivoStudijaServiceImpl(NivoStudijaRepository nsRepository) {
        this.nsRepository = nsRepository;
    }
    
    
    
    
    @Override
    public List<Nivostudija> getAll() throws Exception {
        return nsRepository.findAll();
    }

    @Override
    public Nivostudija findById(Long id) throws Exception {
        return nsRepository.getById(id);
    }
    
    
    
}
