package com.training.jpacrud.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import lombok.Data;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotEmpty(message = "Training name cannot be empty")
	private String name;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	
	private LocalDate startDate;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	
	private LocalDate endDate;

	@Min(1000)
	private float fee;

	@Max(80)
	private float gst;

	@NotEmpty
	private String trainerName;

	@Max(50)
	private int personsAllowed;
	@Max(50)
	private int personsNominated;
	@NotEmpty
	private String skills;

	@Override
	public String toString() {
		return "Training [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", fee="
				+ fee + ", gst=" + gst + ", trainerName=" + trainerName + ", personsAllowed=" + personsAllowed
				+ ", personsNominated=" + personsNominated + ", skills=" + skills + "]";
	}

	public Training(int id, @NotEmpty String name, @PastOrPresent LocalDate startDate,
			@FutureOrPresent LocalDate endDate, @Min(1000) float fee, @Max(80) float gst, @NotEmpty String trainerName,
			@Max(50) int personsAllowed, @Max(50) int personsNominated, @NotEmpty String skills) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fee = fee;
		this.gst = gst;
		this.trainerName = trainerName;
		this.personsAllowed = personsAllowed;
		this.personsNominated = personsNominated;
		this.skills = skills;
	}

	public Training() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public float getGst() {
		return gst;
	}

	public void setGst(float gst) {
		this.gst = gst;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public int getPersonsAllowed() {
		return personsAllowed;
	}

	public void setPersonsAllowed(int personsAllowed) {
		this.personsAllowed = personsAllowed;
	}

	public int getPersonsNominated() {
		return personsNominated;
	}

	public void setPersonsNominated(int personsNominated) {
		this.personsNominated = personsNominated;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endDate, fee, gst, id, name, personsAllowed, personsNominated, skills, startDate,
				trainerName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Training other = (Training) obj;
		return Objects.equals(endDate, other.endDate) && Float.floatToIntBits(fee) == Float.floatToIntBits(other.fee)
				&& Float.floatToIntBits(gst) == Float.floatToIntBits(other.gst) && id == other.id
				&& Objects.equals(name, other.name) && personsAllowed == other.personsAllowed
				&& personsNominated == other.personsNominated && Objects.equals(skills, other.skills)
				&& Objects.equals(startDate, other.startDate) && Objects.equals(trainerName, other.trainerName);
	}
	
	

}