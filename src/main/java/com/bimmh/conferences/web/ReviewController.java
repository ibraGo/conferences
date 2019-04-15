package com.bimmh.conferences.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bimmh.conferences.model.Review;
import com.bimmh.conferences.service.ArticleService;
import com.bimmh.conferences.service.ProfessionService;
import com.bimmh.conferences.service.ReviewService;
import com.bimmh.conferences.service.UserService;

@Controller
@RequestMapping(path = "/reviews/")
public class ReviewController {

	@Autowired
	private ProfessionService professionService;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private UserService userService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("articles", articleService.getNotReviewed());
		model.addAttribute("professions", professionService.getAll());
		return "reviews/index.html";
	}

	@RequestMapping(path = "/add/{articleId}/{value}", method = RequestMethod.GET)
	public String create(Model model, Principal principal, @PathVariable(value = "articleId") Long articleId,
			@PathVariable(value = "value") int value) {
		Review review = new Review();
		review.setArticle(articleService.getById(articleId));
		review.setValue(value == 1 ? true : false);
		review.setReviewer(userService.findByUsername(principal.getName()));

		reviewService.saveOrUpdate(review);
		return "redirect:/reviews/";
	}

}
