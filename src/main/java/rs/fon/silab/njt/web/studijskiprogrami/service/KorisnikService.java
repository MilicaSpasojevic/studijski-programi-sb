/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.service;

import rs.fon.silab.njt.web.studijskiprogrami.dto.KorisnikDto;

/**
 *
 * @author Milica
 */
public interface KorisnikService {
    KorisnikDto findById(String id) throws Exception;
}
