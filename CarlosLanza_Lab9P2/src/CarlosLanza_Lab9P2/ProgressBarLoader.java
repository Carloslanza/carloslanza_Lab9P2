package CarlosLanza_Lab9P2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;


public class ProgressBarLoader {

    private JProgressBar progress_bar;
    private JTextArea ta_archivo;
    private String filePath;

    public ProgressBarLoader(JProgressBar progress_bar, JTextArea ta_archivo) {
        this.progress_bar = progress_bar;
        this.ta_archivo = ta_archivo;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setProgressValue(int value) {
        progress_bar.setValue(value);
    }

    public int getProgressValue() {
        return progress_bar.getValue();
    }

    public boolean isFinished() {
        return progress_bar.getValue() == progress_bar.getMaximum();
    }

    public void startProgress(File selectedFile) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    progress_bar.setValue(i);
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                ta_archivo.setText("");
                try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        ta_archivo.setText(ta_archivo.getText() + line + "\n");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                progress_bar.setValue(100);
            }
        }).start();
    }
}
