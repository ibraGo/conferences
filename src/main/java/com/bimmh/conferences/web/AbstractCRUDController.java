package com.bimmh.conferences.web;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractCRUDController<T, ID extends Serializable> {

	@Autowired
	private JpaRepository<T, ID> repository;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute(modelId() + "s", repository.findAll());
		return "admin/" + modelId() + "s/list.html";
	}


	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute(modelId(), newInstance());
		modelAttributes(model);
		return "admin/" + modelId() + "s/form.html";
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public String save(T object, BindingResult bindingResult, HttpServletRequest request) {
		Validator validator = getValidator();
		validator.validate(object,bindingResult);
		if(bindingResult.hasErrors()){
			return "admin/" + modelId() + "s"+"/form.html";
		}
		repository.save(object);
		return "redirect:/admin/" + modelId() + "s";
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable(value = "id") ID id) {
		model.addAttribute(modelId(), repository.findOne(id));
		return "admin/" + modelId() + "s/form.html";
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable(value = "id") ID id) {
		repository.delete(id);
		return "redirect:/admin/" + modelId() + "s";
	}

	public void modelAttributes(Model model) {
	}

	public abstract T newInstance();

	public abstract String modelId();

	public abstract Validator getValidator();

	public abstract String getPath();
}
