package main;

public abstract class Product
{
	String id;
	String title;
	Person person;
	
	public Product(String title, Person person)
	{
		this.title = title;
		this.person = person;
	}
	public String getTitle()
	{
		return title;
	}
	public Person getPerson()
	{
		return person;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	
	public abstract long getInvestment();
}
