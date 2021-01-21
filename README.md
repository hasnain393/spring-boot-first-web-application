# spring-boot-first-web-application
* reference:https://github.com/in28minutes/springbootwebapplicationstepbystep
* Run the project and go to->http://localhost:8080/login ->enter user name as :in28Minutes  and password as :12345
* to create springboot-project go to->https://start.spring.io/
* has login and logout functionality(using spring session)->@SessionAttributes("name")
* used Command Bean or Form Backing Bean ->@ModelAttribute->Bean->Form Binding &&Form->Bean Binding (ie two way binding)
* used Hibernate Validator for validation
# Bean Validation API is a specification and Hibernate Validator is a implementation of Bean Validation API specification
* JSR 380 is a specification of the Java API for bean validation (2.O) & JSR 303 & 349 is a specification of the Java API for bean validation for version (1.0 &1.1 ) respectively
* apart from hibernate validator ,spring has its own validator
* Server side validation vs Client side Validation(html vs javascript vs java)
#### steps for server side validation:
1. Command Bean or Form Backing Bean->@ModelAttribute
2. Add Validation ->On Bean (POJO) LIKE:
```
@NotBlank(message="*can not be blank") 
@Size(min=6 ,message=" *minimun 6 characters required")
```
3. Use Validation on Controller->@Valid and BindingResult :(@Valid @ModelAttribute("todo") Todo todo, BindingResult result)
4. Display Error on form: <form:errors> using following import:<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

###### To keep Date or different field in same format across the application we use initBinder
* used initBinder to handle Date,take date in specific format and bind to  bean with the help of init Binder 
* which uses WebDataBinder and various  different editor according to our requirement(CustomDateEditor,CustomNumberEditor and so on )

