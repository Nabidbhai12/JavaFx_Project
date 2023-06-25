package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller2 {
    private Container main;
    void SetMain(Container main)
    {
        this.main=main;
    }
    @FXML
    private Button maximumsalary;

    @FXML
    private Button maximumAge;

    @FXML
    private Button maximumheight;

    @FXML
    private Button yearlysalary;

    @FXML
    private Button back;

    @FXML
    void Back(ActionEvent event) {
main.showHomepage();
    }

    @FXML
    void Maximumage(ActionEvent event) {
        main.Clubsearch2();

    }

    @FXML
    void Maximumheight(ActionEvent event) {
        main.Clubsearch3();

    }

    @FXML
    void Maximumsalary(ActionEvent event) {
        main.Clubsearch1();

    }

    @FXML
    void Yearlysalary(ActionEvent event) {
        main.Clubsearch4();

    }
}
