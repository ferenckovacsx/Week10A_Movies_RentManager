package main;

import java.util.List;

public class Movie extends Product implements Buyable
{
	Genre genre;
	long duration;
	double rate;
	List<Person> cast;
	int price;
	
	public Movie(String title, Person person, Genre genre, long duration, double rate, List<Person> cast, int price)
	{
		super(title, person);
		this.genre = genre;
		this.duration = duration;
		this.rate = rate;
		this.cast = cast;
		this.price = price;
	}
	
	public Genre getGenre()
	{
		return genre;
	}

	public void setGenre(Genre genre)
	{
		this.genre = genre;
	}

	public long getDuration()
	{
		return duration;
	}

	public void setDuration(long duration)
	{
		this.duration = duration;
	}

	public double getRate()
	{
		return rate;
	}

	public void setRate(double rate)
	{
		this.rate = rate;
	}

	public List<Person> getCast()
	{
		return cast;
	}

	public void setCast(List<Person> cast)
	{
		this.cast = cast;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}

	public int getPrice()
	{
		return 0;
	}
	
	@Override
	public long getInvestment()
	{
		int totalCost = 0;
		for (Person person : cast)
		{
			totalCost += person.salary;
		}
		return totalCost;
	}

	public String toString()
	{
		return "ID: " + id + "\n" + "Title: " + title + "\n" + "Person: " + person + "\n" + "Genre: " + genre + "\n"
				+ "Duration: " + duration + "\n" + "Rate: " + rate + "\n" + "Cast: " + cast + " " + "Price: " + price
				+ "\n" + "Investment: " + getInvestment();
	}

}
