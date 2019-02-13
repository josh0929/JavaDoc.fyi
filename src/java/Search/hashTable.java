/*
 * 
 * Description:
 * 
 * 
 * @author Joshua Suarez
 * 
 * Course: COP3337 Computer Programming II
 * and open the template in the editor.
 * Instructor: Greg Shaw
 * File name:
 * Assignment: 
 * Panther ID: 6041323
 */
package Search;

/**
 *
 * @author Josh0
 */
public class hashTable
{
	LinkedList [] table;
	int tableSize;
	
	public hashTable()
	{
		tableSize = 100;
		table = new LinkedList[tableSize]; //initialize to size 100 since there 
		//are only 89 documents
		
		for(int i = 0; i < table.length; i++)
		{
			table[i] = new LinkedList();
		}
	}

	private int hash(String key)
	{
		int hashValue = 0;

		for (int i = 0; i < key.length(); i++)
		{
			hashValue = 37 * hashValue + key.charAt(i);
		}

		hashValue %= tableSize;

		if (hashValue < 0)
		{
			hashValue += tableSize;
		}

		return hashValue;
	}
	
	public void insert(String key, String value)
	{
		int loc = hash(key);
		
		table[loc].insert(value);
	}
	
	/**
	 * Return true if a character of any word in the list matches the parameter
	 * 
	 * @param key
	 * @param c
	 * @return 
	 */
	public boolean contains(String key, char c)
	{
		int loc = hash(key);
		return table[loc].contains(c);
	}

	/**
	 * Returns true if any strings within the list match the parameter
	 * 
	 * @param key
	 * @param arg
	 * @return 
	 */
	public boolean contains(String key, String arg)
	{
		int loc = hash(key);
		return table[loc].contains(arg);
	}
	
	
	 
	
}
