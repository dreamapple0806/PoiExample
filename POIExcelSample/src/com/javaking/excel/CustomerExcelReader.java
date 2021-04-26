package com.javaking.excel;

import org.apache.log4j.Logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.javaking.vo.CustomerVo;

public class CustomerExcelReader {

	private static Logger log;
	/**
	 * XLS �����遺����� List<CustomerVo> 媛�껜濡�諛��
	 * @param filePath
	 * @return
	 */
	@SuppressWarnings("resource")
	public List<CustomerVo> xlsToCustomerVoList(String filePath) {
		
		// 諛����媛�껜瑜����
		List<CustomerVo> list = new ArrayList<CustomerVo>();
		
		FileInputStream fis = null;
		HSSFWorkbook workbook = null;
		
		try {
			
			fis= new FileInputStream(filePath);
			// HSSFWorkbook�������� ��껜 �댁����닿� ��� 媛�껜
			workbook = new HSSFWorkbook(fis);
			
			// ������ъ���Sheet, Row, Cell 媛�껜
			HSSFSheet curSheet;
			HSSFRow   curRow;
			HSSFCell  curCell;
			CustomerVo vo;
			
			// Sheet ��� for臾�
			for(int sheetIndex = 0 ; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				// ��� Sheet 諛��
				curSheet = workbook.getSheetAt(sheetIndex);
				// row ��� for臾�
				for(int rowIndex=0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
					// row 0���ㅻ���낫�닿린 ��Ц��臾댁�
					if(rowIndex != 0) {
						// ��� row 諛��
						curRow = curSheet.getRow(rowIndex);
						vo = new CustomerVo();
						String value;
						
						// row��泥ル�吏�cell媛�� 鍮����� ��� 寃쎌� 留�cell���
						if(!"".equals(curRow.getCell(0).getStringCellValue())) {
							
							// cell ��� for 臾�
							for(int cellIndex=0;cellIndex<curRow.getPhysicalNumberOfCells(); cellIndex++) {
								curCell = curRow.getCell(cellIndex);
								
								if(true) {
									value = "";
									// cell �ㅽ��쇱� �ㅻⅤ�����String�쇰� 諛�� 諛��
									switch (curCell.getCellType()){
					                case HSSFCell.CELL_TYPE_FORMULA:
					                	value = curCell.getCellFormula();
					                    break;
					                case HSSFCell.CELL_TYPE_NUMERIC:
					                	value = curCell.getNumericCellValue()+"";
					                    break;
					                case HSSFCell.CELL_TYPE_STRING:
					                    value = curCell.getStringCellValue()+"";
					                    break;
					                case HSSFCell.CELL_TYPE_BLANK:
					                    value = curCell.getBooleanCellValue()+"";
					                    break;
					                case HSSFCell.CELL_TYPE_ERROR:
					                    value = curCell.getErrorCellValue()+"";
					                    break;
					                default:
					                	value = new String();
										break;
					                }
									
									// ��� column index���곕���vo�����
									switch (cellIndex) {
									case 0: // �����
										vo.setCustId(value);;
										break;
										
									case 1: // �대�
										vo.setCustName(value);;
										break;
										
									case 2: // ���
										vo.setCustAge(value);
										break;
										
									case 3: // �대���
										vo.setCustEmail(value);
										break;
		
									default:
										break;
									}
								}
							}
							// cell ��� �댄� vo 異��
							list.add(vo);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			try {
				// �ъ��������finally��� �댁�
				if( workbook!= null) workbook.close();
				if( fis!= null) fis.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * XLSX �����遺����� List<CustomerVo> 媛�껜濡�諛��
	 * @param filePath
	 * @return
	 */
	public List<CustomerVo> xlsxToCustomerVoList(String filePath) {
		// 諛����媛�껜瑜����
		List<CustomerVo> list = new ArrayList<CustomerVo>();

		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		
		try {
			
			fis= new FileInputStream(filePath);
			// HSSFWorkbook�������� ��껜 �댁����닿� ��� 媛�껜
			workbook = new XSSFWorkbook(fis);
			
			// ������ъ���Sheet, Row, Cell 媛�껜
			XSSFSheet curSheet;
			XSSFRow   curRow;
			XSSFCell  curCell;
			CustomerVo vo;
			
			// Sheet ��� for臾�
			for(int sheetIndex = 0 ; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
				// ��� Sheet 諛��
				curSheet = workbook.getSheetAt(sheetIndex);
				// row ��� for臾�
				for(int rowIndex=0; rowIndex < curSheet.getPhysicalNumberOfRows(); rowIndex++) {
					// row 0���ㅻ���낫�닿린 ��Ц��臾댁�
					if(rowIndex != 0) {
						// ��� row 諛��
						curRow = curSheet.getRow(rowIndex);
						vo = new CustomerVo();
						String value;
						
						// row��泥ル�吏�cell媛�� 鍮����� ��� 寃쎌� 留�cell���
						if(!"".equals(curRow.getCell(0).getStringCellValue())) {
							
							// cell ��� for 臾�
							for(int cellIndex=0;cellIndex<curRow.getPhysicalNumberOfCells(); cellIndex++) {
								curCell = curRow.getCell(cellIndex);
								
								if(true) {
									value = "";
									// cell �ㅽ��쇱� �ㅻⅤ�����String�쇰� 諛�� 諛��
									switch (curCell.getCellType()){
					                case HSSFCell.CELL_TYPE_FORMULA:
					                	value = curCell.getCellFormula();
					                    break;
					                case HSSFCell.CELL_TYPE_NUMERIC:
					                	value = curCell.getNumericCellValue()+"";
					                    break;
					                case HSSFCell.CELL_TYPE_STRING:
					                    value = curCell.getStringCellValue()+"";
					                    break;
					                case HSSFCell.CELL_TYPE_BLANK:
					                    value = curCell.getBooleanCellValue()+"";
					                    break;
					                case HSSFCell.CELL_TYPE_ERROR:
					                    value = curCell.getErrorCellValue()+"";
					                    break;
					                default:
					                	value = new String();
										break;
					                }
									
									// ��� column index���곕���vo�����
									switch (cellIndex) {
									case 0: // �����
										vo.setCustId(value);;
										break;
										
									case 1: // �대�
										vo.setCustName(value);;
										break;
										
									case 2: // ���
										vo.setCustAge(value);
										break;
										
									case 3: // �대���
										vo.setCustEmail(value);
										break;
		
									default:
										break;
									}
								}
							}
							// cell ��� �댄� vo 異��
							list.add(vo);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			try {
				// �ъ��������finally��� �댁�
				if( workbook!= null) workbook.close();
				if( fis!= null) fis.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
}
