/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Korisnik;
import rs.fon.silab.njt.web.studijskiprogrami.dto.KorisnikDto;
import rs.fon.silab.njt.web.studijskiprogrami.mapper.impl.KorisnikMapper;
import rs.fon.silab.njt.web.studijskiprogrami.repository.KorisnikRepository;
import rs.fon.silab.njt.web.studijskiprogrami.service.KorisnikService;

/**
 *
 * @author Milica
 */
@Service
public class KorisnikServiceImpl implements KorisnikService{

    private final KorisnikRepository korisnikRep;
    private final KorisnikMapper korisnikMapper;

    @Autowired
    public KorisnikServiceImpl(KorisnikRepository korisnikRep, KorisnikMapper korisnikMapper) {
        this.korisnikRep = korisnikRep;
        this.korisnikMapper = korisnikMapper;
    }
    
    
    
    @Override
    public KorisnikDto findById(String id) throws Exception {
        Korisnik korisnik = korisnikRep.getById(id);
        return korisnikMapper.toDto(korisnik);
    }
    
}
