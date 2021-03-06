/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.service;

import java.util.List;
import rs.fon.silab.njt.web.studijskiprogrami.domain.PozicijaPK;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Studijskiprogram;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PozicijaDto;

/**
 *
 * @author Milica
 */
public interface PozicijaService {
    void save(List<PozicijaDto> pozicijaDto) throws Exception;
    List<PozicijaDto> getAll() throws Exception;
    PozicijaDto getById(PozicijaPK id) throws Exception;
    List<PozicijaDto> getByStudijskiProgram(Long spid) throws Exception;

    public List<PozicijaDto> getByStudijskiProgramAndGodina(Long spid, Long godina) throws Exception;
}
