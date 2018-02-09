package ao.sting.aearp.model.enumeration;

public enum Status {
	
	STADYING ("Estudando"),
	BACK_TO_ANGOLA (" Já voltou"),
	FINISHED_BUT_IS_IN_POLAND ("Terminou mas está na Polonia"),
	NOT_FINISHED_BUT_IS_IN_POLAND ("Não terminou mas está na Polonia"),
	NOT_FINISHED_BUT_BACK_TO_ANGOLA ("Não terminou mas já voltou");
	
	private String description;


	Status(String description) {
		this.description = description;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	
	
	

}
