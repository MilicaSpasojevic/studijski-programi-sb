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
        
        return new PozicijaDto(entity.getPozicijaPK().getPozicijaId(), entity.getPozicijaPK().getGodina(), entity.getEspb(), entity.getStudijskiprogram(), entity.getTipPredmetaId(), entity.getGrupaPredmetaId());

    }

    @Override
    public Pozicija toEntity(PozicijaDto dto) {
        return new Pozicija(new PozicijaPK(dto.getPozicijaId(), dto.getGodina(), dto.getStudijskiProgram().getStudijskiProgramId()), 
                dto.getEspb(), dto.getGrupaPredmeta(), dto.getStudijskiProgram(), dto.getTipPredmeta());
    }
    
}
