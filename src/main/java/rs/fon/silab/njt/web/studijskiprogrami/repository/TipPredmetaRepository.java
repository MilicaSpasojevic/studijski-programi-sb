/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Tippredmeta;

/**
 *
 * @author Milica
 */
@Repository
public interface TipPredmetaRepository extends JpaRepository<Tippredmeta, Long>{
    
}
