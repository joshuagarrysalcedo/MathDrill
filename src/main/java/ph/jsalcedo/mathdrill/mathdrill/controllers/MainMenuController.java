package ph.jsalcedo.mathdrill.mathdrill.controllers;

import javafx.fxml.Initializable;
import ph.jsalcedo.mathdrill.mathdrill.model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    private User user;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initData(User user) {
        this.user = user;
    }
}
