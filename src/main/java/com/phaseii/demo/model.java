package com.phaseii.demo;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class model {
	@JsonProperty("email")
	private String email;
	@JsonProperty("dmail")
	private String dmail;
	public String getDmail() {
		return dmail;
	}
	public void setDmail(String dmail) {
		this.dmail = dmail;
	}
	@JsonProperty("name")
	private String name;
	@JsonProperty("password")
	private String password;
	@JsonProperty("expense")
	private int expense;
	@JsonProperty("budget")
	private int budget;
	@JsonProperty("date")
	private LocalDate date;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getExpense() {
		return expense;
	}
	public void setExpense(int expense) {
		this.expense = expense;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "model [email=" + email + ", dmail=" + dmail + ", name=" + name + ", password=" + password + ", expense="
				+ expense + ", budget=" + budget + ", date=" + date + "]";
	}
	
}
