package cs1302.api;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.geometry.Insets;

/**
 * REPLACE WITH NON-SHOUTING DESCRIPTION OF YOUR APP.
 */
public class ApiApp extends Application {
    Stage stage;
    Scene scene;
    VBox root;
    Separator sep;

    HBox topBox;
    ChoiceBox<String> choiceBox;
    Button goButton;

    VBox labelBox;
    Label topLabel;

    /**
     * Constructs an {@code ApiApp} object. This default (i.e., no argument)
     * constructor is executed in Step 2 of the JavaFX Application Life-Cycle.
     */
    public ApiApp() {
        root = new VBox();

        sep = new Separator();
        sep.setStyle("-fx-padding: 10px");

        topBox = new HBox(0);
        choiceBox = new ChoiceBox<>();
        choiceBox.setItems(FXCollections.observableArrayList(
            "AAPL", "MSFT", "GOOGL", "AMZN",
            "NVDA", "META", "BRK-A",
            "TSLA", "LLY", "V",
            "TSM", "UNH", "JPM",
            "WMT", "XOM", "AVGO",
            "MA", "JNJ", "NVO",
            "PG", "ORCL", "HD",
            "ADBE", "CVX", "ASML",
            "CSCO", "MRK", "KO", "TM",
            "ABBV", "SNY", "BAC", "PEP",
            "ANC", "CRM", "NFLX", "MCD",
            "NVS", "LIN", "AMD", "AZN",
            "BABA", "CSCO", "TMO", "INTC",
            "SAP", "ABT", "DIS", "TMUS",
            "PFE"));
        choiceBox.setValue("AAPL");
        choiceBox.setPrefSize(500, 0);
        goButton = new Button("Go!");
        goButton.setPrefSize(200, 0);
        goButton.setOnAction(e -> handleGoButton());

        topBox.getChildren().addAll(choiceBox, sep, goButton);

        labelBox = new VBox(0);
        topBox.setPadding(new Insets(10));
        topLabel = new Label("Choose a stock and then press Go! ");
        topLabel.setPadding(new Insets(8));
        labelBox.getChildren().addAll(topLabel);

        root.getChildren().addAll(topBox, labelBox);
    } // ApiApp

    /** {@inheritDoc} */
    @Override
    public void start(Stage stage) {

        this.stage = stage;

        // setup scene
        scene = new Scene(root, 600, 575);

        // setup stage
        stage.setTitle("ApiApp!");
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> Platform.exit());
        stage.sizeToScene();
        stage.show();
        stage.setResizable(true);
    } // start

    /**
     * Handles the {@code goButton} action.
     */
    public void handleGoButton() {
         String stock = choiceBox.getValue();
         topLabel.setText("Showing results for: $" + stock);
    } // handleGoButton

} // ApiApp
