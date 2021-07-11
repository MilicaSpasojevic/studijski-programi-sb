/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.service;

import java.util.List;
import rs.fon.silab.njt.web.studijskiprogrami.dto.ModulDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.StudijskiProgramDto;

/**
 *
 * @author milos
 */
public interface ModulService {

    ModulDto save(ModulDto modulDto) throws Exception;

    List<ModulDto> getAll() throws Exception;

    ModulDto update(ModulDto modulDto) throws Exception;

    void delete(Long id) throws Exception;

    ModulDto findById(Long id) throws Exception;

    List<ModulDto> findByStatus(int status) throws Exception;

    public void publish(Long id) throws Exception;

}
