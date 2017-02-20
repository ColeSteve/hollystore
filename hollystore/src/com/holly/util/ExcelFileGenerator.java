package com.holly.util;

import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelFileGenerator {

	private final int SPLIT_COUNT = 1500; // Excelÿ��������������

	private ArrayList fieldName = null; // excel�������ݼ�(ArrayList���ŵ����ַ���)

	private ArrayList fieldData = null; // excel��������(ArrayList���ŵ���List����Ԫ��)

	private HSSFWorkbook workBook = null;

	/**
	 * ������
	 * 
	 * @param fieldName
	 *            ��������ֶ���
	 * @param data
	 */
	public ExcelFileGenerator(ArrayList fieldName, ArrayList fieldData) {

		this.fieldName = fieldName;
		this.fieldData = fieldData;
	}

	/**
	 * ����HSSFWorkbook����
	 * 
	 * @return HSSFWorkbook
	 */
	public HSSFWorkbook createWorkbook() {

		workBook = new HSSFWorkbook();
		int rows = fieldData.size();
		int sheetNum = 0;

		if (rows % SPLIT_COUNT == 0) {
			sheetNum = rows / SPLIT_COUNT;
		} else {
			sheetNum = rows / SPLIT_COUNT + 1;
		}

		for (int i = 1; i <= sheetNum; i++) {// ����sheet
			HSSFSheet sheet = workBook.createSheet("Page " + i);
			HSSFRow headRow = sheet.createRow((short) 0); // ����Row
			for (int j = 0; j < fieldName.size(); j++) {// ����Cell
				HSSFCell cell = headRow.createCell((short) j);
				// �����ʽ
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				// ��ֹ���ĸ�λ�ض�
				cell.setEncoding(HSSFCell.ENCODING_UTF_16);
				if (fieldName.get(j) != null) {
					cell.setCellValue((String) fieldName.get(j));
				} else {
					cell.setCellValue("-");
				}
			}

			for (int k = 0; k < (rows < SPLIT_COUNT ? rows : SPLIT_COUNT); k++) {
				HSSFRow row = sheet.createRow((short) (k + 1));
				// ���������ݷ���excel��Ԫ��filedData�ڴ�ŵ�Ϊ����Ԫ�أ����Կ���ת��ΪArrayList��
				ArrayList rowList = (ArrayList) fieldData.get((i - 1) * SPLIT_COUNT + k);
				for (int n = 0; n < rowList.size(); n++) {
					HSSFCell cell = row.createCell((short) n);
					cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					if (rowList.get(n) != null) {
						cell.setCellValue((String) rowList.get(n).toString());
					} else {
						cell.setCellValue("");
					}
				}
			}
		}
		return workBook;
	}

	public void expordExcel(OutputStream os) throws Exception {
		workBook = createWorkbook();
		workBook.write(os);
		os.close();
	}

}
