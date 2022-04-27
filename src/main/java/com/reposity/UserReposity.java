package com.reposity;

import com.entity.Order;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class UserReposity {
    private final String wordListPath = "word_list.txt";
    public void addOrder(Order order) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("BIR");
        sheet.setColumnWidth(0, 4900);
        sheet.setColumnWidth(1, 4900);
        sheet.setColumnWidth(2, 50000);
        sheet.setColumnWidth(3, 5550);
        Row firstRow = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        /// Orqa fonga rang beradi
        // GREY_25_PERCENT.getIndex()  bu beriladigan  rang
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  // SOLID_FOREGROUND orqa fon degani
        // fondni create qilinyapti ->
        Font font = workbook.createFont();
        font.setFontName("Arial");  // bu sozni shrifti
        font.setFontHeightInPoints((short) 14);  // bu sozni razmeri
        //   font.setBold(true); // bu sozni jirniy qiladi
        style.setFont(font);
        Cell cell = null;

        cell = firstRow.createCell(0);
        cell.setCellValue("userId");
        cell.setCellStyle(style);

        cell = firstRow.createCell(1);
        cell.setCellValue("Food name");
        cell.setCellStyle(style);

        cell = firstRow.createCell(2);
        cell.setCellValue("count");
        cell.setCellStyle(style);

        cell = firstRow.createCell(3);
        cell.setCellValue("summa");
        cell.setCellStyle(style);

        int rowCount = 1, cellCount = 0;
        Row row = sheet.createRow(rowCount++);
        cell = row.createCell(0);
        cell.setCellValue(order.getUserID());

        cell = row.createCell(1);
        cell.setCellValue(order.getName());

        cell = row.createCell(2);
        cell.setCellValue(order.getAmount());

        cell = row.createCell(3);
        cell.setCellValue(order.getAmount() * order.getSumma());

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("userOrderList.xlsx");
            workbook.write(fileOutputStream);
            System.out.println("succes");
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Order> readerUserOrder(){
        List<Order> list = new LinkedList<>();

        try {
            FileInputStream file = new FileInputStream(new File("list.xlsx"));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            int count = 0;
            for (Row row : sheet) {
                if (count > 0) {
                    Order order = new Order();
                    order.setUserID(row.getCell(0).getStringCellValue());
                    order.setName(row.getCell(1).getStringCellValue());
                    order.setAmount((int)row.getCell(2).getNumericCellValue());
                    order.setSumma((double) row.getCell(3).getNumericCellValue());
                    list.add(order);
                }
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addWord(Order word) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(wordListPath, true));
            printWriter.print(word.getUserID());
            printWriter.print("#");
            printWriter.print(word.getName());
            printWriter.print("#");
            printWriter.print(word.getAmount());
            printWriter.print("#");
            printWriter.print(word.getSumma()*word.getAmount());
            printWriter.println();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getWordLIst() {
        List<Order> wordList = new LinkedList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(wordListPath));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] s = line.split("#");
                String word = s[0];
                String translate = s[1];
                String des = s[2];
                String sum = s[3];
                Order temp = new Order();
                temp.setUserID(word);
                temp.setName(translate);
                temp.setAmount(Integer.valueOf(des));
                temp.setSumma(Integer.valueOf(sum).doubleValue()/Integer.valueOf(des).doubleValue());
                wordList.add(temp);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordList;
    }

    public void deleteOrderExcel(String userId){

    }
}
