/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.service;

import java.util.List;
import rs.fon.silab.njt.web.studijskiprogrami.dto.NivoStudijaDto;

/**
 *
 * @author milos
 */
public interface NivoStudijaService {
     List<NivoStudijaDto> getAll() throws Exception;
     NivoStudijaDto findById(Long id) throws Exception;
}
