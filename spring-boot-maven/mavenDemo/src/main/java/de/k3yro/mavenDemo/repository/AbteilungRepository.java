package de.k3yro.mavenDemo.repository;

import de.k3yro.mavenDemo.entity.Abteilung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AbteilungRepository extends JpaRepository<Abteilung, Integer> {

    @Modifying
    @Query("UPDATE Abteilung a SET a.name = ?2 WHERE a.id = ?1")
    Integer updateAbteilung(Integer id, String name);

    @Modifying
    @Query("UPDATE Abteilung a SET a.deleted = true WHERE a.id = ?1")
    Integer deleteAbteilung(Integer id);

    @Query(
            value = "SELECT * FROM abteilungen WHERE deleted is not true",
            nativeQuery = true
    )
    List<Abteilung> selectAbteilungen();
}
