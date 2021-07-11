/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Modul;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Odrzavanje;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Predmet;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Studijskiprogram;
import rs.fon.silab.njt.web.studijskiprogrami.dto.ModulDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.OdrzavanjeBackDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PozicijaDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PredmetDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.StudijskiProgramDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.impl.ModulMapper;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.impl.PredmetMapper;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.impl.StudijskiProgramMapper;
import rs.fon.silab.njt.web.studijskiprogrami.repository.ModulRepository;
import rs.fon.silab.njt.web.studijskiprogrami.repository.StudijskiProgramRepository;
import rs.fon.silab.njt.web.studijskiprogrami.service.FakultetService;
import rs.fon.silab.njt.web.studijskiprogrami.service.ModulService;
import rs.fon.silab.njt.web.studijskiprogrami.service.NivoStudijaService;
import rs.fon.silab.njt.web.studijskiprogrami.service.OdrzavanjeService;
import rs.fon.silab.njt.web.studijskiprogrami.service.PozicijaService;
import rs.fon.silab.njt.web.studijskiprogrami.service.PredmetService;
import rs.fon.silab.njt.web.studijskiprogrami.service.StudijskiProgramService;
import rs.fon.silab.njt.web.studijskiprogrami.service.TipPredmetaService;
import rs.fon.silab.njt.web.studijskiprogrami.validator.Validator;

/**
 *
 * @author milos
 */
@Service
@Transactional
public class ModulServiceImpl implements ModulService {

    private final ModulRepository modulRepository;
    private final ModulMapper modulMapper;

    private final StudijskiProgramService spService;
    private final OdrzavanjeService odrzavanjeService;

    @Autowired
    public ModulServiceImpl(ModulRepository modulRepository, ModulMapper modulMapper, StudijskiProgramService spService, OdrzavanjeService odrzavanjeService) {
        this.modulRepository = modulRepository;
        this.modulMapper = modulMapper;
        this.spService = spService;
        this.odrzavanjeService = odrzavanjeService;
    }

    @Override
    public ModulDto save(ModulDto modulDto) throws Exception {

        Modul modul = new Modul();
        modul.setKraj(modulDto.getKraj());
        modul.setPocetak(modulDto.getPocetak());
        modul.setNaziv(modulDto.getNaziv());
        modul.setStudijskiProgramId(new StudijskiProgramMapper().toEntity(spService.findById(modulDto.getStudijskiProgramId())));

        modulRepository.save(modul);
        return modulMapper.toDto(modul);

    }

    @Override
    public List<ModulDto> getAll() throws Exception {

        List<Modul> modul = modulRepository.findAll();
        System.out.println(modul);
        return modul.stream().map(predmet -> {
            return modulMapper.toDto(predmet);
        }).collect(Collectors.toList());
    }

    @Override
    public ModulDto update(ModulDto modulDto) throws Exception {
        Modul modul = new Modul(modulDto.getModulId(), modulDto.getNaziv(), modulDto.getPocetak(), modulDto.getKraj(), modulDto.getStatus());

        modulRepository.save(modul);
        return modulMapper.toDto(modul);
    }

    @Override
    public void delete(Long id) throws Exception {
        Modul sp = modulRepository.getById(id);
        modulRepository.delete(sp);
    }

    @Override
    public ModulDto findById(Long id) throws Exception {
        Modul modul = modulRepository.getById(id);
        return modulMapper.toDto(modul);
    }

    @Override
    public List<ModulDto> findByStatus(int status) throws Exception {
        List<Modul> moduli = modulRepository.getByStatus(status);
        List<ModulDto> moduliDtos = new ArrayList<>();
        for (Modul m : moduli) {
            moduliDtos.add(modulMapper.toDto(m));
        }
        return moduliDtos;
    }

    @Override
    public void publish(Long id) throws Exception {
        Modul modul = modulRepository.getById(id);

        for (int i = 1; i <= modul.getStudijskiProgramId().getBrojSemestara() / 2; i++) {
            List<OdrzavanjeBackDto> odrzavanja = odrzavanjeService.getAll(id, Long.parseLong("" + i));
            for (OdrzavanjeBackDto odrzavanjeBackDto : odrzavanja) {
                if (odrzavanjeBackDto.getPredmeti().isEmpty()) {
                    throw new Exception("Postoji pozicija za koju nije uneseno odrzavanje. Greska");
                }
            }
        }
        modulRepository.publish(id);
    }

}
