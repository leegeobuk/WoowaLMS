package woowa.lms.front.ui.form;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.component.textfield.InputField;
import woowa.lms.front.foolproof.FormFoolProof;

import java.util.List;

import static woowa.lms.front.behavior.BehaviorType.CLOSE_SIGN_UP;
import static woowa.lms.front.behavior.BehaviorType.SIGN_UP;
import static woowa.lms.front.component.image.ImageBuilder.*;
import static woowa.lms.front.component.textfield.InputType.PASSWORD;
import static woowa.lms.front.component.textfield.InputType.TEXT;
import static woowa.lms.front.foolproof.FoolProofType.*;

public class SignUpForm extends AbstractForm {

    private Label idLabel;
    private Label pwLabel;
    private Label confirmPwLabel;
    private Label nameLabel;
    private Label contactLabel;
    private InputField idInputField = InputField.of(TEXT, SIGN_UP_ID, "ID");
    private InputField pwInputField = InputField.of(PASSWORD, SIGN_UP_PW, "Password");
    private InputField confirmPwInputField = InputField.of(PASSWORD, SIGN_UP_CONFIRM_PW, "Confirm password");
    private InputField nameInputField = InputField.of(TEXT, NAME, "Name");
    private InputField contactInputField = InputField.of(TEXT, CONTACT, "Enter without -");

    public static final SignUpForm FORM = new SignUpForm(400, 450);

    private SignUpForm(double width, double height) {
        super(width, height);
        inputFields = List.of(idInputField, pwInputField,
            confirmPwInputField, nameInputField, contactInputField);
        setUpComponents();
        setUpPage();
        setFoolProof();
        setUpStage();
    }

    @Override
    public void setUpComponents() {
        background = BackgroundBuilder.DEFAULT_BACKGROUND.toBackground();

        headerLabel = LabelBuilder.getPageHeader("Sign Up");

        logoImageView = getLogo(imageWidth);


        idLabel = LabelBuilder.getFormLabel("Id");
        pwLabel = LabelBuilder.getFormLabel("Password");
        confirmPwLabel = LabelBuilder.getFormLabel("Confirm Password");
        nameLabel = LabelBuilder.getFormLabel("Name");
        contactLabel = LabelBuilder.getFormLabel("Contact");

        errorLabel = LabelBuilder.builder().textFill("red").build().toLabel();
        errorLabel.setWrapText(true);


        okButton = GeneralButton.getFormButton(FORM_BUTTON_OK, SIGN_UP);
        okButton.setDefaultButton(true);
        okButton.setDisable(true);

        cancelButton = GeneralButton.getFormButton(FORM_BUTTON_CANCEL, CLOSE_SIGN_UP);
        cancelButton.setCancelButton(true);
    }

    @Override
    public void setUpPage() {
        headerLabel.setGraphic(logoImageView);
        headerLabel.setGraphicTextGap(this.getWidth() * 0.05);

        form.addRow(0, idLabel, idInputField.toTextField());
        form.addRow(1, pwLabel, pwInputField.toTextField());
        form.addRow(2, confirmPwLabel, confirmPwInputField.toTextField());
        form.addRow(3, nameLabel, nameInputField.toTextField());
        form.addRow(4, contactLabel, contactInputField.toTextField());
        form.add(errorLabel, 0, 5, 2, 4);
        form.setHgap(this.getWidth() * 0.08);
        form.setVgap(this.getHeight() * 0.02);
        form.setAlignment(Pos.CENTER);

        buttonBox.getChildren().addAll(okButton, cancelButton);
        buttonBox.setAlignment(Pos.CENTER);

        mainPane.setBackground(background);
        mainPane.getChildren().addAll(headerLabel, form, buttonBox);
        mainPane.setPadding(new Insets(20));
        mainPane.setAlignment(Pos.TOP_CENTER);
        mainPane.setSpacing(this.getHeight() * 0.06);
    }

    @Override
    public void setFoolProof() {
        confirmPwInputField.setPasswordField(pwInputField);

        FormFoolProof formFoolProof = FormFoolProof.builder().button(okButton)
            .errorLabel(errorLabel).inputFields(inputFields).build();
        inputFields.forEach(inputField -> inputField.setOnKeyReleased(formFoolProof));
    }

    @Override
    public void setUpStage() {
        super.setUpStage();
        this.setTitle("Sign Up");
    }
}
