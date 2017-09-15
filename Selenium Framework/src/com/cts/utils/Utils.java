package com.cts.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {
	
	public static String getExcelData(String sheetName, String key) {
		String fileName = getProperty("fileName");
		String filePath = getProperty("filePath");

		//String filePath = "src\\test\\resources\\";
		String value = null;

		Workbook wb = null;

		File file = new File(filePath+fileName);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			if(fileName.substring(fileName.indexOf('.')).equals(".xlsx")) {

				wb = new XSSFWorkbook(fis);
			} 
			else {
				wb = new HSSFWorkbook(fis);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet(sheetName);
		Iterator<Row> iterator = sheet.iterator();
		while(iterator.hasNext()) {
			Row row = iterator.next();
			Iterator<Cell> cell = row.iterator();
			while(cell.hasNext()) {
				Cell currentCell = cell.next();
				if(currentCell.getStringCellValue().contains(key)) {
					currentCell=cell.next();
					value = currentCell.getStringCellValue();
					break;
				}
				break;
			}
		}
		return value;
	}

	public static String getProperty (String property) {
		String value =null;
		InputStream input =null;

		Properties prop = new Properties();

		try {
			input = new FileInputStream("resources\\config.properties");
			prop.load(input);
			if (input != null) {
				value = prop.getProperty(property);
				input.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}


}
