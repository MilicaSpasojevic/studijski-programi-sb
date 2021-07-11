/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Pozicija;
import rs.fon.silab.njt.web.studijskiprogrami.domain.PozicijaPK;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Studijskiprogram;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PozicijaDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.impl.PozicijaMapper;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.impl.StudijskiProgramMapper;
import rs.fon.silab.njt.web.studijskiprogrami.repository.PozicijaRepository;
import rs.fon.silab.njt.web.studijskiprogrami.service.GrupaPredmetaService;
import rs.fon.silab.njt.web.studijskiprogrami.service.PozicijaService;
import rs.fon.silab.njt.web.studijskiprogrami.service.StudijskiProgramService;
import rs.fon.silab.njt.web.studijskiprogrami.service.TipPredmetaService;
import rs.fon.silab.njt.web.studijskiprogrami.validator.Validator;

/**
 *
 * @author Milica
 */
@Service
@Transactional
public class PozicijaServiceImpl implements PozicijaService {

    private final PozicijaRepository pozicijaRepository;
    private final PozicijaMapper pozicijaMapper;
    private final GrupaPredmetaService grupaService;
    private final TipPredmetaService tipService;
    private final StudijskiProgramService spService;
    private final StudijskiProgramMapper spMapper;

    @Autowired
    public PozicijaServiceImpl(PozicijaRepository pozicijaRepository, PozicijaMapper pozicijaMapper, GrupaPredmetaService grupaService,
            TipPredmetaService tipService, StudijskiProgramService spService, StudijskiProgramMapper spMapper) {
        this.pozicijaRepository = pozicijaRepository;
        this.pozicijaMapper = pozicijaMapper;
        this.grupaService = grupaService;
        this.tipService = tipService;
        this.spService = spService;
        this.spMapper = spMapper;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    @Override
    public void save(List<PozicijaDto> pozicijaDto) throws Exception {
//        Validator.validirajPozicije(pozicijaDto);
        List<Pozicija> pozicije = new ArrayList<>();
        for (PozicijaDto poz : pozicijaDto) {
            Pozicija p = new Pozicija();
            p.setEspb(poz.getEspb());
            p.setGrupaPredmetaId(grupaService.findById(poz.getGrupaPredmetaId()));
            p.setStudijskiprogram(spMapper.toEntity(spService.findById(poz.getStudijskiProgramId())));
            p.setTipPredmetaId(tipService.findById(poz.getTipPredmetaId()));
            p.setPozicijaPK(new PozicijaPK(poz.getPozicijaId(), poz.getGodina(), poz.getStudijskiProgramId()));
            pozicijaRepository.save(p);
            //pozicije.add(p);
        }
        // pozicijaRepository.saveAll(pozicije);
    }

    @Override
    public List<PozicijaDto> getAll() throws Exception {
        List<Pozicija> pozicije = pozicijaRepository.findAll();
        System.out.println(pozicije);
        return pozicije.stream().map(predmet -> {
            return pozicijaMapper.toDto(predmet);
        }).collect(Collectors.toList());
    }

    @Override
    public PozicijaDto getById(PozicijaPK id) throws Exception {
        return pozicijaMapper.toDto(pozicijaRepository.getById(id));
    }

    @Override
    public List<PozicijaDto> getByStudijskiProgram(Long spid) throws Exception {
        Studijskiprogram studijskiprogram = spMapper.toEntity(spService.findById(spid));
        List<Pozicija> pozicije = pozicijaRepository.findByStudijskiprogram(studijskiprogram);
        System.out.println(pozicije);
        return pozicije.stream().map(pozicija -> {
            return pozicijaMapper.toDto(pozicija);
        }).collect(Collectors.toList());
    }

}
