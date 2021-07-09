/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Odrzavanje;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Pozicija;
import rs.fon.silab.njt.web.studijskiprogrami.domain.PozicijaPK;
import rs.fon.silab.njt.web.studijskiprogrami.dto.OdrzavanjeBackDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.OdrzavanjeDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PredmetDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.impl.ModulMapper;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.impl.PozicijaMapper;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.impl.PredmetMapper;
import rs.fon.silab.njt.web.studijskiprogrami.repository.GrupaPredmetaRepository;
import rs.fon.silab.njt.web.studijskiprogrami.repository.ModulRepository;
import rs.fon.silab.njt.web.studijskiprogrami.repository.OdrzavanjeRepository;
import rs.fon.silab.njt.web.studijskiprogrami.repository.PozicijaRepository;
import rs.fon.silab.njt.web.studijskiprogrami.repository.PredmetRepository;
import rs.fon.silab.njt.web.studijskiprogrami.service.OdrzavanjeService;
import rs.fon.silab.njt.web.studijskiprogrami.validator.Validator;

/**
 *
 * @author Milica
 */
@Service
public class OdrzavanjeServiceImpl implements OdrzavanjeService {

    private final OdrzavanjeRepository odrzavanjeRep;
    private final PozicijaServiceImpl pozicijaServ;
    private final PredmetServiceImpl predmetServ;
    private final GrupaPredmetaServiceImpl grupaServ;
    private final ModulServiceImpl modulServ;
    private final PozicijaMapper pozicijaMapper;
    private final ModulMapper modulMapper;
    private final PredmetMapper predmetMapper;

    @Autowired
    public OdrzavanjeServiceImpl(OdrzavanjeRepository odrzavanjeRep, PozicijaServiceImpl pozicijaServ,
            PredmetServiceImpl predmetServ, GrupaPredmetaServiceImpl grupaServ, ModulServiceImpl modulServ,
            PozicijaMapper pozicijaMapper, ModulMapper modulMapper, PredmetMapper predmetMapper) {
        this.odrzavanjeRep = odrzavanjeRep;
        this.pozicijaServ = pozicijaServ;
        this.predmetServ = predmetServ;
        this.grupaServ = grupaServ;
        this.modulServ = modulServ;
        this.pozicijaMapper = pozicijaMapper;
        this.modulMapper = modulMapper;
        this.predmetMapper = predmetMapper;
    }

    @Override
    @Transactional
    public void save(List<OdrzavanjeDto> odrzavanjeDto) throws Exception {
        //Prebaciti u validaciju
        for (OdrzavanjeDto odrz : odrzavanjeDto) {
            Validator.validirajOdrzavanja(odrz, odrzavanjeDto, pozicijaMapper, pozicijaServ);
            for (PredmetDto pred : odrz.getPredmetDto()) {
                Odrzavanje o = new Odrzavanje();
                o.setGrupaId(grupaServ.findById(odrz.getPozicijaDto().getGrupaPredmetaId()));
                o.setModul(modulMapper.toEntity(modulServ.findById(odrz.getModulId())));
                System.out.println("MODUL ENT " + o.getModul());
                o.setSemestar(odrz.getSemestar());
                o.setPredmet(predmetMapper.toEntity(predmetServ.findById(pred.getPredmetid())));
                odrzavanjeRep.save(o);
            }

        }

    }

    @Override
    public List<OdrzavanjeBackDto> getAll(Long modulId) throws Exception {
        List<Odrzavanje> odrzavanja = odrzavanjeRep.findAll();
        List<OdrzavanjeBackDto> odrzBack = new ArrayList<>();
        for (Odrzavanje o : odrzavanja) {
            if (o.getModul().getModulId() == modulId) {
                OdrzavanjeBackDto odr = new OdrzavanjeBackDto();
                odr.setPredmet(predmetMapper.toDto(o.getPredmet()));
                odr.setPozicija(pozicijaMapper.toDto(o.getPozicija()));
                odrzBack.add(odr);
            }

        }
        return odrzBack;

    }

}
