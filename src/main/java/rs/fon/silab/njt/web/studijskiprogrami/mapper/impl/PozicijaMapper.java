/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.mapper.impl;

import org.springframework.stereotype.Component;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Grupapredmeta;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Pozicija;
import rs.fon.silab.njt.web.studijskiprogrami.domain.PozicijaPK;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Studijskiprogram;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Tippredmeta;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PozicijaDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.EntityDtoMapper;


/**
 *
 * @author Milica
 */
@Component
public class PozicijaMapper implements EntityDtoMapper<PozicijaDto, Pozicija>{

    @Override
    public PozicijaDto toDto(Pozicija entity) {
        
        return new PozicijaDto(entity.getPozicijaPK().getPozicijaId(), entity.getPozicijaPK().getGodina(), entity.getEspb(), entity.getPozicijaPK().getStudijskiProgramId(), entity.getTipPredmetaId().getTipPredmetaID(), entity.getGrupaPredmetaId().getGrupaId());

    }

    //Treba videti zbog prebacivanja id
    @Override
    public Pozicija toEntity(PozicijaDto dto) {
        return new Pozicija(new PozicijaPK(dto.getPozicijaId(), dto.getGodina(), dto.getStudijskiProgramId()), 
                dto.getEspb(), new Grupapredmeta(dto.getGrupaPredmetaId()), new Studijskiprogram(dto.getGrupaPredmetaId()), new Tippredmeta(dto.getTipPredmetaId()));
    }
    
}
