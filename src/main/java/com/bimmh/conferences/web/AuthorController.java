package com.bimmh.conferences.web;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.bimmh.conferences.model.Article;
import com.bimmh.conferences.model.Conference;
import com.bimmh.conferences.model.Profession;
import com.bimmh.conferences.model.User;
import com.bimmh.conferences.service.ArticleService;
import com.bimmh.conferences.service.AuthorService;
import com.bimmh.conferences.service.ConferenceService;
import com.bimmh.conferences.service.FileUpload;
import com.bimmh.conferences.service.ProfessionService;
import com.bimmh.conferences.service.UserService;

@Controller
@Secured(value = "ROLE_AUTHOR")
public class AuthorController {

	@Autowired
	private ConferenceService conferenceService;

	@Autowired
	private ProfessionService professionService;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private UserService userService;

	@Autowired
	FileUpload fileUploadService;

	@RequestMapping(path = "/conf-submit", method = RequestMethod.POST)
	public String submitToConference(Article article, BindingResult bindingResult, HttpServletRequest request,
			Exception exp) throws IOException, ServletException {
		if (exp instanceof MaxUploadSizeExceededException) {
			return "/submit/" + article.getConference().getId();
		}
		MultipartFile file = ((DefaultMultipartHttpServletRequest) request).getMultiFileMap().getFirst("file");
		article.setFileName(uploadArticleDoc(file));

		articleService.save(article);
		return "redirect:/author";
	}

	@RequestMapping(path = "/submit/{conferenceId}")
	public String submitToConferenceView(@PathVariable(value = "conferenceId") Long id, Model model,
			Principal principal) {
		User currentUser = userService.findByUsername(principal.getName());
		Conference conference = conferenceService.getByID(id);
		List<Profession> professions = professionService.getAll();
		List<User> authors = authorService.getAll();
		authors.remove(currentUser);

		Article article = new Article();
		article.setConference(conference);
		article.setPrincipalAuthor(currentUser);
		// add current User
		model.addAttribute("article", article);
		model.addAttribute("allProfessions", professions);
		model.addAttribute("allAuthors", authors);

		return "submit.html";
	}

	public String uploadArticleDoc(MultipartFile file) {
		String log = fileUploadService.upload(file);
		if (!log.equals("failed")) {
			return log;
		}
		return null;
	}

}
