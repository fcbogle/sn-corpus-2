package org.fcbogle.spring.jpa.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Profile("JPA")
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "author_id")
	private Long author_id;
	
	@ManyToOne
	@JoinColumn(name = "research_item_id")
	private ResearchItem researchItem;
	
	private String name;
	
	@ElementCollection
	private List<String> ids;
	
	public Author() {}

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

	public Long getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(Long author_id) {
		this.author_id = author_id;
	}

	public ResearchItem getResearchItem() {
		return researchItem;
	}

	public void setResearchItem(ResearchItem researchItem) {
		this.researchItem = researchItem;
	}

	

}
