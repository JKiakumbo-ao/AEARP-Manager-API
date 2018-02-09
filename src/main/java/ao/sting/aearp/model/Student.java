package ao.sting.aearp.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

import ao.sting.aearp.model.enumeration.Role;
import ao.sting.aearp.model.enumeration.Status;
import ao.sting.aearp.model.enumeration.StudentFrom;
import ao.sting.aearp.model.enumeration.Title;

@Entity
@Table(name = "student")
public class Student implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String surname;
	
	private String phone;
	
	@NotBlank
	private String email;
	
	private String city;
	
	private String street;
	
	private String number;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	@Column(name ="user_name")
	private String userName;
	
	private String photo;
	
	private String password;
	
	@Transient
	private String passwordConfirm;
	
	@Transient
	private Boolean active;
	
	@Column(name="content_type")
	private String contentType;
	
	@Transient
	private boolean newPhoto;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@ManyToMany(mappedBy = "students")
	private Set<Field> field;
	
	@ManyToMany(mappedBy = "students")
	private Set<Course> curso;
	
	@Enumerated(EnumType.STRING)
	private Title tilte;
	
	@Column(name = "student_from")
	@Enumerated(EnumType.STRING)
	private StudentFrom studentFrom;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	//Account bank
	
	@Column(name = "account_number")
	private String accountNumber;
	
	private String iban;
	
	private String swift;
	
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the passwordConfirm
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	/**
	 * @param passwordConfirm the passwordConfirm to set
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		if(this.status.equals(Status.NOT_FINISHED_BUT_BACK_TO_ANGOLA) || this.status.equals(Status.NOT_FINISHED_BUT_IS_IN_POLAND))
			return false;
		return true;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the newPhoto
	 */
	public boolean isNewPhoto() {
		return newPhoto;
	}

	/**
	 * @param newPhoto the newPhoto to set
	 */
	public void setNewPhoto(boolean newPhoto) {
		this.newPhoto = newPhoto;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the field
	 */
	public Set<Field> getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(Set<Field> field) {
		this.field = field;
	}

	/**
	 * @return the curso
	 */
	public Set<Course> getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(Set<Course> curso) {
		this.curso = curso;
	}
	

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the tilte
	 */
	public Title getTilte() {
		return tilte;
	}

	/**
	 * @param tilte the tilte to set
	 */
	public void setTilte(Title tilte) {
		this.tilte = tilte;
	}

	/**
	 * @return the studentFrom
	 */
	public StudentFrom getStudentFrom() {
		return studentFrom;
	}

	/**
	 * @param studentFrom the studentFrom to set
	 */
	public void setStudentFrom(StudentFrom studentFrom) {
		this.studentFrom = studentFrom;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the iban
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * @param iban the iban to set
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

	/**
	 * @return the swift
	 */
	public String getSwift() {
		return swift;
	}

	/**
	 * @param swift the swift to set
	 */
	public void setSwift(String swift) {
		this.swift = swift;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
