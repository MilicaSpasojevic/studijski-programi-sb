/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.mapper.impl;

import org.springframework.stereotype.Component;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Entity;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Tippredmeta;
import rs.fon.silab.njt.web.studijskiprogrami.dto.TipPredmetaDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.EntityDtoMapper;

/**
 *
 * @author Milica
 */
@Component
public class TipPredmetaMapper implements EntityDtoMapper<TipPredmetaDto, Tippredmeta>{

    @Override
    public TipPredmetaDto toDto(Tippredmeta entity) {
        return new TipPredmetaDto(entity.getTipPredmetaID(), entity.getNaziv());
    }

    @Override
    public Tippredmeta toEntity(TipPredmetaDto dto) {
        return new Tippredmeta(dto.getId(), dto.getNaziv());
    }
    
}
