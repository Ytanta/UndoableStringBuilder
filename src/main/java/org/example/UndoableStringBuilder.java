package org.example;

import java.util.ArrayDeque;
import java.util.Deque;


public class UndoableStringBuilder {
    private static final int DEFAULT_HISTORY_SIZE = 10;

    private final StringBuilder stringBuilder;
    private final Deque<String> history;
    private final int maxHistorySize;

    public UndoableStringBuilder(int maxHistorySize) {
        if (maxHistorySize < 1) {
            throw new IllegalArgumentException("maxHistorySize должен быть >= 1");
        }
        this.stringBuilder = new StringBuilder();
        this.history = new ArrayDeque<>();
        this.maxHistorySize = maxHistorySize;
        saveSnapshot();
    }

    public UndoableStringBuilder() {
        this(DEFAULT_HISTORY_SIZE);
    }

    private void saveSnapshot() {
        history.push(stringBuilder.toString());
    }

    public void undo() {
        if (history.size() > 1) {
            history.pop();
            stringBuilder.setLength(0);
            stringBuilder.append(history.peek());
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
