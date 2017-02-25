package visualiser;

import java.util.List;

public final class DialogBox extends EditorArea {
	// TODO(3): Adaugati campurile, constructorii necesari si metodele care lipsesc.

	public DialogBox(List<EditorElement> pathInEditor) {
		super(pathInEditor);
	}

	public Color getVisualisationColor(){
		
		return Color.GREEN;
	}
}
