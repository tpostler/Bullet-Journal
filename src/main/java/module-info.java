module bulletJournal {
    requires javafx.graphics;
     requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
  requires java.prefs;
  requires com.fasterxml.jackson.annotation;
  requires com.fasterxml.jackson.databind;
  requires java.base;
  requires me.xdrop.fuzzywuzzy;
  requires java.desktop;

  opens bulletJournal to javafx.fxml;
    exports bulletJournal;
    exports bulletJournal.controller;
    exports bulletJournal.model;
}