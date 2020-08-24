package com.in28minutes.springboot.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.in28minutes.springboot.web.model.Todo;
import com.in28minutes.springboot.web.service.TodoService;

@Controller

@SessionAttributes("user")
public class TodoController {

	@Autowired
	private TodoService todoservice;

	@RequestMapping("/testing")
	public String showtest() {
		return "test";
	}

	@RequestMapping("/list")
	public String listtodos(ModelMap model) {

		String username = (String) model.get("user");
		
		System.out.println("///////list         "+username);

		if (username != null && !username.isEmpty()) {

			List<Todo> todo = todoservice.retrieveTodos(username);

			model.addAttribute("alltodos", todo);

			return "listtodos";
		} else {
			return "loginpage";

		}

	}

	/*
	 * @GetMapping("/addtodo") public String addtodopage(ModelMap model){ String
	 * username=(String) model.get("user");
	 * 
	 * if(username != null && !username.isEmpty()) {
	 * 
	 * Todo todo=new Todo();
	 * 
	 * todo.setDesc("enter your skills"); // <- this step is optional
	 * 
	 * model.addAttribute("todo", todo);
	 * 
	 * return "addtodopage";} else { return "loginpage";
	 * 
	 * }
	 * 
	 * 
	 * }
	 */

	// the above commented code is also same
	@GetMapping("/addtodo")
	public String getaddtodopage(@ModelAttribute("todo") Todo todo, ModelMap model) {
		String username = (String) model.get("user");

		if (username != null && !username.isEmpty()) {
			// todo.setDesc("enter your skill");

			return "addtodopage";
		} else {
			return "loginpage";

		}

	}

	@RequestMapping("/delete")
	public String deletetodo(@RequestParam int todoId, ModelMap model) {

		todoservice.deleteTodo(todoId);
		return "redirect:/list";
	}

	@PostMapping("/addtodo")
	public String addtodopage(@Valid @ModelAttribute("todo") Todo todo, BindingResult result, ModelMap model) {
		System.out.println("in add todo controller");
		System.out.println(model.get("user"));
		System.out.println(todo.getDesc());
		
		System.out.println("datttttttttttttttteeeeeeeeeee"+todo.getTargetDate());
		if (result.hasErrors()) {

			return "addtodopage";
		}
		String description = todo.getDesc();

		String name = (String) model.get("user");
		todoservice.addTodo(name, description, todo.getTargetDate(), true);

		return "redirect:/list";

	}

	@GetMapping("/updatetodo")
	public String showUpdateTodo(@RequestParam int todoId, ModelMap model) {

		Todo todo1 = todoservice.getTodoById(todoId);

		System.out.println(todo1);

		model.addAttribute("todo", todo1);

		return "addtodopage";

	}

	@PostMapping("/updatetodo")
	public String updateTodo(@Valid Todo todo, BindingResult result) {
		System.out.println("+++++++++" + todo.getDesc());
		System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiidddddddddddddddd"+todo.getId());
		System.out.println("todo---------dateeeeeeeeee"+todo.getTargetDate());

		if (result.hasErrors()) {

			return "addtodopage";
		}

		Todo todo1 = todoservice.getTodoById(todo.getId());

		todo1.setDesc(todo.getDesc());
		//todo1.setTargetDate(new Date());
		todo1.setTargetDate(todo.getTargetDate());
		todo1.setDone(true);
		
		System.out
				.println("=====================================================================inside post of update");

		return "redirect:/list";

	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		System.out.println("inside init binder");
		
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy");
		 CustomDateEditor editor= new CustomDateEditor(dateFormat, false);
		 binder.registerCustomEditor(Date.class, "targetDate",editor);
		 
		 
		 
		//binder.setDisallowedFields("targetDate");
	
	}
	
	@GetMapping("/logout")
	public String handlerAA(SessionStatus status){
		status.setComplete();
		System.out.println("llllllllllllllllllllooooooooooooooooggggggggooooutttt");
		return "redirect:/login";
	}

}
