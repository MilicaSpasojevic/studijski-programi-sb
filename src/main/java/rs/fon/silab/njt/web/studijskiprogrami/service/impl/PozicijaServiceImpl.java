/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Pozicija;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PozicijaDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.impl.PozicijaMapper;
import rs.fon.silab.njt.web.studijskiprogrami.repository.PozicijaRepository;
import rs.fon.silab.njt.web.studijskiprogrami.service.PozicijaService;

/**
 *
 * @author Milica
 */
@Service
@Transactional
public class PozicijaServiceImpl implements PozicijaService{

    private final PozicijaRepository pozicijaRepository;
    private final PozicijaMapper pozicijaMapper;

    @Autowired
    public PozicijaServiceImpl(PozicijaRepository pozicijaRepository, PozicijaMapper pozicijaMapper) {
        this.pozicijaRepository = pozicijaRepository;
        this.pozicijaMapper = pozicijaMapper;
    }

    
    
    
    
    
    @Override
    public PozicijaDto save(PozicijaDto pozicijaDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PozicijaDto> getAll() throws Exception {
         List<Pozicija> pozicije = pozicijaRepository.findAll();
         System.out.println(pozicije);
        return pozicije.stream().map(predmet -> {
            return pozicijaMapper.toDto(predmet);
        }).collect(Collectors.toList());
    }
    
}
