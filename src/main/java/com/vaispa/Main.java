package com.vaispa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//
//	@Autowired
//	private UserRepository userRepository;

//	@PostConstruct
//	public void init() {
//		User user = new User("Anup", "Mridha", "vaispa", passwordEncoder.encode("password"),
//				Arrays.asList(new Role("ROLE_USER"), new Role("ROLE_ADMIN")));
//
//		if (userRepository.findByUsername(user.getUsername()) == null) {
//			userRepository.save(user);
//		}
//	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}

}
