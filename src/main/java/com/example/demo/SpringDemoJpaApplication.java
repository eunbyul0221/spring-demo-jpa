package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Member;
import com.example.demo.model.Team;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.TeamRepository;

@SpringBootApplication
public class SpringDemoJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoJpaApplication.class, args);
	}
	
	
	@Bean
	public ApplicationRunner runner(MemberRepository memberRepository, TeamRepository teamRepository) {
		
		
		return args -> {
			Member member1 = new Member();
			Member member2 = new Member();
			
			member1.setId("TEST1");
			member1.setUsername("USER1");
			
			member2.setId("TEST2");
			member2.setUsername("USER2");
			
			memberRepository.save(member1);
			memberRepository.save(member2);

			Team team = new Team();
			team.setId("TEAM1");
			team.setName("TEAM_NAME1");
			
			team.addMember(member1);
			team.addMember(member2);
			
			teamRepository.save(team);
			
			//*** team을 저장하였는데, member1, member2에는 team 정보가 업데이트 되지 않음!!
			//*** team은 연관관계의 주인이 아니기 때문에 저장되지 않는다.
			

		};
	}
	

}
