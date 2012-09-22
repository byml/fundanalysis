package net.byml.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ImportExcelHelper {
	private static ImportExcelHelper instance;

	private ImportExcelHelper() {

	}

	public static ImportExcelHelper getInstance() {
		if (instance == null) {
			instance = new ImportExcelHelper();
		}
		return instance;
	}
	
	public List<Map> toMapList(String finaName,String sheetName, DataDefinitions definitions) {
		List mapList = null;
		InputStream is = null;
		try {
			is = new FileInputStream(finaName);
			Workbook wb = WorkbookFactory.create(is);
			Sheet sheet = wb.getSheet(sheetName);
			if(sheet!=null){
				mapList = toMapList(sheet, definitions);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return mapList;
	}

	public List<Map> toMapList(String finaName, DataDefinitions definitions) {
		List mapList = null;
		InputStream is = null;
		try {
			is = new FileInputStream(finaName);
			Workbook wb = WorkbookFactory.create(is);
			Sheet sheet = wb.getSheetAt(0);
			if(sheet!=null){
				mapList = toMapList(sheet, definitions);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return mapList;
	}

	public List<Map> toMapList(Sheet sheet, DataDefinitions definitions) {
		List<Map> list = new ArrayList<Map>();
		int lastRowNum = sheet.getLastRowNum();
		for (int i = 1; i <= lastRowNum; i++) {
			Row row = sheet.getRow(i);
			if(row!=null){
				Map map = toMap(row, definitions);
				list.add(map);
			}
		}
		return list;
	}

	public Map toMap(Row row, DataDefinitions definitions) {
		Map map = new HashMap();
		for (Iterator it = definitions.getDataDefinitionList().iterator(); it
				.hasNext();) {
			DataDefinition definition = (DataDefinition) it.next();
			Cell cell = row.getCell(definition.getPosition());
			if(cell!=null){
				map.put(definition.getKey(),
						toValue(cell, definition.getDataType()));
			}
		}
		return map;
	}

	public Object toValue(Cell cell, int dataType) {
		Object value = null;
		if (cell != null) {
			int cellType = cell.getCellType();
			if (Cell.CELL_TYPE_BLANK == cellType) {
				value = null;
			} else {
				if (DataType.STRING == dataType) {
					if (Cell.CELL_TYPE_BOOLEAN == cellType) {
						value = "" + cell.getBooleanCellValue();
					} else if (Cell.CELL_TYPE_ERROR == cellType) {
						value = "" + cell.getErrorCellValue();
					} else if (Cell.CELL_TYPE_FORMULA == cellType) {
						value = cell.getCellFormula();
					} else if (Cell.CELL_TYPE_NUMERIC == cellType) {
						value = cell.getNumericCellValue();
					} else if (Cell.CELL_TYPE_STRING == cellType) {
						value = cell.getStringCellValue();
					}
				} else if (DataType.DOUBLE == dataType) {
					if (Cell.CELL_TYPE_NUMERIC == cellType) {
						value = new Double(cell.getNumericCellValue());
					} else if (Cell.CELL_TYPE_STRING == cellType) {
						value = new Double(NumberUtils.toDouble(cell
								.getStringCellValue()));
					} else if (Cell.CELL_TYPE_FORMULA == cellType) {
						// TODO
					} else {

					}
				} else if (DataType.LONG == dataType) {
					if (Cell.CELL_TYPE_NUMERIC == cellType) {
						value = new Long(
								new Double(cell.getNumericCellValue())
										.longValue());
					} else if (Cell.CELL_TYPE_STRING == cellType) {
						value = new Long(new Double(NumberUtils.toDouble(cell
								.getStringCellValue())).longValue());
					} else if (Cell.CELL_TYPE_FORMULA == cellType) {
						// TODO
					} else {

					}
				} else if (DataType.INT == dataType) {
					if (Cell.CELL_TYPE_NUMERIC == cellType) {
						value = new Integer(new Double(
								cell.getNumericCellValue()).intValue());
					} else if (Cell.CELL_TYPE_STRING == cellType) {
						value = new Integer(
								new Double(NumberUtils.toDouble(cell
										.getStringCellValue())).intValue());
					} else if (Cell.CELL_TYPE_FORMULA == cellType) {
						// TODO
					} else {

					}
				} else if (DataType.DATE == dataType) {
					if (Cell.CELL_TYPE_NUMERIC == cellType) {
						value = new Integer(new Double(
								cell.getNumericCellValue()).intValue());
					} else if (Cell.CELL_TYPE_STRING == cellType) {
						try{
							value = DateUtils.parseDate(cell.getStringCellValue(),
									new String[] { "yyyy-MM-dd","yyyy/MM/dd" });
						}catch(Exception e){
							e.printStackTrace();
						}
						
					} else if (Cell.CELL_TYPE_FORMULA == cellType) {
						// TODO
					} else {

					}
				} else if (DataType.BOOLEAN == dataType) {
					if (Cell.CELL_TYPE_BOOLEAN == cellType) {

					} else if (Cell.CELL_TYPE_BOOLEAN == cellType) {

					} else {

					}
				} else {
					value = cell.toString();
				}
			}
		}
		return value;
	}
}
