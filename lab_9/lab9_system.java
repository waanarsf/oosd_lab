import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class lab9_system extends Application {

    // Updated references from 'Room' to 'lab9_room'
    private TableView<lab9_room> table = new TableView<>();
    private ObservableList<lab9_room> roomData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hotel Management System");

        // --- UI COMPONENTS ---
        TextField roomNumField = new TextField();
        roomNumField.setPromptText("Room #");
        
        ComboBox<String> typeCombo = new ComboBox<>();
        typeCombo.getItems().addAll("Single", "Double", "Deluxe");
        typeCombo.setPromptText("Type");
        
        TextField priceField = new TextField();
        priceField.setPromptText("Price");
        
        TextField custNameField = new TextField();
        custNameField.setPromptText("Guest Name");

        // --- TABLE SETUP ---
        TableColumn<lab9_room, String> colNum = new TableColumn<>("Room #");
        colNum.setCellValueFactory(d -> d.getValue().roomNumberProperty());

        TableColumn<lab9_room, String> colType = new TableColumn<>("Type");
        colType.setCellValueFactory(d -> d.getValue().roomTypeProperty());

        TableColumn<lab9_room, Number> colPrice = new TableColumn<>("Price");
        colPrice.setCellValueFactory(d -> d.getValue().priceProperty());

        TableColumn<lab9_room, Boolean> colStatus = new TableColumn<>("Available");
        colStatus.setCellValueFactory(d -> d.getValue().isAvailableProperty());

        table.getColumns().addAll(colNum, colType, colPrice, colStatus);
        
        // Wrapping list in FilteredList to support "Show Available Only"
        FilteredList<lab9_room> filteredData = new FilteredList<>(roomData, p -> true);
        table.setItems(filteredData);

        // --- LAYOUT ---
        GridPane form = new GridPane();
        form.setHgap(10); form.setVgap(10); form.setPadding(new Insets(15));
        form.addRow(0, new Label("Room:"), roomNumField, new Label("Guest:"), custNameField);
        form.addRow(1, new Label("Type:"), typeCombo, new Label("Price:"), priceField);

        CheckBox showOnlyAvailable = new CheckBox("Show Available Only");
        showOnlyAvailable.setOnAction(e -> {
            if (showOnlyAvailable.isSelected()) {
                filteredData.setPredicate(lab9_room::isAvailable);
            } else {
                filteredData.setPredicate(room -> true);
            }
        });

        Button addBtn = new Button("Add Room");
        Button bookBtn = new Button("Book Selected");
        Button checkoutBtn = new Button("Checkout");
        HBox btnBox = new HBox(10, addBtn, bookBtn, checkoutBtn, showOnlyAvailable);
        btnBox.setPadding(new Insets(10));

        // --- EVENT HANDLERS ---
        addBtn.setOnAction(e -> {
            try {
                if(typeCombo.getValue() == null) throw new Exception();
                // Calling the 'lab9_room' constructor
                roomData.add(new lab9_room(roomNumField.getText(), typeCombo.getValue(), Double.parseDouble(priceField.getText())));
                clearFields(roomNumField, priceField);
            } catch (Exception ex) {
                showAlert("Input Error", "Provide valid number, type, and price.");
            }
        });

        bookBtn.setOnAction(e -> {
            lab9_room selected = table.getSelectionModel().getSelectedItem();
            if (selected != null && selected.isAvailable()) {
                if (custNameField.getText().trim().isEmpty()) {
                    showAlert("Error", "Enter Guest Name.");
                    return;
                }
                selected.setAvailable(false);
                table.refresh();
                showAlert("Confirmed", "Room " + selected.getRoomNumber() + " booked.");
                custNameField.clear();
            } else {
                showAlert("Error", "Room unavailable or not selected.");
            }
        });

        checkoutBtn.setOnAction(e -> {
            lab9_room selected = table.getSelectionModel().getSelectedItem();
            if (selected != null && !selected.isAvailable()) {
                selected.setAvailable(true);
                table.refresh();
                showAlert("Success", "Room " + selected.getRoomNumber() + " is now vacant.");
            }
        });

        VBox root = new VBox(form, btnBox, table);
        VBox.setVgrow(table, Priority.ALWAYS);
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }

    private void clearFields(TextField... fields) {
        for (TextField f : fields) f.clear();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void main(String[] args) { launch(args); }
}