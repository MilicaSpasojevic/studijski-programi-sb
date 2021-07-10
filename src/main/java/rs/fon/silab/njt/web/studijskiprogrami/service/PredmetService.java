/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.service;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PredmetDto;

/**
 *
 * @author Milica
 */
public interface PredmetService {
    PredmetDto save(PredmetDto predmetDto) throws Exception;
    List<PredmetDto> getAll() throws Exception;
    PredmetDto update(PredmetDto predmetDto) throws Exception;
    void delete(Long id) throws Exception;
    PredmetDto findById(Long id) throws Exception;
    List<PredmetDto> findByESPBandTip(Long espb,Long tipPredmetaId) throws Exception;
}
