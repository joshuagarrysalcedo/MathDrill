module ph.jsalcedo.mathdrill.mathdrill {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires lombok;
    requires jbcrypt;
    requires junit;
    requires hamcrest.core;
    requires org.testng;
    requires annotations;
    exports ph.jsalcedo.mathdrill.mathdrill.db;
    exports ph.jsalcedo.mathdrill.mathdrill.Test to junit;
    opens ph.jsalcedo.mathdrill.mathdrill.db to javafx.fxml;
}