/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.mapper.impl;

import rs.fon.silab.njt.web.studijskiprogrami.domain.Entity;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Grupapredmeta;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Odrzavanje;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Pozicija;
import rs.fon.silab.njt.web.studijskiprogrami.domain.PozicijaPK;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Studijskiprogram;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Tippredmeta;
import rs.fon.silab.njt.web.studijskiprogrami.dto.OdrzavanjeDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PozicijaDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.EntityDtoMapper;

/**
 *
 * @author Milica
 */
public class OdrzavanjeMapper implements EntityDtoMapper<OdrzavanjeDto, Odrzavanje>{

    @Override
    public OdrzavanjeDto toDto(Odrzavanje entity) {
        return null;
    }

    @Override
    public Odrzavanje toEntity(OdrzavanjeDto dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
