package visualiser;

import java.util.List;

abstract class EditorArea {
	// TODO(3): Adaugati campurile, constructorii necesari si metodele care lipsesc.
	
	private final List<EditorElement> pathInEditor;
	
	public EditorArea(List<EditorElement> pathInEditor){
		this.pathInEditor=pathInEditor;
	}
	
	
	public abstract Color getVisualisationColor();


	public List<EditorElement> getPathInEditor() {
		return pathInEditor;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pathInEditor == null) ? 0 : pathInEditor.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EditorArea other = (EditorArea) obj;
		if (pathInEditor == null) {
			if (other.pathInEditor != null)
				return false;
		} else if (!pathInEditor.equals(other.pathInEditor))
			return false;
		return true;
	}
	
}
