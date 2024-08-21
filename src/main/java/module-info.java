module PersoFI {
    exports PersoFI;
    exports PersoFI.controller;
    exports PersoFI.model;
    exports PersoFI.util;
    exports PersoFI.dao;

    requires java.sql;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires AnimateFX;
    requires com.jfoenix;


    opens PersoFI to javafx.fxml;
    opens PersoFI.controller to javafx.fxml;
}