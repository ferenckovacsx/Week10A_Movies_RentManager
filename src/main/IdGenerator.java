package main;

import java.util.UUID;

public class IdGenerator
{
	public static String generateId(Product productType)
	{
		String uniqueID = UUID.randomUUID().toString();
		String id = "";
		if (productType instanceof Game)
		{
			id += "GAM" + uniqueID;
		}
		else if (productType instanceof Movie)
		{
			id += "MOV" + uniqueID;
		}
		else if (productType instanceof Book)
		{
			id += "BOO" + uniqueID;
		}
		return id;
	}
}
