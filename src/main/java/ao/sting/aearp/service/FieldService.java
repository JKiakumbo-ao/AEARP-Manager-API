package ao.sting.aearp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ao.sting.aearp.model.Field;
import ao.sting.aearp.repository.Fields;

@Service
public class FieldService {
	
	@Autowired
	private Fields fields;
	
	public Iterable<Field> getAllFields(){
		return fields.findAll();
	}
	
	public Field saveField(Field field) {
		return fields.save(field);
	}
	
	public Field deleteField( Field field) {
		fields.delete(field);
		return field;
	}

}
