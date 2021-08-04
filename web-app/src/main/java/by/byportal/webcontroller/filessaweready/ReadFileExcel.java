package by.byportal.webcontroller.filessaweready;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.apache.poi.ss.usermodel.CellType.*;

public class ReadFileExcel {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

    public static List<String> readFile() {
        List<String> readFileEx = null;
        try {
            FileInputStream fis = new FileInputStream("C:/myExcelFile.xls");
            Workbook wb = new HSSFWorkbook(fis);// читаем в wb файл C:/myExcelFile.xls
            String result = wb.getSheetAt(0).getRow(1).getCell(2).getStringCellValue();
            // в переменную result считываем данные с 0 листа, 1(2) строки, 2(3) столбца
            String result1 = getCellText(wb.getSheetAt(0).getRow(2).getCell(2));
            // в переменную result считываем данные с 0 листа, 2(3) строки, 2(3) столбца и с помощью метода getSellText преобразовываем в текст

            for (Row row : wb.getSheetAt(0)){
                for (Cell cell : row) {
                    CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                    readFileEx.add(cellRef.formatAsString());
                    readFileEx.add(getCellText(cell));


                }
            }

            fis.close(); //закрываем поток
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readFileEx;

    }

    public static String getCellText (Cell cell) {
        String result = "";
        switch (cell.getCellType()) {
            case STRING:
                result = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    result = sdf.format(cell.getDateCellValue());
                } else {
                    result = Double.toString(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                result = Boolean.toString(cell.getBooleanCellValue());
                break;
            case FORMULA:
                result = (cell.getCellFormula()).toString();
                break;
            case BLANK:
                break;
            default:
                break;
        }
        return result;
    }

}
