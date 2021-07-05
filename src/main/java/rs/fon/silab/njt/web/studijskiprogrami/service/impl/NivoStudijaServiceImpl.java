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
import rs.fon.silab.njt.web.studijskiprogrami.domain.Fakultet;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Nivostudija;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Tippredmeta;
import rs.fon.silab.njt.web.studijskiprogrami.dto.NivoStudijaDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.impl.NivoStudijaMapper;
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
    private final NivoStudijaMapper nivoStudijaMapper;
    
    @Autowired
    public NivoStudijaServiceImpl(NivoStudijaRepository nsRepository, NivoStudijaMapper nivoStudijaMapper) {
        this.nsRepository = nsRepository;
        this.nivoStudijaMapper = nivoStudijaMapper;
    }
    
    @Override
    public List<NivoStudijaDto> getAll() throws Exception {
       
        
        List<Nivostudija> nivoi = nsRepository.findAll();
        System.out.println(nivoi);
        return nivoi.stream().map(nivo -> {
            return nivoStudijaMapper.toDto(nivo);
        }).collect(Collectors.toList());
    }

    @Override
    public NivoStudijaDto findById(Long id) throws Exception {
        return nivoStudijaMapper.toDto(nsRepository.getById(id));
    }
    
    
    
}
