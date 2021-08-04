package by.byportal.webcontroller.filessaweready;

import by.byportal.model.Employee;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.FileOutputStream;
import java.io.IOException;

public class SaveFileExcel {
    public static void saveFile(Employee[] pageList) {
        Workbook wb = new HSSFWorkbook(); //создали книгу
        Sheet sheet0 = wb.createSheet("Superlist"); //создали страницу

        Row row = sheet0.createRow(3); //создаем строку, указываем номер
        Cell cell = row.createCell(4); //создаем столбец, указываем номер
        cell.setCellValue("Hello");//записываем в строку row столбец cell текст

        Sheet sheet1 = wb.createSheet("Superlist1"); //создали страницу
        Row row1 = sheet1.createRow(0); //создаем строку, указываем номер
        Cell cell1 = row1.createCell(0); //создаем столбец, указываем номер
        cell1.setCellValue("Русский текст");
        Cell cell2 = row1.createCell(3); //создаем столбец, указываем номер 3 (4)
        cell2.setCellValue("Русский текст в четвертом столбце но в той же строке");

        Row row2 = sheet1.createRow(1); //создаем строку, указываем номер
        Cell cell3 = row2.createCell(3); //создаем столбец, указываем номер
        cell3.setCellValue("Русский текст");

        Sheet sheet2 = wb.createSheet("Superlist2"); //создали страницу

        Sheet sheet3 = wb.createSheet(WorkbookUtil.createSafeSheetName("$%^^&&") ); //создали страницу

        try {
            FileOutputStream fos = new FileOutputStream("c:/myExcelFile.xls"); //создаем имя файла
            wb.write(fos);//сохраняем файл
            fos.close();//закрываем поток
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
