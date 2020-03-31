package woowa.lms.front.ui.form;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import woowa.lms.front.component.textfield.InputField;
import woowa.lms.front.ui.FoolProofable;
import woowa.lms.front.ui.page.Page;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractForm extends Stage implements Page, FoolProofable {

    protected VBox mainPane;
    protected Background background;

    protected Label headerLabel;
    protected ImageView logoImageView;

    protected GridPane form;
    protected List<InputField> inputFields;
    protected Label errorLabel;

    protected HBox buttonBox;
    protected Button okButton;
    protected Button cancelButton;

    protected double imageWidth;

    protected AbstractForm(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        mainPane = new VBox();
        mainPane.setSpacing(height * 0.05);

        form = new GridPane();
        errorLabel = new Label();

        buttonBox = new HBox(10);

        imageWidth = width * 0.16;
    }

    public void clear() {
        inputFields.forEach(InputField::clear);
        errorLabel.setText("");
        okButton.setDisable(true);
    }

    public List<TextField> getFields() {
        return inputFields.stream().map(InputField::getTextField)
            .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public abstract void setUpComponents();

    @Override
    public abstract void setUpPage();

    @Override
    public abstract void setFoolProof();

    @Override
    public void setUpStage() {
        Scene scene = new Scene(mainPane);
        this.setScene(scene);
        this.setResizable(false);
    }
}