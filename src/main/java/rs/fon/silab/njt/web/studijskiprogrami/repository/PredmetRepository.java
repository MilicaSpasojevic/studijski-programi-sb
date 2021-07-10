/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.repository;

/**
 *
 * @author Milica
 */


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Predmet;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Tippredmeta;
import rs.fon.silab.njt.web.studijskiprogrami.dto.PredmetDto;


@Repository
public interface PredmetRepository extends JpaRepository<Predmet, Long>{
    
    @Query(value = "SELECT p FROM Predmet p WHERE p.espb =?1 AND p.tipPredmetaId=?2")
    List<Predmet> findByESPBandTip(Long espb, Tippredmeta tipPredmetaId);
}
