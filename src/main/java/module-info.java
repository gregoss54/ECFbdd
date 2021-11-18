module fr.greg.ecfbdd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens fr.greg.ecfbdd.Entities to javafx.base;
            opens fr.greg.ecfbdd to javafx.fxml;
    exports fr.greg.ecfbdd;
    exports fr.greg.ecfbdd.utils;
    opens fr.greg.ecfbdd.utils to javafx.fxml;
}