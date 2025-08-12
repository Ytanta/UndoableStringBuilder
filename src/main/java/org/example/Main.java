package org.example;

public class Main {
    public static void main(String[] args) {
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("Hello");
        usb.append(", ").append("World!");
        System.out.println(usb);

        usb.undo();
        System.out.println(usb);

        usb.undo();
        System.out.println(usb);
    }
}