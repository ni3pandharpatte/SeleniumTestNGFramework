package seleniumtestngframeworkdesign.datahandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadExcelData {

    public static void main(String[] args) throws IOException {
//        File file = new File("C:\\Users\\vinitin\\eclipse-workspace-selenium\\SeleniumFrameworkDesign\\src\\main\\java\\data\\data.xlsx");
        FileInputStream fis = new FileInputStream("C:\\Users\\vinitin\\eclipse-workspace-selenium\\SeleniumFrameworkDesign\\src\\main\\java\\data\\data.xlsx");
        Workbook workbood = WorkbookFactory.create(fis);
        Sheet sheet = workbood.getSheet("login");
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(cell.getStringCellValue());
        }
}