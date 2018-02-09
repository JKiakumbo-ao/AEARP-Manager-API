package ao.sting.aearp.model.enumeration;

public enum Title {
	MEDIUM_TECHNICIAN("Técnico médio"),
	LICENSED("Licenciado"),
	ENGINEER("Engenheiro"),
	ARCHITECT_ENGINNER("Engenheiro arquitecto"),
	MASTER("Mestre"),
	DOCTOR("Doutor"),
	DOCTOR_HABILITATED("Doutor habilitado"),
	PROFESSOR_DOCTOR("Professor doutor");
	
	private String description;


	Title(String description) {
		this.description = description;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	
	
	

}
