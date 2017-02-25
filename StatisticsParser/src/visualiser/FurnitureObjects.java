package visualiser;

import java.util.List;

public interface FurnitureObjects {

	Canvas createCanvas(List<EditorElement> pathInEditor);
	Menu createMenu(List<EditorElement> pathInEditor);
	DialogBox createDialogBox(List<EditorElement> pathInEditor);
	UnknownArea createUnknownArea(List<EditorElement> pathInEditor);
}

