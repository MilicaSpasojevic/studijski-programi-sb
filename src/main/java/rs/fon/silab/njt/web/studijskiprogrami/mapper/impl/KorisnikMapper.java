/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.mapper.impl;

import org.springframework.stereotype.Component;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Entity;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Korisnik;
import rs.fon.silab.njt.web.studijskiprogrami.dto.KorisnikDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.EntityDtoMapper;

/**
 *
 * @author Milica
 */
@Component
public class KorisnikMapper implements EntityDtoMapper<KorisnikDto, Korisnik>{

    @Override
    public KorisnikDto toDto(Korisnik entity) {
        return new KorisnikDto(entity.getUsername(), entity.getPassword());
    }

    @Override
    public Korisnik toEntity(KorisnikDto dto) {
        return new Korisnik(dto.getUsername(), dto.getPassword());
    }
    
}
