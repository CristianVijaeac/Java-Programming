package visualiser;

import java.util.List;

public final class Menu extends EditorArea {
	// TODO(3): Adaugati campurile, constructorii necesari si metodele care lipsesc.

	public Menu(List<EditorElement> pathInEditor) {
		super(pathInEditor);
	}

	public Color getVisualisationColor(){
		
		return Color.BLUE;
	}

}
