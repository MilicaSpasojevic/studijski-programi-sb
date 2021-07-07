/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.service;

import java.util.List;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Tippredmeta;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PozicijaDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.TipPredmetaDto;

/**
 *
 * @author Milica
 */
public interface TipPredmetaService {
     List<TipPredmetaDto> getAll() throws Exception;
     Tippredmeta findById(Long id) throws Exception;
}
