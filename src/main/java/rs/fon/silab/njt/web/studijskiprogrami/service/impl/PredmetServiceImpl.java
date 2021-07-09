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
import org.springframework.web.bind.annotation.RequestParam;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Predmet;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PredmetDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.impl.PredmetMapper;
import rs.fon.silab.njt.web.studijskiprogrami.repository.PredmetRepository;
import rs.fon.silab.njt.web.studijskiprogrami.service.PredmetService;
import rs.fon.silab.njt.web.studijskiprogrami.service.TipPredmetaService;

/**
 *
 * @author Milica
 */
@Service
@Transactional
public class PredmetServiceImpl implements PredmetService {
    
    private final PredmetRepository predmetRepository;
    private final PredmetMapper predmetMapper;
    
    private final TipPredmetaService tpService;
    
    @Autowired
    public PredmetServiceImpl(PredmetRepository predmetRepository, PredmetMapper predmetMapper, TipPredmetaService tpService) {
        this.predmetRepository = predmetRepository;
        this.predmetMapper = predmetMapper;
        this.tpService = tpService;
    }
    
    @Override
    public PredmetDto save(PredmetDto predmetDto) throws Exception {
        Predmet predmet = new Predmet();
        predmet.setEspb(predmetDto.getEspb());
        predmet.setNaziv(predmetDto.getNaziv());
        predmet.setTipPredmetaId(tpService.findById(predmetDto.getTipPredmetaId()));
        
        predmetRepository.save(predmet);
        return predmetMapper.toDto(predmet);
        
    }
    
    @Override
    public List<PredmetDto> getAll() throws Exception {
        
        List<Predmet> predmeti = predmetRepository.findAll();
        System.out.println(predmeti);
        return predmeti.stream().map(predmet -> {
            return predmetMapper.toDto(predmet);
        }).collect(Collectors.toList());
    }
    
    @Override
    public PredmetDto update(PredmetDto predmetDto) throws Exception {
        Predmet predmet = new Predmet();
        predmet.setEspb(predmetDto.getEspb());
        predmet.setNaziv(predmetDto.getNaziv());
        predmet.setPredmetid(predmetDto.getPredmetid());
        predmet.setTipPredmetaId(tpService.findById(predmetDto.getTipPredmetaId()));
        
        predmetRepository.save(predmet);
        return predmetMapper.toDto(predmet);
    }
    
    @Override
    public void delete(Long id) throws Exception {
        Predmet predmet = predmetRepository.getById(id);
        predmetRepository.delete(predmet);
    }
    
    @Override
    public PredmetDto findById(Long id) throws Exception {
        return predmetMapper.toDto(predmetRepository.getById(id));
    }
    
    @Override
    public List<PredmetDto> findByESPBandTip(Long espb,Long tipPredmetaId) throws Exception {
        List<Predmet> predmeti = predmetRepository.findByESPBandTip(espb, tpService.findById(tipPredmetaId));
        System.out.println(predmeti);
        return predmeti.stream().map(predmet -> {
            return predmetMapper.toDto(predmet);
        }).collect(Collectors.toList());
    }
    
}
