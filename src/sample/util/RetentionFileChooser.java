package sample.util;

import javafx.beans.property.SimpleObjectProperty;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author leetHuam
 * @version 1.0
 */
public class RetentionFileChooser {
    public enum FilterMode {
        //Setup supported filters
        C_FILES("C files (*.c)", "*.c"),
        XML_FILES("XML files (*.xml)", "*.xml"),
        BMP_FILES("BMP files (.bmp)", "*.bmp");

        private FileChooser.ExtensionFilter extensionFilter;

        FilterMode(String extensionDisplayName, String... extensions) {
            extensionFilter = new FileChooser.ExtensionFilter(extensionDisplayName, extensions);
        }

        public FileChooser.ExtensionFilter getExtensionFilter() {
            return extensionFilter;
        }
    }

    private static FileChooser instance = null;
    private static SimpleObjectProperty<File> lastKnownDirectoryProperty = new SimpleObjectProperty<>();

    private RetentionFileChooser() {
    }

    private static FileChooser getInstance(FilterMode... filterModes) {
        if (instance == null) {
            instance = new FileChooser();
        }
        //Set the filters to those provided
        //You could add check's to ensure that a default filter is included, adding it if need be
        instance.initialDirectoryProperty().bindBidirectional(lastKnownDirectoryProperty);
        instance.getExtensionFilters().setAll(
                Arrays.stream(filterModes)
                        .map(FilterMode::getExtensionFilter)
                        .collect(Collectors.toList()));
        return instance;
    }

    public static File showOpenDialog( String title, FilterMode... filterModes) {
        return showOpenDialog(null, title,filterModes);
    }

    public static File showOpenDialog(Window ownerWindow, String title, FilterMode... filterModes) {
        FileChooser instance = getInstance(filterModes);
        instance.setTitle(title);
        File chosenFile = getInstance(filterModes).showOpenDialog(ownerWindow);
        if (chosenFile != null) {
            lastKnownDirectoryProperty.setValue(chosenFile.getParentFile());
        }
        return chosenFile;
    }

    public static File showSaveDialog(FilterMode... filterModes) {
        return showSaveDialog(null, filterModes);
    }

    public static File showSaveDialog(Window ownerWindow, FilterMode... filterModes) {
        File chosenFile = getInstance(filterModes).showSaveDialog(ownerWindow);
        if (chosenFile != null) {
            lastKnownDirectoryProperty.setValue(chosenFile.getParentFile());
        }
        return chosenFile;
    }
}
