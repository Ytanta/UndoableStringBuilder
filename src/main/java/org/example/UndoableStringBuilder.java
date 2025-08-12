package org.example;

import java.util.Stack;

public class UndoableStringBuilder {
    private StringBuilder stringBuilder; //
    private Stack<String> history;

    public UndoableStringBuilder() {
        this.stringBuilder = new StringBuilder();
        this.history = new Stack<>();
        saveSnapshot();
    }

    private void saveSnapshot() {
        history.push(stringBuilder.toString());
    }

    public void undo() {
        if (history.size() > 1) {
            history.pop(); //
            stringBuilder = new StringBuilder(history.peek());
        }
    }

    public UndoableStringBuilder append(String str) {
        stringBuilder.append(str);
        saveSnapshot();
        return this;
    }

    public UndoableStringBuilder insert(int offset, String str) {
        stringBuilder.insert(offset, str);
        saveSnapshot();
        return this;
    }

    public UndoableStringBuilder delete(int start, int end) {
        stringBuilder.delete(start, end);
        saveSnapshot();
        return this;
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}