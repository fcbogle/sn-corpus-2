package org.fcbogle.spring.service;

import org.fcbogle.spring.mongo.domain.Author;
import org.fcbogle.spring.mongo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public AuthorService() {}
	
	public Author create(Author author) {
		Author a = this.authorRepository.save(author);
		return a;
	}
	
	

}
