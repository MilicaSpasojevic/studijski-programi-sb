/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.service;

import java.util.List;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Tippredmeta;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PozicijaDto;

/**
 *
 * @author Milica
 */
public interface TipPredmetaService {
     List<Tippredmeta> getAll() throws Exception;
     Tippredmeta findById(Long id) throws Exception;
}
