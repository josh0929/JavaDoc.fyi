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
public class LinkedList
{

	Node root;

	public LinkedList()
	{
		root = null;
	}

	public void insert(String arg)
	{
		Node newNode = new Node(arg);
		
		if (root == null)
			root = newNode;
		else
		{
			Node temp = root;

			while (temp.getNext() != null)
				temp = temp.getNext();

			temp.setNext(newNode);
		}
	}

	public boolean contains(String arg)
	{
		boolean found = false;

		if (root == null)
			return found;
		else
		{
			Node temp = root;

			while (temp.getNext() != null)
			{
				if (!temp.getInfo().equalsIgnoreCase(arg))
					temp = temp.getNext();
				else
					found = true;
			}
		}
		return found;
	}

	public boolean contains(char c)
	{
		boolean isPresent = false;

		if (root == null)
			return isPresent;
		else
		{
			Node temp = root;

			while (temp.getNext() != null)
			{
				String current = temp.getInfo();
				for (int i = 0; i < current.length(); i++)
				{
					if (current.charAt(i) == c)
						isPresent = true;
				}
				temp = temp.getNext();
			}
		}
		return isPresent;
	}
	
	
	
	
}
