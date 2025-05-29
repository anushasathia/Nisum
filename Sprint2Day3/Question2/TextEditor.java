package com.example.demo;

public class TextEditor {
    private SpellChecker spellChecker;

    // No-argument constructor — required for setter injection
    public TextEditor() {
        System.out.println("Default constructor called.");
    }

    // Constructor Injection
    public TextEditor(SpellChecker spellChecker) {
        System.out.println("Constructor Injection called.");
        this.spellChecker = spellChecker;
    }

    // Setter Injection
    public void setSpellChecker(SpellChecker spellChecker) {
        System.out.println("Setter Injection called.");
        this.spellChecker = spellChecker;
    }

    public void spellCheck() {
        spellChecker.checkSpelling();
    }
}