package com.boralovesahleak.spring.demo.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="student_seq_id")
	@SequenceGenerator (name="student_seq_id", sequenceName="boralovesahleaksomuch", allocationSize= 1, initialValue=1)
	@Column
	private int stuId; 
	
	@Column
	private String stuName;
	
	@Column
	private String lvlYear;

	@Column
	private BigDecimal score; 
	
	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getLvlYear() {
		return lvlYear;
	}

	public void setLvlYear(String lvlYear) {
		this.lvlYear = lvlYear;
	}
	

}
