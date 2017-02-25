package visualiser;


import java.util.List;

public class GetArea {

	private final FurnitureFactory factory;

	public GetArea(FurnitureFactory factory) {
		this.factory = factory;
	}

	EditorArea determineAreaForElements(List<EditorElement> elements) {
		if (elements.size()!=0){
			if (elements.get(0).getType().contains("card") || elements.get(0).getType().contains("input") || elements.get(0).getType().contains("page"))
				return factory.createCanvas(elements);
			else if (elements.get(0).getType().contains("menu") || elements.get(0).getType().contains("menu-button") || elements.get(0).getType().contains("icon"))
				return factory.createMenu(elements);
			else if(elements.get(0).getType().contains("dialog"))
				return factory.createDialogBox(elements);
			else return factory.createUnknownArea(elements);
		}else return null;
	}
}
