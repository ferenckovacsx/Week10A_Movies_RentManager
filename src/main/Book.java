package main;

public class Book extends Product implements Buyable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7196380723373465321L;
	Person author;
	
	public Book(String title, Person person, Person author)
	{
		super(title, person);
		this.author = author;
	}
	public Person getAuthor()
	{
		return author;
	}
	public void setAuthor(Person author)
	{
		this.author = author;
	}
	public int getPrice()
	{
		return 0;
	}

	@Override
	public long getInvestment()
	{
		return author.getSalary();
	}

	public String toString()
	{
		return "ID: " + id + "\n" + "Title: " + title + "\n" + "Customer: " + person + "\n" + "Author: "
				+ author.firstName + " " + author.lastName + "\n" + "Salary: " + author.salary;
	}
}
