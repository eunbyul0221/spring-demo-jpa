package com.example.demo.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Member;
import com.example.demo.model.Team;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MemberRepositoryTest {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	TeamRepository teamRepository;
	
	@Test
	public void insertTest() {
		Member member = new Member();
		member.setId("TEST1");
		member.setUsername("USER_NAME1");
		Team team = new Team();
		team.setId("TEAM1");
		team.setName("TEAM_NAME1");
		member.setTeam(team);
		teamRepository.save(team);
		
//		memberRepository.save(member);
//		memberRepository.flush();
		memberRepository.saveAndFlush(member);
		
//		Member findMember = memberRepository.getOne("TEST1");
		Optional<Member> findOptional = memberRepository.findById("TEST1");

		if(findOptional.isPresent()) {
			Member findMember = findOptional.get();
			log.info(findMember.getUsername());
		}else {
			log.info("NOT FOUND");
		}
//		log.info(findMember.getUsername());
		
		
		
	}

}
