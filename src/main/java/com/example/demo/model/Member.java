package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Member {
	@Id
	@Column(name="MEMBER_ID")
	private String id;
	
	private String username;
	
	
	//일반적으로 연관관계의 주인은 FK를 가지고 있는 쪽이다. 
	@ManyToOne
	@JoinColumn(name="TEAM_ID")
	private Team team;
	

}
