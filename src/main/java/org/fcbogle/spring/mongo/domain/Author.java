package org.fcbogle.spring.mongo.domain;

import java.util.List;


import org.fcbogle.spring.jpa.domain.ResearchItem;
import org.springframework.context.annotation.Profile;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Profile("MONGO")
@Document
public class Author {
	
	@Id
	private String author_id;
	
	private ResearchItem researchItem;
	
	private String name;
	
	@DBRef
	private List<String> ids;
	
	public Author() {}

	public String getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}

	public ResearchItem getResearchItem() {
		return researchItem;
	}

	public void setResearchItem(ResearchItem researchItem) {
		this.researchItem = researchItem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	
	
	
	

}
