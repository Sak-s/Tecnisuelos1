package com.example.tecnisuelos1.services.excelReports;

import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.example.tecnisuelos1.entity.Contador;

import jakarta.servlet.http.HttpServletResponse;

public class ContadorExcel {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Contador> contadorList;

    public ContadorExcel (List<Contador> contadorList) {
        this.contadorList = contadorList;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Clientes");
        Row titleRow1 = sheet.createRow(0);
        Row titleRow2 = sheet.createRow(1);

        CellStyle titleStyle = createCellStyle(IndexedColors.WHITE, IndexedColors.LIGHT_BLUE);
        titleStyle.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER);
        titleStyle.setFont(createFont("Arial", (short) 20, true));
        titleStyle.setBorderRight(org.apache.poi.ss.usermodel.BorderStyle.NONE); // Sin borde derecho
        titleStyle.setBorderLeft(org.apache.poi.ss.usermodel.BorderStyle.NONE); // Sin borde izquierdo
        titleRow1.setHeightInPoints(20);
        titleRow2.setHeightInPoints(20);

        createCell(titleRow1, 0, "Reporte Clientes", titleStyle);
        sheet.addMergedRegion(new org.apache.poi.ss.util.CellRangeAddress(0, 1, 0, 6)); // Fusiona las dos filas en el centro del título

        Row headerRow = sheet.createRow(2);
        headerRow.setHeightInPoints(30);

        CellStyle headerStyle = createCellStyle(IndexedColors.LIGHT_BLUE, IndexedColors.WHITE);
        headerStyle.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER);
        headerStyle.setFont(createFont("Arial", (short) 14, true));
        headerStyle.setBorderTop(org.apache.poi.ss.usermodel.BorderStyle.THIN);
        headerStyle.setBorderBottom(org.apache.poi.ss.usermodel.BorderStyle.THIN);
        headerStyle.setBorderLeft(org.apache.poi.ss.usermodel.BorderStyle.THIN);
        headerStyle.setBorderRight(org.apache.poi.ss.usermodel.BorderStyle.THIN);

        String[] headers = {
            "Id Cliente", "Fecha", "Numero Celular", "Direccion Cliente", "Nombre Cliente", "Apellido Cliente", "Email Cliente"
        };

        for (int i = 0; i < headers.length; i++) {
            createCell(headerRow, i, headers[i], headerStyle);
        }
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 3;
        CellStyle evenStyle = createCellStyle(IndexedColors.GREY_25_PERCENT, IndexedColors.BLACK);
        CellStyle oddStyle = createCellStyle(IndexedColors.WHITE, IndexedColors.BLACK);

        evenStyle.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER);
        evenStyle.setFont(createFont("Arial", (short) 14, false));
        evenStyle.setBorderTop(org.apache.poi.ss.usermodel.BorderStyle.THIN);
        evenStyle.setBorderBottom(org.apache.poi.ss.usermodel.BorderStyle.THIN);
        evenStyle.setBorderLeft(org.apache.poi.ss.usermodel.BorderStyle.THIN);
        evenStyle.setBorderRight(org.apache.poi.ss.usermodel.BorderStyle.THIN);

        oddStyle.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER);
        oddStyle.setFont(createFont("Arial", (short) 14, false));
        oddStyle.setBorderTop(org.apache.poi.ss.usermodel.BorderStyle.THIN);
        oddStyle.setBorderBottom(org.apache.poi.ss.usermodel.BorderStyle.THIN);
        oddStyle.setBorderLeft(org.apache.poi.ss.usermodel.BorderStyle.THIN);
        oddStyle.setBorderRight(org.apache.poi.ss.usermodel.BorderStyle.THIN);

        for (Contador contador : contadorList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            CellStyle dataStyle = (rowCount % 2 == 0) ? evenStyle : oddStyle;
            createCell(row, columnCount++, contador.getClienteId(), dataStyle);
            createCell(row, columnCount++, contador.getFecha(), dataStyle);
            createCell(row, columnCount++, contador.getCelNumero(), dataStyle);
            createCell(row, columnCount++, contador.getDireccionCliente(), dataStyle);
            createCell(row, columnCount++, contador.getNombreCliente(), dataStyle);
            createCell(row, columnCount++, contador.getApellidoCliente(), dataStyle);
            createCell(row, columnCount++, contador.getEmailCliente(), dataStyle);
        }

        for (int i = 0; i < 7; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
        response.setContentType("application/octet-stream");
        workbook.write(response.getOutputStream());
        workbook.close();
    }

    private CellStyle createCellStyle(IndexedColors foregroundColor, IndexedColors fontColor) {
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(foregroundColor.getIndex());
        style.setFillPattern(org.apache.poi.ss.usermodel.FillPatternType.SOLID_FOREGROUND);
        style.setFont(createFont("Arial", (short) 14, true));
        style.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER);
        style.setBorderTop(org.apache.poi.ss.usermodel.BorderStyle.THIN);
        style.setBorderBottom(org.apache.poi.ss.usermodel.BorderStyle.THIN);
        style.setBorderLeft(org.apache.poi.ss.usermodel.BorderStyle.THIN);
        style.setBorderRight(org.apache.poi.ss.usermodel.BorderStyle.THIN);
        return style;
    }

    private XSSFFont createFont(String fontName, short fontHeight, boolean bold) {
        XSSFFont font = workbook.createFont();
        font.setFontName(fontName);
        font.setFontHeightInPoints(fontHeight);
        font.setBold(bold);
        return font;
    }
}
