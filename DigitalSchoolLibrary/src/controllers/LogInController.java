package controllers;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.*;

import dao.UserDAOImp;
import database.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;



public class LogInController {
	
	@FXML
	private Button CancelButton;
	@FXML
	private Label loginMessageLabel;
	@FXML
	private TextField usernameTextField;
	@FXML
	private PasswordField passwordTextField;
	@FXML
	private Label RegisterLabel;
	@FXML
	private Label XLabel;
	
	Connection conn = null;
	
	@FXML
	public void XLabelClick(MouseEvent event) {
		Stage stage = (Stage) XLabel.getScene().getWindow();
		stage.close();
	}
		
	@FXML
	public void cancelButtonAction(ActionEvent event) {
		Stage stage = (Stage) CancelButton.getScene().getWindow();
		stage.close();

	}
	
	@FXML
	public void OpenRegisterForm(MouseEvent event) {
		try {
			Stage stage = (Stage) RegisterLabel.getScene().getWindow();
			stage.close();
			Parent root = FXMLLoader.load(getClass().getResource("/views/Register.fxml"));
			Stage registerScene = new Stage();
			registerScene.initStyle(StageStyle.UNDECORATED);
			registerScene.setScene(new Scene(root, 432, 605));
			registerScene.show();
			registerScene.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
	
	
	
	@FXML
	private void SignIn(ActionEvent event) throws Exception{
		
		
		
		if(usernameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false) {
			
			UserDAOImp dao = new UserDAOImp();
			
			if(dao.login(usernameTextField.getText(), passwordTextField.getText())){
				
				Stage stage = (Stage) XLabel.getScene().getWindow();
				stage.close();
				Parent root = FXMLLoader.load(getClass().getResource("/views/Dashboard.fxml"));
				Stage dashboardStage = new Stage();
				dashboardStage.setScene(new Scene(root,800,600));
				dashboardStage.show();
				
			}else {
				
				loginMessageLabel.setTextFill(Color.web("#ff0000"));
				loginMessageLabel.setText("Invalid username or password!!!");
				
			}
			
		
		}
		else {
			loginMessageLabel.setTextFill(Color.web("#ff0000"));
			loginMessageLabel.setText("Please type your username and password.");
		}
	
	}
	
}
