package com.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils 
{

	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream fi;
	public static FileOutputStream fo;
	
public static String getCelldata(String xlfile,String xlsheet,int rowno,int colno) throws IOException
	{
	
		String data;
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rowno);
		cell=row.getCell(colno);
		data=cell.getStringCellValue();
		return data;
	}

public static int getrowcount(String xlfile,String xlsheet) throws IOException
{
	int rc;
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	rc=ws.getLastRowNum();
	return rc;
	
}

public static void writeCelldata(String xlfile,String xlsheet,int rowno,int colno,String data) throws IOException
{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rowno);
	row.createCell(colno).setCellValue(data);
	fo=new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
}

public static void fillGreencolor(String xlfile,String xlsheet,int rowno,int colono) throws IOException
{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rowno);
	
	CellStyle style=wb.createCellStyle();
	style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	row.getCell(colono).setCellStyle(style);
	fo= new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
	
}

public static void fillRedcolor(String xlfile,String xlsheet,int rowno,int colono) throws IOException
{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	row=ws.getRow(rowno);
	
	CellStyle style=wb.createCellStyle();
	style.setFillForegroundColor(IndexedColors.RED.getIndex());
	style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	row.getCell(colono).setCellStyle(style);
	fo= new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();

}

}
