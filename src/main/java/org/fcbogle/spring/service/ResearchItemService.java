package org.fcbogle.spring.service;

import org.fcbogle.spring.jpa.domain.ResearchItem;
import org.fcbogle.spring.jpa.repository.ResearchItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResearchItemService {
	
	@Autowired
	private ResearchItemRepository researchItemRepository;
	
	public ResearchItem create(ResearchItem researchItem) {
		ResearchItem item = this.researchItemRepository.save(researchItem);
		return item;
	}
	

}
