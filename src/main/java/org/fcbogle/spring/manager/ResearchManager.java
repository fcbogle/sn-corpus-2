package org.fcbogle.spring.manager;

import java.util.List;

import org.fcbogle.spring.mongo.domain.ResearchItem;

public interface ResearchManager {
	
	public List<ResearchItem> getAllResearchItems();
	public List<ResearchItem> getAllMongoResearchItems();
	public ResearchItem getSingleItem(String id);
	public ResearchItem findUniqueItem(String id);
	public ResearchItem findByUniqueMongoId(String id);


}
