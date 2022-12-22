package ph.jsalcedo.mathdrill.mathdrill.controllers;

import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.action.Action;
import ph.jsalcedo.mathdrill.mathdrill.Util.Encryption;
import ph.jsalcedo.mathdrill.mathdrill.Util.ProgramUtility;
import ph.jsalcedo.mathdrill.mathdrill.db.DataBase;
import ph.jsalcedo.mathdrill.mathdrill.model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartMenuController implements Initializable {
    @FXML
    private Button gotoLoginBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField loginPF;

    @FXML
    private AnchorPane loginPane;

    @FXML
    private Button newAccountBtn;

    @FXML
    private PasswordField pwRegPF;

    @FXML
    private Button registerBtn;

    @FXML
    private AnchorPane registratrationPane;

    @FXML
    private TextField userRegTF;

    @FXML
    private TextField userTF;

    @FXML
    private PasswordField verifyPWPF;

    @FXML
    void handLoginBtn(ActionEvent event) {
        if(DataBase.doesItExists(userTF.getText(), "users", "username")){
            if(Encryption.checkPass(loginPF.getText(), userTF.getText())) {
                ProgramUtility.alertMessage("Log in Success!", Alert.AlertType.INFORMATION);
                proceedMainMenu(userTF.getText(), event);

            }else {
                ProgramUtility.alertMessage("Incorrect user/pass!", Alert.AlertType.ERROR);
            }
        }else {
            ProgramUtility.alertMessage("username not found!", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void handleNewAccountBtn(ActionEvent event) {
        System.out.println("Button Clicked!");
        registratrationPane.setVisible(true);
        goToRegister();
    }

    @FXML
    void handleRegBtn(ActionEvent event) {
        String userName = userRegTF.getText();
        String pass = pwRegPF.getText();
        User user = new User(userName, pass);
        if(DataBase.addUser(user)) {
            ProgramUtility.alertMessage("Registration complete!", Alert.AlertType.INFORMATION);
            user.setRatings(ProgramUtility.generateNewRatings(user.getUserID()));
        }


    }

    @FXML
    void handlegotoLogin(ActionEvent event) {
        System.out.println("Button Clicked!");
        goToLogIn();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            registratrationPane.setVisible(false);
            loginBtn.disableProperty().bind(userTF.textProperty().isEmpty().or(loginPF.textProperty().isEmpty()));
            registerBtn.disableProperty().bind(userRegTF.textProperty().isEmpty().or(pwRegPF.textProperty().isEmpty().or(verifyPWPF.textProperty().isEmpty().and(verifyPWPF.textProperty().isEqualTo(pwRegPF.getText())))));
    }

    public void goToRegister(){
        TranslateTransition t1 = new TranslateTransition();
        t1.setDuration(Duration.millis(400));
        t1.setToX(0);
        t1.setToY(-400);
        t1.setNode(loginPane);
        TranslateTransition t2 = new TranslateTransition();
        t2.setDuration(Duration.millis(400));
        t2.setFromX(0);
        t2.setFromY(400);
        t2.setToX(0);
        t2.setToY(0);
        t2.setNode(registratrationPane);
        ParallelTransition pt = new ParallelTransition(t1,t2);
        pt.play();
    }

    public void goToLogIn(){
        TranslateTransition t1 = new TranslateTransition();
        t1.setDuration(Duration.millis(200));
        t1.setToX(0);
        t1.setToY(-400);
        t1.setNode(registratrationPane);
        TranslateTransition t2 = new TranslateTransition();
        t2.setDuration(Duration.millis(200));
        t2.setFromX(0);
        t2.setFromY(400);
        t2.setToX(0);
        t2.setToY(0);
        t2.setNode(loginPane);
        ParallelTransition pt = new ParallelTransition(t1,t2);
        pt.play();
    }

    @FXML
    void handleClickAccountBtn(MouseEvent event) {

    }

    public void proceedMainMenu(String userName, ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/main-menu.fxml"));
        Parent menuParent = null;
        try {
            menuParent = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(menuParent);
        MainMenuController controller = loader.getController();
        controller.initData(DataBase.retrieveUser(userName));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}