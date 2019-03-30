package org.fcbogle.spring.manager;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.fcbogle.spring.mongo.domain.ResearchItem;

public class ResearchPredicate {
	
	public static Predicate<ResearchItem> matchesId(String id) {
		return p -> p.getId().equals(id);
	}
	
	public static Predicate<ResearchItem> containsPattern(String abs) {
		return p -> p.getPaperAbstract().contains(abs);
	}
	
	public static Predicate<ResearchItem> containsAuthorString(String author) {
		return p -> p.getAuthors().stream()
				.anyMatch(a -> a.getName().contains(author));
	}
	
	public static ResearchItem filterResearchItems(List<ResearchItem> researchItems, Predicate<ResearchItem> predicate) {
		return researchItems.stream()
				.filter(predicate)
				.findAny()
				.get();
	}
	
	public static List<ResearchItem> wordsContainedInAuthors(List<ResearchItem> researchItems, Predicate<ResearchItem> predicate) {
		return researchItems.stream()
				.filter(predicate)
				.collect(Collectors.<ResearchItem>toList());
	}
	
	public static List<ResearchItem> wordsContainedInAbstract(List<ResearchItem> researchItems, Predicate<ResearchItem> predicate) {
		return researchItems.stream()
				.filter(predicate)
				.collect(Collectors.<ResearchItem>toList());
	}

}
