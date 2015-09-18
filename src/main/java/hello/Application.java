package hello;

import java.sql.Time;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	UserRepository userRepository;
	@Autowired
	StatusRepository statusRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// seeding user //
		userRepository.save(new User("admin", "root"));
		userRepository.save(new User("noob", "noob"));

		// seeding status //
		User admin = userRepository.findByUser("admin");
		statusRepository.save(new Status(admin, "hello world", new Time(Calendar.getInstance().getTimeInMillis())));

		User noob = userRepository.findByUser("noob");
		statusRepository.save(new Status(noob, "hello world too", new Time(Calendar.getInstance().getTimeInMillis())));
		
		// get all status //
		for (User user : userRepository.findAll()) {
			System.out.println(user);
			for (Status statusUser : user.getStatuses()) {
				System.out.println("\t" + statusUser);
			}
		}
	}
}
