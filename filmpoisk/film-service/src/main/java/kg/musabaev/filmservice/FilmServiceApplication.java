package kg.musabaev.filmservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FilmServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(FilmServiceApplication.class, args);
	}

	public static List<Film> films = List.of(
			new Film(1, "Зеленая миля", 1999),
			new Film(2, "Побег из Шоушенка", 1994),
			new Film(3, "Хатико: Самый верный друг", 2008),
			new Film(4, "Список Шиндлера", 1993),
			new Film(5, "Запах женщины", 1992),
			new Film(6, "Зеленая книга", 2018),
			new Film(7, "Список смертников", 2022),
			new Film(8, "Друг в океане", 2022),
			new Film(9, "Самый пьяный округ в мире", 2012),
			new Film(10, "Мир Юрского периода", 2015)
	);
}