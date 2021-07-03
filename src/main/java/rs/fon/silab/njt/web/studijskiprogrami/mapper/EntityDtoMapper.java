/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.mapper;

import rs.fon.silab.njt.web.studijskiprogrami.domain.Entity;
import rs.fon.silab.njt.web.studijskiprogrami.dto.Dto;



/**
 *
 * @author Milica
 */
public interface EntityDtoMapper<D extends Dto, E extends Entity> {
    D toDto(E entity);
    E toEntity(D dto);
}
