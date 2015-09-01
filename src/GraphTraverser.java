

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTraverser {

	private Stack<GraphNode> _stack;
	private Queue<GraphNode> _queue;
	
	public GraphTraverser()
	{
		_stack = new Stack<GraphNode>();
		_queue = new LinkedList<GraphNode>();
	}
	
	
	protected void push(GraphNode node)
	{
		_stack.push(node);
	}
	
	protected GraphNode pop()
	{
		return _stack.pop();
	}
	
	protected GraphNode peek()
	{
		return _stack.peek();
	}
	
	protected boolean isStackEmpty()
	{
		return _stack.isEmpty();
	}
	
	public void traverse()
	{
		while(!isStackEmpty())
		{
			GraphNode node = peek();
			GraphNode relatedNode = node.getUnvisitedNode();
			
			if(relatedNode != null)
			{
				relatedNode.visited = true;
				
				if(!relatedNode.process())
					_queue.add(relatedNode);
				
				push(relatedNode);
			}
			else
				pop();
		}
		
		while(!_queue.isEmpty())
		{
			GraphNode queuedNode = _queue.poll();
				
			if(!queuedNode.process())
				_queue.add(queuedNode);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Starting graph traversal...");
		GraphTraverser traverser = new GraphTraverser();
		Repository repo = new Repository();
		GraphNode startNode = repo.loadAll();
		
		traverser.push(startNode);
		startNode.visited = true;
		if(!startNode.process())
			traverser._queue.add(startNode);
		
		traverser.traverse();
		System.out.println("Graph traversal ended.");
	}
}
