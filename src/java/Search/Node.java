package Search;

public class Node
{
	private String info;
	private Node next;
	
	public Node() {}
	
	public Node(String info)
	{
		this.info = info;
		next = null;
	}
	
	public void setNext(Node node)
	{
		next = node;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public void setInfo(String arg)
	{
		info = arg;
	}
	
	public String getInfo()
	{
		return info;
	}
}
