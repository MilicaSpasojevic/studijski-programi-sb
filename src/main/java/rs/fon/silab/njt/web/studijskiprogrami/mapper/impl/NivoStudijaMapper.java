/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.mapper.impl;

import org.springframework.stereotype.Component;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Entity;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Nivostudija;
import rs.fon.silab.njt.web.studijskiprogrami.dto.NivoStudijaDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.EntityDtoMapper;

/**
 *
 * @author STEFAN PC
 */
@Component
public class NivoStudijaMapper implements EntityDtoMapper<NivoStudijaDto, Nivostudija>{

    @Override
    public NivoStudijaDto toDto(Nivostudija entity) {
         return new NivoStudijaDto(entity.getNivoStudijaId(), entity.getNaziv());
    }

    @Override
    public Nivostudija toEntity(NivoStudijaDto dto) {
        return new Nivostudija(dto.getNivoStudijaId(), dto.getNaziv());
    }
    
}
