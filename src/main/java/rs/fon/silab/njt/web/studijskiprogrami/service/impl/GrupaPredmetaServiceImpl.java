/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Grupapredmeta;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Predmet;
import rs.fon.silab.njt.web.studijskiprogrami.dto.GrupaPredmetaDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.impl.GrupaPredmetaMapper;
import rs.fon.silab.njt.web.studijskiprogrami.repository.GrupaPredmetaRepository;
import rs.fon.silab.njt.web.studijskiprogrami.service.GrupaPredmetaService;

/**
 *
 * @author Milica
 */
@Service
public class GrupaPredmetaServiceImpl implements GrupaPredmetaService{

    private final GrupaPredmetaRepository gpRep;
    private final GrupaPredmetaMapper gpMapper;

    @Autowired
    public GrupaPredmetaServiceImpl(GrupaPredmetaRepository gpRep, GrupaPredmetaMapper gpMapper) {
        this.gpRep = gpRep;
        this.gpMapper = gpMapper;
    }
    
    
    @Override
    public Grupapredmeta findById(Long id) throws Exception {
        return gpRep.getById(id);
    }

    @Override
    public List<GrupaPredmetaDto> getAll() throws Exception {
        
        List<Grupapredmeta> predmeti = gpRep.findAll();
        return predmeti.stream().map(predmet -> {
            return gpMapper.toDto(predmet);
        }).collect(Collectors.toList());
    }
    
}
