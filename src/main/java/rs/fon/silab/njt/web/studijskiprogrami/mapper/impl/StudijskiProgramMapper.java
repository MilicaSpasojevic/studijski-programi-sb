/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.mapper.impl;

import org.springframework.stereotype.Component;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Studijskiprogram;
import rs.fon.silab.njt.web.studijskiprogrami.dto.StudijskiProgramDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.EntityDtoMapper;

/**
 *
 * @author milos
 */
@Component
public class StudijskiProgramMapper implements EntityDtoMapper<StudijskiProgramDto, Studijskiprogram>{

    @Override
    public StudijskiProgramDto toDto(Studijskiprogram entity) {
        return new StudijskiProgramDto(entity.getStudijskiProgramId(), entity.getBrojSemestara(), entity.getNaziv(), entity.getStatus(), entity.getFakultetid().getFakultetId(), entity.getNivostudijaid().getNivoStudijaId());
    }

    @Override
    public Studijskiprogram toEntity(StudijskiProgramDto dto) {
        return new Studijskiprogram(dto.getStudijskiProgramId(), dto.getNaziv(), dto.getBrojSemestara(), dto.getStatus());
    }
    
}
