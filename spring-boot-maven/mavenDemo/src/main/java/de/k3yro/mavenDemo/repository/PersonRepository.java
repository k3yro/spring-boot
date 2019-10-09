package de.k3yro.mavenDemo.repository;

import de.k3yro.mavenDemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Modifying
    @Query("UPDATE Person p SET p.vorname = ?2, p.nachname = ?3, p.geburtsdatum = ?4 WHERE p.id = ?1")
    Integer updatePerson(Integer id, String vorname, String nachname, Date geburtsdatum);

    @Modifying
    @Query("UPDATE Person p SET p.deleted = true WHERE p.id = ?1")
    Integer deletePerson(Integer id);

    @Query(
            value = "SELECT * FROM person WHERE deleted is not true",
            nativeQuery = true
    )
    List<Person> selectPersons();
}
