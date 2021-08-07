package com.ngf.cursoionic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ngf.cursoionic.services.S3Service;

@SpringBootApplication
public class CursoIonicApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CursoIonicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}