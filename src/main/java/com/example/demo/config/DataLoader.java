package com.example.demo.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.model.Department;
import com.example.demo.model.SiteUser;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.SiteUserRepository;

@Component
//ApplicationRunnerを実装したクラスはSpringBoot起動時に初期処理を実行できます。処理内容はrunメソッドに記載します。
public class DataLoader implements ApplicationRunner {
	

	private final DepartmentRepository repository;
	
	private final PasswordEncoder passwordEncoder;
	private final SiteUserRepository userRepository;
	
	
	public DataLoader(DepartmentRepository repository, PasswordEncoder passwordEncoder, SiteUserRepository userRepository) {
		
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
	
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		//DepartmentRepositoryのDataLoader
		var eigyou = new Department();
		eigyou.setName("営業部");
		repository.save(eigyou);
		
		var kyouiku = new Department();
		kyouiku.setName("教育部");
		repository.save(kyouiku);
		
		//SiteUserRepositoryのDataLoader
		//adminユーザを用意
		var user = new SiteUser();
		user.setUsername("admin");
		user.setPassword(passwordEncoder.encode("password"));
		
		userRepository.save(user);
		
		
	}
	
	
}