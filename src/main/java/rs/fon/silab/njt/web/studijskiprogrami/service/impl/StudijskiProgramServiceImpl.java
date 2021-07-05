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
import rs.fon.silab.njt.web.studijskiprogrami.domain.Predmet;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Studijskiprogram;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PredmetDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.StudijskiProgramDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.impl.NivoStudijaMapper;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.impl.PredmetMapper;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.impl.StudijskiProgramMapper;
import rs.fon.silab.njt.web.studijskiprogrami.repository.StudijskiProgramRepository;
import rs.fon.silab.njt.web.studijskiprogrami.service.FakultetService;
import rs.fon.silab.njt.web.studijskiprogrami.service.NivoStudijaService;
import rs.fon.silab.njt.web.studijskiprogrami.service.PredmetService;
import rs.fon.silab.njt.web.studijskiprogrami.service.StudijskiProgramService;
import rs.fon.silab.njt.web.studijskiprogrami.service.TipPredmetaService;

/**
 *
 * @author milos
 */
@Service
@Transactional
public class StudijskiProgramServiceImpl implements StudijskiProgramService{

    private final StudijskiProgramRepository spRepository;
    private final StudijskiProgramMapper spMapper;

    private final FakultetService fakultetService;
    private final NivoStudijaService nsService;
    private final NivoStudijaMapper nivoStudijaMapper;
    
    @Autowired
    public StudijskiProgramServiceImpl(StudijskiProgramRepository spRepository ,StudijskiProgramMapper predmetMapper, FakultetService fakultetService, NivoStudijaService nsService, NivoStudijaMapper nivoStudijaMapper) {
        this.spRepository = spRepository;
        this.spMapper = predmetMapper;
        this.nsService = nsService;
        this.fakultetService = fakultetService;
        this.nivoStudijaMapper = nivoStudijaMapper;
    }


    @Override
    public StudijskiProgramDto save(StudijskiProgramDto spDto) throws Exception {
        
        Studijskiprogram studijskiprogram = new Studijskiprogram();
        studijskiprogram.setBrojSemestara(spDto.getBrojSemestara());
        studijskiprogram.setFakultetid(fakultetService.findById(spDto.getFakultetid()));
        studijskiprogram.setNivostudijaid(nivoStudijaMapper.toEntity(nsService.findById(spDto.getNivostudijaid())));
        studijskiprogram.setNaziv(spDto.getNaziv());
        studijskiprogram.setStatus(spDto.getStatus());
        
        
        spRepository.save(studijskiprogram);
        return spMapper.toDto(studijskiprogram);
        
    }

    @Override
    public List<StudijskiProgramDto> getAll() throws Exception {
       
        
        List<Studijskiprogram> sp = spRepository.findAll();
        System.out.println(sp);
        return sp.stream().map(predmet -> {
            return spMapper.toDto(predmet);
        }).collect(Collectors.toList());
    }

    @Override
    public StudijskiProgramDto update(StudijskiProgramDto spDto) throws Exception {
        Studijskiprogram sp = new Studijskiprogram(spDto.getStudijskiProgramId(), spDto.getNaziv(), spDto.getBrojSemestara(), spDto.getStatus());
        
        spRepository.save(sp);
        return spMapper.toDto(sp);
    }

    @Override
    public void delete(Long id) throws Exception {
        Studijskiprogram sp = spRepository.getById(id);
        spRepository.delete(sp);
    }

    @Override
    public StudijskiProgramDto findById(Long id) throws Exception {
       Studijskiprogram studijskiprogram = spRepository.getById(id);
       return spMapper.toDto(studijskiprogram);
    }
    
    
    
    
}
