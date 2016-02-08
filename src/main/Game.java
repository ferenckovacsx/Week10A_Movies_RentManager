package main;

import java.util.List;

public class Game extends Product implements Buyable
{

	boolean preOrdered;
	List<Person> staff;
	int price;
	
	public Game(String title, Person person, boolean preOrdered, List<Person> staff, int price)
	{
		super(title, person);
		this.preOrdered = preOrdered;
		this.staff = staff;
		this.price = price;

	}
	
	public boolean isPreOrdered()
	{
		return preOrdered;
	}

	public void setPreOrdered(boolean preOrdered)
	{
		this.preOrdered = preOrdered;
	}

	public List<Person> getStaff()
	{
		return staff;
	}

	public void setStaff(List<Person> staff)
	{
		this.staff = staff;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}

	public int getPrice()
	{
		if(preOrdered)
		{
			return (int)(price * 0.8);
		}
		return price;
	}

	@Override
	public long getInvestment()
	{
		int totalCost = 0;
		for (Person person : staff)
		{
			totalCost += person.salary;
		}
		return totalCost;
	}

	public String toString()
	{
		return "ID: " + id + "\n" + "Title: " + title + "\n" + "Person: " + person + "\n" + "Pre-ordered: " + preOrdered
				+ "\n" + "Staff: " + staff + "\n" + "Price: " + price + "\n" + "Investment: " + getInvestment();
	}
}
