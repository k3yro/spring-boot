package de.k3yro.mavenDemo.repository;

import de.k3yro.mavenDemo.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonPagingRepository extends PagingAndSortingRepository<Person, Integer> {
}
