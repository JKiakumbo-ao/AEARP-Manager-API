package ao.sting.aearp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ao.sting.aearp.model.Field;
import ao.sting.aearp.service.FieldService;

@RestController
@RequestMapping("/area")
public class FieldController {
	
	@Autowired
	private FieldService fieldService;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Field> getAllFields(){
		return fieldService.getAllFields();
	}
	
	@PostMapping()
	public Field saveField(@RequestBody @Valid Field field) {
		return fieldService.saveField(field);
	}
	
	@DeleteMapping()
	public Field deleteField(@RequestBody Field field) {
		return fieldService.deleteField(field);
	}

}
