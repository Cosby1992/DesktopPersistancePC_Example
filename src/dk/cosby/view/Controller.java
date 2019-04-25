package dk.cosby.view;

import dk.cosby.model.FileUtils;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Controller {

    //Gui objects getting declared (initialized from the_modern_typewriter.fxml launched in Main)
    public TextField tf_input_text;
    public TextArea ta_textArea;
    public ImageView iv_saveButton;
    public ImageView iv_load_button;
    public ImageView iv_clear_button;


    /**
     * This method sends text from TextField to the TextArea if Enter is pressed
     * @param keyEvent from keyboard
     */
    public void sendInputTextToTextArea(KeyEvent keyEvent) {

        if(keyEvent.getCode().compareTo(KeyCode.ENTER) == 0 && !tf_input_text.getText().equalsIgnoreCase("")){
            ta_textArea.appendText(tf_input_text.getText() + "\n");
            tf_input_text.clear();
        }

    }


    /**
     * When save button is clicked text from TextArea is saved to a file on the desktop
     * @param mouseEvent from button click
     */
    public void saveFile(MouseEvent mouseEvent) {

        FileUtils fileUtils = new FileUtils();

        if(!ta_textArea.getText().equalsIgnoreCase("") && ta_textArea != null){
            fileUtils.writeToHDD(ta_textArea.getText());
        }
    }

    /**
     * When load button is clicked text from file on the desktop is read and displayed i the TextArea
     * @param mouseEvent
     */
    public void loadFile(MouseEvent mouseEvent) {

        FileUtils fileUtils = new FileUtils();

        ta_textArea.setText(fileUtils.readFromHDD());


    }

    /**
     * Clears the text in TextArea
     * @param mouseEvent from button click
     */
    public void clearTextArea(MouseEvent mouseEvent) {
        ta_textArea.clear();
    }

}
