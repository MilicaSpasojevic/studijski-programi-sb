/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Tippredmeta;
import rs.fon.silab.njt.web.studijskiprogrami.repository.TipPredmetaRepository;
import rs.fon.silab.njt.web.studijskiprogrami.service.TipPredmetaService;

/**
 *
 * @author Milica
 */
@Service
public class TipPredmetaServiceImpl implements TipPredmetaService{

    private final TipPredmetaRepository tpRepository;

    @Autowired
    public TipPredmetaServiceImpl(TipPredmetaRepository tpRepository) {
        this.tpRepository = tpRepository;
    }
    
    
    
    
    @Override
    public List<Tippredmeta> getAll() throws Exception {
        return tpRepository.findAll();
    }

    @Override
    public Tippredmeta findById(Long id) throws Exception {
        return tpRepository.getById(id);
    }
    
    
    
}
