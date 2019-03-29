package org.fcbogle.spring.jpa.repository;

import org.fcbogle.spring.jpa.domain.ResearchItem;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Profile("JPA")
@Repository
public interface AuthorRepository extends JpaRepository<ResearchItem, Long>  {

}
