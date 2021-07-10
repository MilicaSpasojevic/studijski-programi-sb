/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Modul;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Odrzavanje;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Pozicija;

/**
 *
 * @author Milica
 */
@Repository
public interface OdrzavanjeRepository extends JpaRepository<Odrzavanje, Long>{
    List<Odrzavanje> findByModul(Modul modul);
    List<Odrzavanje> findByPozicija(Pozicija pozicija);
}
