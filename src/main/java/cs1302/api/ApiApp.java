package cs1302.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javafx.application.Application;
import javafx.application.Platform;
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
import javafx.scene.control.ScrollPane;

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

    VBox mainBox;
    HBox peersAndLastBox;
    HBox peersBox;
    Label peersLabel;
    HBox lastTradeBox;
    Label lastTradeLabel;
    HBox stockName;
    Label stockNameLabel;
    HBox newsBox;
    Label newsLabel;

    ScrollPane scrollPane;

    private final StockInfo infoGetter = new StockInfo();


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
            "AAPL", "MSFT", "GOOGL", "AMZN", "NVDA", "META", "BRK-A", "TSLA", "LLY", "V",
            "TSM", "UNH", "JPM", "WMT", "XOM", "AVGO", "MA", "JNJ", "NVO", "PG", "ORCL", "HD",
            "ADBE", "CVX", "ASML", "CSCO", "MRK", "KO", "TM", "ABBV", "SNY", "BAC", "PEP",
            "ANC", "CRM", "NFLX", "MCD", "NVS", "LIN", "AMD", "AZN", "BABA", "CSCO", "TMO", "INTC",
            "SAP", "ABT", "DIS", "TMUS", "PFE"));
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
        mainBox = new VBox();
        peersAndLastBox = new HBox();
        stockName = new HBox();
        stockNameLabel = new Label("Stock Name: ");
        stockName.setPrefHeight(300);
        stockName.setPrefWidth(200);
        stockName.setStyle("-fx-background-color: #f6ad73");
        stockName.getChildren().add(stockNameLabel);
        lastTradeBox = new HBox();
        lastTradeLabel = new Label("Last Trade: ");
        lastTradeBox.setPrefHeight(300);
        lastTradeBox.setPrefWidth(200);
        lastTradeBox.setStyle("-fx-background-color: #b3eea6");
        lastTradeBox.getChildren().add(lastTradeLabel);
        peersBox = new HBox();
        peersLabel = new Label("Company Peers: ");
        peersBox.setPrefHeight(300);
        peersBox.setPrefWidth(200);
        peersBox.setStyle("-fx-background-color: #ff98fb");
        peersBox.getChildren().add(peersLabel);
        peersAndLastBox.getChildren().addAll(stockName, lastTradeBox, peersBox);
        newsBox = new HBox();
        newsLabel = new Label("News: ");
        newsBox.setFillHeight(true);
        newsBox.setMinHeight(300);
        newsBox.setPrefWidth(700);
        newsBox.setStyle("-fx-background-color: #a6caee");
        newsBox.getChildren().addAll(newsLabel);
        scrollPane = new ScrollPane(newsBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(200);
        scrollPane.setPrefWidth(300);

        mainBox.getChildren().addAll(peersAndLastBox, scrollPane);

        root.getChildren().addAll(topBox, labelBox, mainBox);
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

        String stockName = infoGetter.getStockName(stock);
        stockNameLabel.setText("Stock Name: \n" + stockName);
        stockNameLabel.setWrapText(true);

        getLastTrade(stock);
        getPeerCompanies(stock);
    } // handleGoButton

    /**
     * Gets the last trade information from the finage api.
     *
     * @param stock - the stock to get last trade information for
     */
    public void getLastTrade(String stock) {
        String API_KEY = "API_KEYa7FAUEDJ1OS3EAWT5FY7TP8LSTX782YV";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.finage.co.uk/last/stock/" +
            stock + "?apikey=" + API_KEY))
            .build();

        try {
            HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                String tradeData = response.body()
                    .replace("{", "")
                    .replace("}", "")
                    .replace(",", "\n");

                Platform.runLater(() -> {
                    lastTradeLabel.setText("Last Stock Quote: \n" + tradeData);
                    lastTradeLabel.setWrapText(true);
                });
            } else {
                lastTradeLabel.setText("HTTP error code: " + response.statusCode());
            } // else
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } // try
    } // getLastTrade

    /**
     * Gets the peer companies from the finnhub api.
     *
     * @param stock - the stock to get peer companies for
     */
    public void getPeerCompanies(String stock) {
        String API_KEY = "clj21tpr01qsgccbq250clj21tpr01qsgccbq25g";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://finnhub.io/api/v1/stock/peers?symbol=" +
            stock + "&token=" + API_KEY))
            .build();

        try {
            HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                String peersData = response.body()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", "\n");

                Platform.runLater(() -> {
                    peersLabel.setText("Company Peers: \n" + peersData);
                    peersLabel.setWrapText(true);
                });
            } else {
                peersLabel.setText("HTTP error code: " + response.statusCode());
            } // else
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } // try
    } // getPeerCompanies

} // ApiApp
