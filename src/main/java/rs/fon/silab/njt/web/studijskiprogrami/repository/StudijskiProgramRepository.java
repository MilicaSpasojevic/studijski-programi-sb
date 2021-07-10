/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.web.studijskiprogrami.repository;

/**
 *
 * @author milos
 */
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.fon.silab.njt.web.studijskiprogrami.domain.Studijskiprogram;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface StudijskiProgramRepository extends JpaRepository<Studijskiprogram, Long> {

    List<Studijskiprogram> getByStatus(int status);

    @Query("UPDATE Studijskiprogram s SET s.status=1 WHERE s.studijskiProgramId=?1")
    void publish(Long id);
}
