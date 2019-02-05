package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test.service.TestService;

import static java.lang.System.exit;

@SpringBootApplication
public class SpringBootStarter implements CommandLineRunner{

	@Autowired 
	TestService testService;
	public static void main(String[] args) {
		//disabled banner, don't want to see the spring logo
        SpringApplication app = new SpringApplication(SpringBootStarter.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

	}
	
    @Override
    public void run(String... args) throws Exception {

        if (args.length > 0) {
            System.out.println(testService.getMessage(args[0].toString()));
        } else {
            System.out.println(testService.getMessage());
        }

        exit(0);
    }

}
