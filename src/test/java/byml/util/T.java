package byml.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class T {
	public static void main(String[] args) throws InvalidFormatException,
			IOException {
		InputStream inp = new FileInputStream("F:\\doc\\基金\\分级基金稳健份额.xls");
		// InputStream inp = new FileInputStream("workbook.xlsx");

		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = wb.getSheet("复利计算收益");
		for (int i = 4; i <= 20; i++) {
			Row row = sheet.getRow(i);
			if (row == null) {
				row = sheet.createRow(i);
			}
			for (int j = 8; j <= 19; j++) {
				Cell cell = row.getCell(j);
				if (cell == null) {
					cell = row.createCell(j);
				}
				StringBuffer sb = new StringBuffer();
				String colName = toColName(j);
				int rowName = i + 1;
				sb.append("C2*H");
				sb.append(rowName);
				sb.append("/");
				sb.append(colName);
				sb.append("2+(POWER(1+G");
				sb.append(rowName);
				sb.append(",(A2-D");
				sb.append(rowName);
				sb.append("+1)/366)-1)/POWER((1+");
				sb.append(colName);
				sb.append("2),(E");
				sb.append(rowName);
				sb.append("-A2+1)/366+(F");
				sb.append(rowName);
				sb.append("-E");
				sb.append(rowName);
				sb.append(")/365)*D2");
				System.out.println(sb.toString());
				// --------C2*H11/I2+(POWER(1+G11,(A2-D11+1)/366)-1)/POWER((1+I2),(E11-A2+1)/366+(F11-E11)/365)*D2;
				cell.setCellType(Cell.CELL_TYPE_FORMULA);
				cell.setCellFormula(sb.toString());
			}
		}

		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream(
				"F:\\doc\\基金\\分级基金稳健份额 2.xls");
		wb.write(fileOut);
		fileOut.close();

		for (int i = 0; i <= 26 * 30; i++) {
			System.out.println(toColName(i));
		}
	}

	private static String toColName(int colNum) {
		if (colNum < 26) {
			return "" + (char) ('A' + colNum);
		} else if (colNum < 26 + 26 * 26) {
			return toColName(colNum / 26 - 1) + toColName(colNum % 26);
		} else {
			return toColName(colNum / (26 * 26) - 1)
					+ toColName(colNum % (26 * 26));
		}
	}
}
