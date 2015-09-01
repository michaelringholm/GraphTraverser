
public class ComplexEntity {
	public int id;
	public String type;
	public String value;
	public int mcId;
	public int catId;
	public int locId;
	
	public void updateChildReferences(ComplexEntity child) {
		if(this.type.equals("MainCategory"))
			child.mcId = this.id;
		else if(this.type.equals("Category"))
			child.catId = this.id;
		else if(this.type.equals("Location"))
			child.locId = this.id;
		else
			throw new RuntimeException("Unknown type [" + this.type + "]");
	}
}
