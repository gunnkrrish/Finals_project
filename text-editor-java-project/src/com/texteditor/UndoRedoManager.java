package com.texteditor;

import javax.swing.undo.*;

public class UndoRedoManager {

    private UndoManager undoManager;

    public UndoRedoManager() {
        this.undoManager = new UndoManager();
    }

    public void addEdit(UndoableEdit edit) {
        undoManager.addEdit(edit);
    }

    public void undo() {
        if (undoManager.canUndo()) {
            undoManager.undo();
        }
    }

    public void redo() {
        if (undoManager.canRedo()) {
            undoManager.redo();
        }
    }
}
