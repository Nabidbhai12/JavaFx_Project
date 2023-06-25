package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class Controller1 {

    private Container main;

    void SetMain(Container main)
    {
        this.main=main;
    }

    @FXML
    private Button playername;

    @FXML
    private Button playerposition;

    @FXML
    private Button clubandcountry;

    @FXML
    private Button salaryrange;

    @FXML
    private Button countrywise;

    @FXML
    private Button exit;

    @FXML
    void ClubandCountry(ActionEvent event) {
        main.showPlayername2();

    }

    @FXML
    void CountryWise(ActionEvent event) {
        main.Showcountrysearch();

    }

    @FXML
    void Exit(ActionEvent event) {
        main.showHomepage();

    }

    @FXML
    void PlayerName(ActionEvent event) {
        main.showPlayername();


    }

    @FXML
    void PlayerPosition(ActionEvent event) {
        main.showPlayerposition();

    }

    @FXML
    void SalaryRange(ActionEvent event) {
        main.showsalary();

    }
}
