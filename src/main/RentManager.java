package main;

import java.util.ArrayList;
import java.util.List;

public class RentManager
{

	public static void main(String[] args)
	{
	
		Person buyer_renter = new Person("Ferenc", "Kovacs", Gender.MALE, 25);

		// Book 1 instantiation
		Person author1 = new Person("Geza", "Gardonyi", Gender.MALE, 5000);
		Product book1 = new Book("Egri Csillagok", buyer_renter, author1);
		book1.setId(IdGenerator.generateId(book1));
		
		// Book 2 instantiation
		Person author2 = new Person("Jules", "Verne", Gender.MALE, 5000);
		Product book2 = new Book("Mysterious Island", buyer_renter, author2);
		book2.setId(IdGenerator.generateId(book2));

		// Game staff instantiation
		Person staff1 = new Person("Kovacs", "Bela", Gender.MALE, 20);
		Person staff2 = new Person("Pataki", "Petunia", Gender.FEMALE, 25);
		Person staff3 = new Person("Jack", "Daniels", Gender.MALE, 50);
		Person staff4 = new Person("Mary", "Jane", Gender.FEMALE, 32);
		List<Person> staff = new ArrayList<Person>();
		staff.add(staff1);
		staff.add(staff2);
		staff.add(staff3);
		staff.add(staff4);
		
		//Game 1 instantiation 
		Product game1 = new Game("Carmageddon", buyer_renter, true, staff, 100);
		game1.setId(IdGenerator.generateId(game1));
		
		//Game 2 instantiation 
		Product game2 = new Game("Minesweeper", buyer_renter, false, staff, 1000);
		game2.setId(IdGenerator.generateId(game2));

		// Movie 1 instantiation
		Person actor1 = new Person("Bill", "Murray", Gender.MALE, 1000000);
		Person actor2 = new Person("Tilda", "Swanton", Gender.FEMALE, 250000);
		List<Person> cast1 = new ArrayList<Person>();
		cast1.add(actor1);
		cast1.add(actor2);
		Product movie1 = new Movie("Moonrise Kingdom", buyer_renter, Genre.DRAMA, 121, 8.5, cast1, 194000000);
		movie1.setId(IdGenerator.generateId(movie1));
		
		// Movie 2 instantiation
		Person actor3 = new Person("John", "Travolta ", Gender.MALE, 250000);
		Person actor4 = new Person("Quentin", "Tarantino", Gender.MALE, 50000);
		List<Person> cast2 = new ArrayList<Person>();
		cast2.add(actor3);
		cast2.add(actor4);
		Product movie2 = new Movie("Pulp Fiction", buyer_renter, Genre.COMEDY, 119, 6.3, cast2, 30000);
		movie2.setId(IdGenerator.generateId(movie2));

		// Buyables
		List<Buyable> buyables = new ArrayList<Buyable>();
		buyables.add((Movie) movie1);
		buyables.add((Movie) movie2);
		buyables.add((Game) game1);
		buyables.add((Game) game2);

		// PRINTING
		System.out.println(book1 + "\n");
		System.out.println(book2 + "\n");
		System.out.println(game1 + "\n");
		System.out.println(game2 + "\n");
		System.out.println(movie1 + "\n");
		System.out.println(movie2 + "\n");
		System.out.println(buyableIncome(buyables));

	}

	public static int buyableIncome(List<Buyable> buyables)
	{
		int result = 0;
		for (Buyable buyable : buyables)
		{
			result += buyable.getPrice();
		}
		return result;
	}

}