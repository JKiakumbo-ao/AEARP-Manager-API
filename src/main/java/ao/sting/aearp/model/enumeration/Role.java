package ao.sting.aearp.model.enumeration;

public enum Role {
	
	PRESIDENT("Presidente"),
	VICE_PRESIDENT("Vice-presidente"),
	GENERAL_SECRETARY("Secretario (a) geral"),
	FINANCIAL("Tesoreiro (a)"),
	CITY_SECRETARY("Secretario (a) da cidade"),
	MEMBER("Membro");
	
	private String description;


	Role(String description) {
		this.description = description;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	
	
	

}
