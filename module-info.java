module cs3500.pa05 {
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

  opens cs3500.pa05 to javafx.fxml;
    exports cs3500.pa05;
    exports cs3500.pa05.controller;
    exports cs3500.pa05.model;
}