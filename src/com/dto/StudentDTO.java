package com.dto;

import java.io.Serializable;

public class StudentDTO implements Serializable{
	private int id;
	private int grade;
	private int room;
	private String name;
	private String phone;
	private String exam;
	private int korean;
	private int engilsh;
	private int math;
	private double avg;
	
	public StudentDTO() {
		super();
	}
	
	public StudentDTO(int id, int grade, int room, String name, String phone, String exam, int korean, int english, int math, double avg) {
		super();
		this.id = id;
		this.grade = grade;
		this.room = room;
		this.phone = phone;
		this.exam = exam;
		this.korean = korean;
		this.engilsh = english;
		this.math = math;
		this.avg = avg;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getExam() {
		return exam;
	}
	public void setExam(String exam) {
		this.exam = exam;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEngilsh() {
		return engilsh;
	}
	public void setEngilsh(int engilsh) {
		this.engilsh = engilsh;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
}
