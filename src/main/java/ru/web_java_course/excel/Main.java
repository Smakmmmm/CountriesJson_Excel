package ru.web_java_course.excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(List.of(
                new Person(12, "Filov", "Artur", "2134422"),
                new Person(22, "Binov", "Kirill", "2145511")
        ));

        try (HSSFWorkbook workbook = new HSSFWorkbook()) {
            HSSFSheet s = workbook.createSheet("Sheet1");
            HSSFRow r;
            HSSFCell c;

            HSSFCellStyle cs1 = workbook.createCellStyle();
            HSSFCellStyle cs2 = workbook.createCellStyle();

            HSSFFont f1 = workbook.createFont();
            f1.setFontHeightInPoints((short) 12);
            f1.setBold(true);

            HSSFFont f2 = workbook.createFont();
            f2.setFontHeightInPoints((short) 10);
            f2.setBold(true);

            cs1.setFont(f1);
            cs1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cs1.setFillForegroundColor(HSSFColor.HSSFColorPredefined.CORAL.getIndex());

            cs2.setFont(f2);
            cs2.setBorderBottom(BorderStyle.THICK);
            cs2.setBorderLeft(BorderStyle.THICK);
            cs2.setBorderRight(BorderStyle.THICK);
            cs2.setBorderTop(BorderStyle.THICK);

            workbook.setSheetName(0, "Persons");

            r = s.createRow(0);
            c = r.createCell(0);
            c.setCellStyle(cs1);
            c.setCellValue("Age");
            c = r.createCell(1);
            c.setCellStyle(cs1);
            c.setCellValue("First Name");
            c = r.createCell(2);
            c.setCellStyle(cs1);
            c.setCellValue("Last Name");
            c.setCellStyle(cs1);
            c = r.createCell(3);
            c.setCellStyle(cs1);
            c.setCellValue("Phone Number");
            s.setColumnWidth(0, 2000);
            s.setColumnWidth(1, 4000);
            s.setColumnWidth(2, 5000);
            s.setColumnWidth(3, 5000);

            for (int i = 0; i < persons.size(); i++) {
                r = s.createRow(i + 1);

                c = r.createCell(0);
                c.setCellStyle(cs2);
                c.setCellValue(persons.get(i).getAge());
                c = r.createCell(1);
                c.setCellStyle(cs2);
                c.setCellValue(persons.get(i).getFirstName());
                c = r.createCell(2);
                c.setCellStyle(cs2);
                c.setCellValue(persons.get(i).getLastName());
                c = r.createCell(3);
                c.setCellStyle(cs2);
                c.setCellValue(persons.get(i).getPhoneNumber());
            }

            try (FileOutputStream out = new FileOutputStream("persons.xls")) {
                workbook.write(out);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
