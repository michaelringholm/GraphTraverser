

public class Repository {

	public GraphNode loadAll() {
		GraphNode mc1 = new GraphNode(new ComplexEntity());
		mc1.complexEntity.id = 55;
		mc1.complexEntity.type = "MainCategory";
		mc1.complexEntity.value = "Gearbox";		
		
		GraphNode cat1 = new GraphNode(new ComplexEntity());
		cat1.complexEntity.id = 25;
		cat1.complexEntity.mcId = 55;
		cat1.complexEntity.type = "Category";
		cat1.complexEntity.value = "CD_01";
		
		GraphNode cat2 = new GraphNode(new ComplexEntity());
		cat2.complexEntity.id = 27;
		cat2.complexEntity.mcId = 55;
		cat2.complexEntity.type = "Category";
		cat2.complexEntity.value = "CD_02";
		cat2.parents.add(mc1);
		
		GraphNode cat3 = new GraphNode(new ComplexEntity());
		cat3.complexEntity.id = 34;
		cat3.complexEntity.mcId = 55;
		cat3.complexEntity.type = "Category";
		cat3.complexEntity.value = "VE_01";
		
		GraphNode catPrio1 = new GraphNode(new ComplexEntity());
		catPrio1.complexEntity.id = 88;
		catPrio1.complexEntity.mcId = 25;
		catPrio1.complexEntity.type = "CategoryPriority";
		catPrio1.complexEntity.value = "Carweb_2100";
		catPrio1.parents.add(cat1);

		GraphNode catPrio2 = new GraphNode(new ComplexEntity());
		catPrio2.complexEntity.id = 93;
		catPrio2.complexEntity.mcId = 25;
		catPrio2.complexEntity.type = "CategoryPriority";
		catPrio2.complexEntity.value = "Kromeda_2100";
		
		
		GraphNode loc1 = new GraphNode(new ComplexEntity());
		loc1.complexEntity.id = 105;
		loc1.complexEntity.type = "Location";
		loc1.complexEntity.value = "Outside";
		loc1.children.add(cat1);
		loc1.children.add(cat2);

		GraphNode loc2 = new GraphNode(new ComplexEntity());
		loc2.complexEntity.id = 107;
		loc2.complexEntity.type = "Location";
		loc2.complexEntity.value = "Inside";
		loc2.children.add(cat3);

		catPrio2.parents.add(loc1);
		catPrio2.parents.add(cat1);

		cat3.parents.add(loc2);
		cat3.parents.add(mc1);
		
		cat2.parents.add(loc1);
		cat2.parents.add(mc1);
		
		cat1.children.add(catPrio1);
		cat1.children.add(catPrio2);
		cat1.parents.add(mc1);
		cat1.parents.add(loc1);
		
		mc1.children.add(cat1);
		mc1.children.add(cat2);
		mc1.children.add(cat3);
		
		return catPrio2;
	}

}
