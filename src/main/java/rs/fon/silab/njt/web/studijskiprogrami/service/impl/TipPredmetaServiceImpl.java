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
import rs.fon.silab.njt.web.studijskiprogrami.domain.Predmet;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Tippredmeta;
import rs.fon.silab.njt.web.studijskiprogrami.dto.TipPredmetaDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.impl.TipPredmetaMapper;
import rs.fon.silab.njt.web.studijskiprogrami.repository.TipPredmetaRepository;
import rs.fon.silab.njt.web.studijskiprogrami.service.TipPredmetaService;

/**
 *
 * @author Milica
 */
@Service
public class TipPredmetaServiceImpl implements TipPredmetaService{

    private final TipPredmetaRepository tpRepository;
    private final TipPredmetaMapper tpMapper;

    @Autowired
    public TipPredmetaServiceImpl(TipPredmetaRepository tpRepository, TipPredmetaMapper tpMapper) {
        this.tpRepository = tpRepository;
        this.tpMapper = tpMapper;
    }
    
    
    
    
    @Override
    public List<TipPredmetaDto> getAll() throws Exception {
        
        List<Tippredmeta> tipovi = tpRepository.findAll();
        return tipovi.stream().map(predmet -> {
            return tpMapper.toDto(predmet);
        }).collect(Collectors.toList());
    }

    @Override
    public Tippredmeta findById(Long id) throws Exception {
        return tpRepository.getById(id);
    }
    
    
    
}
