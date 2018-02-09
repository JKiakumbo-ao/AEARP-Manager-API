package ao.sting.aearp.model.enumeration;

public enum StudentFrom {
	
	INAGBE("Bolseiro do INAGBE"),
	BOLSEIRO("Bolseiro mas não do INAGBE"),
	COOPERACAO("Bolseiro da cooperação"),
	CONTA_PROPIA ("Estuda na conta propia");
	
	private String description;


	StudentFrom(String description) {
		this.description = description;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	
	
	

}
