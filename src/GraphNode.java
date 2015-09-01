

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
	
	boolean visited;
	boolean saved;
	List<GraphNode> parents = new ArrayList<GraphNode>();
	List<GraphNode> children = new ArrayList<GraphNode>();

	ComplexEntity complexEntity;
	
	public GraphNode(ComplexEntity complexEntity)
	{
		this.complexEntity = complexEntity;
	}
	
	protected boolean process()
	{
		if(hasUnsavedParents())
			return false;
		else
		{
			complexEntity.id++;
			System.out.println(toString());
			saved = true;
			
			updateChildReferences();
			
			return true;
		}
	}

	private void updateChildReferences() {
		for(GraphNode child : children)
		{
			if(child.saved)
			{
				System.err.println(child.toString());
				throw new RuntimeException("Child was already saved, can't change related ids at this point");
			}
			
			complexEntity.updateChildReferences(child.complexEntity);
		}
	}

	public GraphNode getUnvisitedNode() {
		
		for(GraphNode parent : parents)
			if(!parent.visited)
				return parent;
		
		for(GraphNode child : children)
			if(!child.visited)
				return child;
		
		return null;
	}
	
	private boolean hasUnsavedParents()
	{
		for(GraphNode parent : parents)
			if(!parent.saved)
				return true;
		
		return false;
	}
	
	public String toString()
	{
		return String.format("{ id : '%d', mcId : '%d', locId : '%d', catId : '%d', type : '%s', value : '%s', saved : '%b', visited : '%b' }", complexEntity.id, complexEntity.mcId, complexEntity.locId, complexEntity.catId, complexEntity.type, complexEntity.value, saved, visited);
	}
}
