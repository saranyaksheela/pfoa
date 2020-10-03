package com.pfoa.csvparser.dto;

public class ExpenseDto {
	
	private String month;
	private int credit;
	private int utilityBill;
	private int groceries;
	private int liability;
	
	public ExpenseDto(String month, int credit, int utilityBill, int groceries, int liability) {
		super();
		this.month = month;
		this.credit = credit;
		this.utilityBill = utilityBill;
		this.groceries = groceries;
		this.liability = liability;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getUtilityBill() {
		return utilityBill;
	}
	public void setUtilityBill(int utilityBill) {
		this.utilityBill = utilityBill;
	}
	public int getGroceries() {
		return groceries;
	}
	public void setGroceries(int groceries) {
		this.groceries = groceries;
	}
	public int getLiability() {
		return liability;
	}
	public void setLiability(int liability) {
		this.liability = liability;
	}
}
