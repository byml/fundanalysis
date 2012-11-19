package byml.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class T3 {
	public static final String _ROW = "{_row}";
	public static final String _COL = "{_col}";

	public void k(String fileName, String fomulaTemplate, String fromPos,
			String toPos) {
		k(fileName, fileName, fomulaTemplate, fromPos, toPos);
	}

	public void k(String fromFileName, String toFilName, String fomulaTemplate,
			String fromPos, String toPos) {
		InputStream inp = null;
		FileOutputStream fileOut = null;
		try {
			inp = new FileInputStream(fromFileName);
			Workbook wb = WorkbookFactory.create(inp);
			Sheet sheet = wb.getSheetAt(0);
			toS2(sheet, fomulaTemplate, fromPos, toPos);

			// Write the output to a file
			fileOut = new FileOutputStream(toFilName);
			wb.write(fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} finally {
			try {

				if (inp != null) {
					inp.close();
				}
				if (fileOut != null) {
					fileOut.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * 
	 * @param sheet
	 * @param fomulaTemplate
	 * @param fromPos
	 * @param toPos
	 */
	public void toS2(Sheet sheet, String fomulaTemplate, String fromPos,
			String toPos) {
		String fromRowName = getRowName(fromPos);
		String fromColName = getColName(fromPos);
		String toRowName = getRowName(toPos);
		String toColName = getColName(toPos);
		int fromRow = toRowNum(fromRowName);
		int fromCol = toColNum(fromColName);
		int toRow = toRowNum(toRowName);
		int toCol = toColNum(toColName);

		if (fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0) {
			return;
		} else {
			int top = Math.min(fromRow, toRow);
			int button = Math.max(fromRow, toRow);
			int left = Math.min(fromCol, toCol);
			int right = Math.max(fromCol, toCol);
			for (int i = top; i <= button; i++) {
				Row row = sheet.getRow(i);
				if (row == null) {
					row = sheet.createRow(i);
				}
				for (int j = left; j <= right; j++) {
					Cell cell = row.getCell(j);
					if (cell == null) {
						cell = row.createCell(j);
					}
					cell.setCellType(Cell.CELL_TYPE_FORMULA);
					cell.setCellFormula(toS(fomulaTemplate, i, j));
				}
			}
		}
	}

	public String toS(String fomulaTemplate, String rowName, String colName) {
		return StringUtils.replaceEach(fomulaTemplate, new String[] { _ROW,
				_COL }, new String[] { rowName, colName });
	}

	public String toS(String fomulaTemplate, int rowNum, int colNumber) {
		return toS(fomulaTemplate, toRowName(rowNum), toColName(colNumber));
	}

	public String getRowName(String pos) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < pos.length(); i++) {
			char c = pos.charAt(i);
			if (c >= '0' && c <= '9') {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public String getColName(String pos) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < pos.length(); i++) {
			char c = pos.charAt(i);
			if (c >= '0' && c <= '9') {
				break;
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public int toRowNum(String rowName) {
		return Integer.parseInt(rowName) - 1;
	}

	public int toColNum(String colName) {
		if (colName.length() == 1) {
			return toColNum(colName.charAt(0)) - 1;
		} else if (colName.length() == 2) {
			return toColNum(colName.charAt(0)) * 26
					+ toColNum(colName.charAt(1)) - 1;
		} else if (colName.length() == 3) {
			return toColNum(colName.charAt(0)) * 26 * 26
					+ toColNum(colName.charAt(1)) * 26
					+ toColNum(colName.charAt(2)) - 1;
		} else {
			return -1;
		}
	}

	public int toColNum(char c) {
		if (c >= 'A' && c <= 'Z') {
			return c - 'A' + 1;
		} else if (c >= 'a' && c <= 'z') {
			return c - 'a' + 1;
		} else {
			return -1;
		}
	}

	public String toColName(int colNum) {
		if (colNum < 26) {
			return "" + (char) ('A' + colNum);
		} else if (colNum < 26 + 26 * 26) {
			return toColName(colNum / 26 - 1) + toColName(colNum % 26);
		} else {
			return toColName(colNum / (26 * 26) - 1)
					+ toColName(colNum % (26 * 26));
		}
	}

	public String toRowName(int rowNum) {
		return String.valueOf(rowNum + 1);
	}

	public static void main(String[] args) {
		String fromFileName = "F:\\doc\\分级基金\\无固定期限\\约定收益随银行存款利率浮动-无固定期限分级基金优先份额-投资分析.xls";
		String toFilName = "F:\\doc\\分级基金\\无固定期限\\约定收益随银行存款利率浮动-无固定期限分级基金优先份额-投资分析5.xls";
		String fomulaTemplate = "IF(B1<=E{_row},(J{_row}+F9/{_col}11*C4)/POWER(1+{_col}11,(F{_row}-B1+1)/365),\"ERROR\")";
		String fromPos = "K12";
		String toPos = "W30";

		T3 t = new T3();
		t.k(fromFileName, toFilName, fomulaTemplate, fromPos, toPos);
	}
}
