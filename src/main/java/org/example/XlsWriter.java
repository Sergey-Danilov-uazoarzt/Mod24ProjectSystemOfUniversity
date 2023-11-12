package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {

    private XlsWriter() {
    }

    public static void writeStatistics(List<Statistics> statistics, String filePath) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Statistics");

        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 11);
        font.setBold(true);
        CellStyle style = workbook.createCellStyle();
        style.setFont(font);

        int rowNumber = 0;
        Row titleRow = sheet.createRow(rowNumber++);
        Cell mainProfileCellTitle = titleRow.createCell(0);
        mainProfileCellTitle.setCellValue("Профиль обучения");
        mainProfileCellTitle.setCellStyle(style);
        Cell avgExamScoreCellTitle = titleRow.createCell(1);
        avgExamScoreCellTitle.setCellValue("Средний балл за экзамен");
        avgExamScoreCellTitle.setCellStyle(style);
        Cell quantityOfStudentsByProfileCellTitle = titleRow.createCell(2);
        quantityOfStudentsByProfileCellTitle.setCellValue("Количество студентов по профилю");
        quantityOfStudentsByProfileCellTitle.setCellStyle(style);
        Cell quantityOfUniversitiesByProfileCellTitle = titleRow.createCell(3);
        quantityOfUniversitiesByProfileCellTitle.setCellValue("Количество университетов по профилю");
        quantityOfUniversitiesByProfileCellTitle.setCellStyle(style);
        Cell fullNameCellTitle = titleRow.createCell(4);
        fullNameCellTitle.setCellValue("Названия университетов");
        fullNameCellTitle.setCellStyle(style);

        for (Statistics data : statistics) {
            Row row = sheet.createRow(rowNumber++);
            Cell mainProfileCell = row.createCell(0);
            mainProfileCell.setCellValue(data.getMainProfile().getProfileName());
            Cell avgExamScoreCell = row.createCell(1);
            avgExamScoreCell.setCellValue(data.getAvgExamScore());
            Cell quantityOfStudentsByProfileCell = row.createCell(2);
            quantityOfStudentsByProfileCell.setCellValue(data.getQuantityOfStudentsByProfile());
            Cell quantityOfUniversitiesByProfileCell = row.createCell(3);
            quantityOfUniversitiesByProfileCell.setCellValue(data.getQuantityOfUniversitiesByProfile());
            Cell fullNameCell = row.createCell(4);
            fullNameCell.setCellValue(data.getFullName());
        }

        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            workbook.write(fos);
            fos.close();
            workbook.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }

    }
}
