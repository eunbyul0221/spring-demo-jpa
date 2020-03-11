package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Team {

	@Id
	@Column(name="TEAM_ID")
	private String id;
	private String name;
	
	//mappedBy는 상대쪽에 team으로 매핑되어 있다는 정보이다. 
	//mappedBy -> 연관관계의 주인이 아님
	@OneToMany(mappedBy="team")
	private List<Member> memberList;
	
	public void addMember(Member member) {
		if(memberList == null) {
			memberList = new ArrayList<Member>();
			memberList.add(member);
		}else {
			if(!memberList.contains(member)) {
				memberList.add(member);
			}
			//양방향 관계이기 때문에 member에게도 team의 정보를 알려주어야 한다.
			member.setTeam(this);
		}
		
	}
}
