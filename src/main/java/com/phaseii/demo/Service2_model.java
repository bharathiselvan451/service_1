package com.phaseii.demo;

import java.time.LocalDate;

public class Service2_model {
	
	private int budget;
	
	
	public Service2_model(int budget, String name, int expense, LocalDate date, String mail) {
		super();
		this.budget = budget;
		
		this.name = name;
		this.expense = expense;
		this.date = date;
		this.mail = mail;
	}
	public Service2_model() {
		
	}
	private String name;
	private int expense;
	private LocalDate date;
	private String mail;
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getExpense() {
		return expense;
	}
	public void setExpense(int expense) {
		this.expense = expense;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "Service2_model [budget=" + budget + ", name=" + name + ", expense=" + expense + ", date=" + date
				+ ", mail=" + mail + "]";
	}
	
	

}
