package utils.exceptions;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class WriteExcel {

    private static Logger log = Logger.getLogger(WriteExcel.class);

    private String outputFileName;
    private WritableWorkbook writableWorkbook;
    private int currentRow = 0;

    public WriteExcel(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public void openWorkBook() {
        if (writableWorkbook == null) {
            try {
                File file = new File(outputFileName);
                WorkbookSettings wbSettings = new WorkbookSettings();
                wbSettings.setLocale(new Locale("en", "EN"));
                writableWorkbook = Workbook.createWorkbook(file, wbSettings);
                writableWorkbook.createSheet("Error Report", 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void writeHeaderRow(String[] rowHeaders) throws WriteException {
        WritableSheet excelSheet = writableWorkbook.getSheet(0);
        for (int i = 0; i < rowHeaders.length; i++) {
            writeCell(excelSheet, i, 0, rowHeaders[i]);
        }
        currentRow++;
    }
    public void writeHeaderRow(List<String> rowHeaders) throws WriteException {
        WritableSheet excelSheet = writableWorkbook.getSheet(0);
        for (int i = 0; i < rowHeaders.size(); i++) {
            writeCell(excelSheet, i, 0, rowHeaders.get(i));
        }
        currentRow++;
    }

    public void writeContent(String[] content) throws WriteException {
        WritableSheet excelSheet = writableWorkbook.getSheet(0);
        // add a row of content spanning a number of columns
        for (int i = 0; i < content.length; i++) {
            //Excel report fails with more than 32767 characters in one cell
            if (content[i] != null && content[i].length() > 32767) {
                content[i] = content[i].substring(0, 32000);
            }
            writeCell(excelSheet, i, currentRow, content[i]);
        }
        currentRow++;
    }

    private void writeCell(WritableSheet sheet, int column, int row, String s) throws WriteException {
        Label label;
        label = new Label(column, row, s);
        sheet.addCell(label);
    }

    public void close() throws WriteException, IOException {
        if (writableWorkbook != null) {
            writableWorkbook.close();
        }
    }

    public void write() throws WriteException, IOException {
        if (writableWorkbook != null) {
            writableWorkbook.write();
        }
    }

}

