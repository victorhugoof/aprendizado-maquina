module teste {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.com.victor.main to javafx.fxml;
    opens br.com.victor.views.main to javafx.fxml;
    exports br.com.victor.main;
    exports br.com.victor.views.main;
}