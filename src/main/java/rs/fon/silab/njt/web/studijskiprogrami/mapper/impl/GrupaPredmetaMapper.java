/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.mapper.impl;


import org.springframework.stereotype.Component;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Entity;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Grupapredmeta;
import rs.fon.silab.njt.web.studijskiprogrami.dto.GrupaPredmetaDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.EntityDtoMapper;

/**
 *
 * @author Milica
 */
@Component
public class GrupaPredmetaMapper implements EntityDtoMapper<GrupaPredmetaDto, Grupapredmeta>{

    @Override
    public GrupaPredmetaDto toDto(Grupapredmeta entity) {
        return new GrupaPredmetaDto(entity.getGrupaId(), entity.getNaziv());
    }

    @Override
    public Grupapredmeta toEntity(GrupaPredmetaDto dto) {
        return new Grupapredmeta(dto.getGrupaId(), dto.getNaziv());
    }
    
}
