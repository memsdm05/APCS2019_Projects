package Unit2.Converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * The type Controller.
 */
public class Controller {
    /**
     * BaseConverter Object
     */
    BaseConverter conv = new BaseConverter();
    /**
     * Stage object for FileChooser
     */
    Stage stage = new Stage();
    /**
     * The Input file.
     */
    String inputFile = "";
    /**
     * The Output directory.
     */
    String outputDir = "";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label input_file;

    @FXML
    private Label output_file;

    @FXML
    private TextField input_number;

    @FXML
    private TextField input_base;

    @FXML
    private TextField output_base;

    @FXML
    private Label num;

    @FXML
    private Button r;

    @FXML
    private Label rand_num;

    @FXML
    private Label rand_base;

    private static int randHelper(int min, int max) {
        return min + (int)(Math.random()*(max+1-min));
    }

    /**
     * Converts the file
     *
     * @param event the event
     */
    @FXML
    void file_convert(ActionEvent event) {
        if (!(inputFile.equals("") && outputDir.equals(""))) {
            try {
                PrintStream ps = new PrintStream(outputDir + "/converted.dat");
                Scanner scanner = new Scanner(new File(inputFile));

                while (scanner.hasNextLine()) {
                    String[] l = scanner.nextLine().split("\t");

                    if (Integer.parseInt(l[1]) < 2 || Integer.parseInt(l[1]) > 16) {
                        System.out.printf("Invalid input base %s\n", l[1]);
                        continue;
                    }
                    if (Integer.parseInt(l[2]) < 2 || Integer.parseInt(l[2]) > 16) {
                        System.out.printf("Invalid output base %s\n", l[2]);
                        continue;
                    }

                    String converted = conv.intToStr(conv.strToInt(l[0], l[1]), Integer.parseInt(l[2]));
                    System.out.printf("%s base %s = %s base %s\n", l[0], l[1], converted, l[2]);
                    ps.printf("%s\t%s\t%s\t%s\n", l[0], l[1], converted, l[2]);

                }
                scanner.close();
                ps.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    /**
     * I honestly forgot what this does, I'm sorry. Hahah just kidding um i think
     * its something to do with the number converter
     *
     * @param event the event
     */
    @FXML
    void num_convert(ActionEvent event) {
        try {
            String in_num = input_number.getText().toUpperCase();
            String in_base = input_base.getText();
            int out_base = Integer.parseInt(output_base.getText());

            if (Integer.parseInt(in_base) < 2 || Integer.parseInt(in_base) > 16 || out_base < 2 || out_base > 16)
                num.setText("error");
            else
                num.setText(conv.intToStr(conv.strToInt(in_num, in_base), out_base));
        }
        catch (Exception e) {
            num.setText("error");
        }
    }

    /**
     * Clear.
     *
     * @param event the event
     */
    @FXML
    void clear(ActionEvent event) {
        input_number.clear();
        input_base.clear();
        output_base.clear();
    }

    /**
     * Random.
     *
     * @param event the event
     */
    @FXML
    void random(ActionEvent event) {
        int rnum = randHelper(2, 16);
        rand_base.setText(String.valueOf(rnum));
        rand_num.setText(conv.intToStr(randHelper(2, 500), rnum));
    }

    /**
     * Drag method when mouse is over
     *
     * @param event the event
     */
    @FXML
    void fileInOver(DragEvent event) {

        if (event.getDragboard().hasFiles() ) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
    }

    /**
     * Drag method when mouse has dropped
     *
     * @param event the event
     */
    @FXML
    void fileInDrop (DragEvent event) {
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            String s1 = db.getFiles().toString();
            String[] s = s1.substring(1, s1.length()-1).split("/");
            inputFile = s1.substring(1, s1.length()-1);
            input_file.setText(s[s.length-1]);
            success = true;
        }
        event.setDropCompleted(success);
        event.consume();

    }

    /**
     * Drag method when mouse is over
     *
     * @param event the event
     */
    @FXML
    void fileOutOver(DragEvent event) {
        if (event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    /**
     * Drag method when mouse has dropped
     *
     * @param event the event
     */
    @FXML
    void fileOutDrop (DragEvent event) {
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            String s1 = db.getFiles().toString();
            String[] s = s1.substring(1, s1.length()-1).split("/");
            if (s[s.length-1].split(".").length > 1) {
                outputDir = s1.substring(1, s1.length()-1);
                output_file.setText(s[s.length-1]);
                success = true;
            }
            else {
                outputDir = "";
                System.out.println("here");
            }
        }
        event.setDropCompleted(success);
        event.consume();

    }

    /**
     * Filechooser
     *
     * @param event the event
     */
    @FXML
    void fileInChoose (MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Input File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Valid Files", "*.txt", "*.dat"));
        inputFile = fileChooser.showOpenDialog(stage).toString();
        System.out.println(inputFile);
        String[] temp = inputFile.split("/");
        input_file.setText(temp[temp.length-1]);
        event.consume();
    }

    /**
     * Directory Chooser
     *
     * @param event the event
     */
    @FXML
    void fileOutChoose (MouseEvent event) {
        DirectoryChooser dirChooser = new DirectoryChooser();
        dirChooser.setTitle("Directory where converted.dat is saved");
        outputDir = dirChooser.showDialog(stage).toString();
        System.out.println(outputDir);
        String[] temp = outputDir.split("/");
        output_file.setText(temp[temp.length-1]);
    event.consume();
}

    /**
     * Initialize.
     */
    @FXML
    void initialize() {
        r.fire();
        input_file.setText("Drag & Drop or Choose File");
        output_file.setText("Drag & Drop or Choose Folder");
        num.setText("");
    }
}
