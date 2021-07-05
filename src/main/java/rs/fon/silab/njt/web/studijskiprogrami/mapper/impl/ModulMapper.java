/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.mapper.impl;

import org.springframework.stereotype.Component;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Modul;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Studijskiprogram;
import rs.fon.silab.njt.web.studijskiprogrami.dto.ModulDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.StudijskiProgramDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.EntityDtoMapper;

/**
 *
 * @author milos
 */
@Component
public class ModulMapper implements EntityDtoMapper<ModulDto, Modul>{

    @Override
    public ModulDto toDto(Modul entity) {
        return new ModulDto(entity.getModulId(), entity.getPocetak(), entity.getKraj(), entity.getNaziv(), entity.getStudijskiProgramId().getStudijskiProgramId());
    }

    @Override
    public Modul toEntity(ModulDto dto) {
        return new Modul(dto.getModulId(), dto.getNaziv(), dto.getPocetak(), dto.getKraj());
    }
    
}
