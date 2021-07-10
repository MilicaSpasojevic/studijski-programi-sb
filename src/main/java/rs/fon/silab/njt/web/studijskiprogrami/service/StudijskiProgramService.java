/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.service;

import java.util.List;
import rs.fon.silab.njt.web.studijskiprogrami.dto.StudijskiProgramDto;

/**
 *
 * @author milos
 */
public interface StudijskiProgramService {

    StudijskiProgramDto save(StudijskiProgramDto studijskiProgramDto) throws Exception;

    List<StudijskiProgramDto> getAll() throws Exception;

    StudijskiProgramDto update(StudijskiProgramDto studijskiProgramDto) throws Exception;

    void delete(Long id) throws Exception;

    StudijskiProgramDto findById(Long id) throws Exception;

    List<StudijskiProgramDto> findByStatus(int status) throws Exception;

    public void publish(Long id);
    
}
