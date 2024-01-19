package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Collection;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

@Component
class BookingCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		for (Booking b : this.bookingRepository.findAll())
			System.out.println(b.toString());
	}

	@Autowired
	BookingRepository bookingRepository;

}

interface BookingRepository extends JpaRepository<Booking, Long> {

	Collection<Booking> findByBookingName(String bookingName);

}

@RestController
class BookingRestController {

	@RequestMapping("/bookings")
	Collection<Booking> bookings () {
		return this.bookingRepository.findAll();
	}

	@Autowired BookingRepository bookingRepository;
}

@Entity
class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String bookingName;

	public Booking(String bookingName) {
		super();
		this.bookingName = bookingName;
	}

	public Booking() {

	}

	public long getId() {
		return id;
	}

	public String getBookingName() {
		return bookingName;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingName=" + bookingName + "]";
	}
}