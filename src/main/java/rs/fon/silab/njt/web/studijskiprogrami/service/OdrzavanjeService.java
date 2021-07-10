/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.service;

import java.util.List;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Modul;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Pozicija;
import rs.fon.silab.njt.web.studijskiprogrami.dto.ModulDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.OdrzavanjeBackDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.OdrzavanjeDto;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PredmetDto;

/**
 *
 * @author Milica
 */
public interface OdrzavanjeService {
    void save(List<OdrzavanjeDto> pozicijaDto) throws Exception;
//    List<OdrzavanjeBackDto> getAll() throws Exception;

    public List<OdrzavanjeBackDto> getByModul(Long modul) throws Exception;
    public List<OdrzavanjeBackDto> getAll(Long modulId, Long GodinaId) throws Exception;
    
    List<PredmetDto> findByPozicija(Pozicija pozicija);
}
