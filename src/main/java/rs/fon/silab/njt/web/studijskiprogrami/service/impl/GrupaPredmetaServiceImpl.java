/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Grupapredmeta;
import rs.fon.silab.njt.web.studijskiprogrami.repository.GrupaPredmetaRepository;
import rs.fon.silab.njt.web.studijskiprogrami.service.GrupaPredmetaService;

/**
 *
 * @author Milica
 */
@Service
public class GrupaPredmetaServiceImpl implements GrupaPredmetaService{

    private final GrupaPredmetaRepository gpRep;

    @Autowired
    public GrupaPredmetaServiceImpl(GrupaPredmetaRepository gpRep) {
        this.gpRep = gpRep;
    }
    
    
    @Override
    public Grupapredmeta findById(Long id) throws Exception {
        return gpRep.getById(id);
    }
    
}
