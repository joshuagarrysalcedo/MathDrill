module ph.jsalcedo.mathdrill.mathdrill {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires annotations;
    requires lombok;
    requires jbcrypt;

    opens ph.jsalcedo.mathdrill.mathdrill to javafx.fxml;
    exports ph.jsalcedo.mathdrill.mathdrill;
    exports ph.jsalcedo.mathdrill.mathdrill.db;
    opens ph.jsalcedo.mathdrill.mathdrill.db to javafx.fxml;
}