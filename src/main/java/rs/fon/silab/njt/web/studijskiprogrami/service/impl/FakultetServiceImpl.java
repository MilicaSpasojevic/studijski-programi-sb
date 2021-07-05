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
import rs.fon.silab.njt.web.studijskiprogrami.domain.Tippredmeta;
import rs.fon.silab.njt.web.studijskiprogrami.repository.FakultetRepository;
import rs.fon.silab.njt.web.studijskiprogrami.repository.TipPredmetaRepository;
import rs.fon.silab.njt.web.studijskiprogrami.service.FakultetService;
import rs.fon.silab.njt.web.studijskiprogrami.service.TipPredmetaService;

/**
 *
 * @author milos
 */
@Service
public class FakultetServiceImpl implements FakultetService{

    private final FakultetRepository fakultetRepository;

    @Autowired
    public FakultetServiceImpl(FakultetRepository tpRepository) {
        this.fakultetRepository = tpRepository;
    }
    
    
    
    
    @Override
    public List<Fakultet> getAll() throws Exception {
        return fakultetRepository.findAll();
    }

    @Override
    public Fakultet findById(Long id) throws Exception {
        return fakultetRepository.getById(id);
    }
    
    
    
}
