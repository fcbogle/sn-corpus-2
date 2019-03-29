package org.fcbogle.spring.mongo.repository;

import org.fcbogle.spring.mongo.domain.ResearchItem;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Profile("MONGO")
@Repository
public interface ResearchItemRepository extends MongoRepository<ResearchItem, String> {
	
}
