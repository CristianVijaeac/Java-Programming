package visualiser;

import java.util.List;

final class UnknownArea extends EditorArea {
	// TODO(3): Adaugati campurile, constructorii necesari si metodele care lipsesc.
	
	public UnknownArea(List<EditorElement> pathInEditor) {
		super(pathInEditor);
	}

	public Color getVisualisationColor(){
		
		return Color.GRAY;
	}

}
