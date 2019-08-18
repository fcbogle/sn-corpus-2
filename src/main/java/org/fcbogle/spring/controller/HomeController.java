package org.fcbogle.spring.controller;

import java.util.List;

import org.fcbogle.spring.mongo.domain.ResearchItem;
import org.fcbogle.spring.mongo.domain.SearchAbstract;
import org.fcbogle.spring.mongo.domain.SearchAuthor;
import org.fcbogle.spring.service.ResearchItemService;
import org.fcbogle.spring.manager.ResearchManager;
import org.fcbogle.spring.manager.ResearchPredicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ResearchManager researchManager;

	@GetMapping("/")
	public String home(Model model) {
		logger.info("Returning home page");
		SearchAuthor searchAuthor = new SearchAuthor();
		SearchAbstract searchAbstract = new SearchAbstract();
		model.addAttribute("searchAuthor", searchAuthor);
		model.addAttribute("searchAbstract", searchAbstract);
		return "homepage";
	}

	@GetMapping("/research")
	public String showAllItems(Model model) {
		logger.info("HomeController showAllItems() operation invoked");
		List<ResearchItem> allItems = this.researchManager.getAllResearchItems();
		// List<ResearchItem> allItems =
		// this.researchManager.getAllMongoResearchItems();
		SearchAuthor searchAuthor = new SearchAuthor();
		SearchAbstract searchAbstract = new SearchAbstract();
		model.addAttribute("searchAuthor", searchAuthor);
		model.addAttribute("searchAbstract", searchAbstract);
		model.addAttribute("allItems", allItems);
		return "all-items";
	}

	@GetMapping("/research/{id:.*}/show")
	public String showIndividualItem(@PathVariable("id") String id, Model model) {
		// ResearchItem single = this.researchManager.getSingleItem(id);
		ResearchItem single = this.researchManager.findUniqueItem(id);
		// ResearchItem single = this.researchManager.findByUniqueMongoId(id);
		SearchAuthor searchAuthor = new SearchAuthor();
		SearchAbstract searchAbstract = new SearchAbstract();
		model.addAttribute("searchAuthor", searchAuthor);
		model.addAttribute("searchAbstract", searchAbstract);
		model.addAttribute("single", single);
		logger.info("HomeController showIndividualItem() operation invoked: " + " item id: " + single.getId());
		return "single-item";
	}

	@PostMapping("/research/search/author")
	public String searchForAuthorString(@ModelAttribute SearchAuthor searchAuthor, Model model) {
		logger.info("HomeController searchForAuthorString() operation invoked: " + searchAuthor.getAuthorSearch());
		List<ResearchItem> allItems = this.researchManager.getAllResearchItems();
		List<ResearchItem> foundItems =
		ResearchPredicate.wordsContainedInAuthors(allItems,
		ResearchPredicate.containsAuthorString(searchAuthor.getAuthorSearch()));
		model.addAttribute("foundItems", foundItems);
		model.addAttribute("searchAuthor", searchAuthor);
		return "search-items";
	}

	@PostMapping("/research/search/abstract")
	public String searchForAbstractString(@ModelAttribute SearchAbstract searchAbstract, Model model) {
		logger.info("HomeController searchForAbstractString() operation invoked: " + searchAbstract.getAbstractSearch());
		List<ResearchItem> allItems = this.researchManager.getAllResearchItems();
		List<ResearchItem> foundItems = ResearchPredicate.wordsContainedInAbstract(allItems,
				ResearchPredicate.containsAbstractString(searchAbstract.getAbstractSearch()));
		model.addAttribute("foundItems", foundItems);
		return "search-items";
	}

}
