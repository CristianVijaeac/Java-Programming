package visualiser;

import java.util.List;

public class FurnitureFactory implements FurnitureObjects{

	public Canvas createCanvas(List<EditorElement> pathInEditor){
		return new Canvas(pathInEditor);
	}
	
	public Menu createMenu(List<EditorElement> pathInEditor){
		return new Menu(pathInEditor);
	}
	
	public DialogBox createDialogBox(List<EditorElement> pathInEditor){
		return new DialogBox(pathInEditor);
	}
	
	public UnknownArea createUnknownArea(List<EditorElement> pathInEditor){
		return new UnknownArea(pathInEditor);
	}

}
