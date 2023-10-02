package com.example.tecnisuelos1.services.excelReports;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.example.tecnisuelos1.entity.PruebaCampo;

import jakarta.servlet.http.HttpServletResponse;

public class PruebaCampoExcelExporter {
    private XSSFWorkbook workbook;
    private List<PruebaCampo> pruebaCampoList;

    public PruebaCampoExcelExporter(List<PruebaCampo> pruebaCampoList) {
        this.pruebaCampoList = pruebaCampoList;
        workbook = new XSSFWorkbook();
    }

    public void export(HttpServletResponse response) throws IOException {
        Sheet sheet = workbook.createSheet("PruebasCampo");
        writeTitle(sheet);
        writeHeaderLine(sheet);
        writeDataLines(sheet);

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=informe_pruebas_campo.xlsx");

        workbook.write(response.getOutputStream());
        workbook.close();
    }

    private void writeTitle(Sheet sheet) {
        Row titleRow1 = sheet.createRow(0);
        CellStyle titleStyle = createTitleStyle();
        titleStyle.setFont(createFont("Arial", (short) 20, true));

        createCell(titleRow1, 0, "Reporte Pruebas de Campo", titleStyle);
        sheet.addMergedRegion(new org.apache.poi.ss.util.CellRangeAddress(0, 1, 0, 14));
    }

    private void writeHeaderLine(Sheet sheet) {
        Row row = sheet.createRow(2);
        row.setHeightInPoints(30);

        CellStyle headerStyle = createCellStyle(IndexedColors.LIGHT_BLUE, IndexedColors.WHITE);
        headerStyle.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER);
        headerStyle.setFont(createFont("Arial", (short) 14, true));
        headerStyle.setBorderTop(org.apache.poi.ss.usermodel.BorderStyle.THIN);
        headerStyle.setBorderBottom(org.apache.poi.ss.usermodel.BorderStyle.THIN);
        headerStyle.setBorderLeft(org.apache.poi.ss.usermodel.BorderStyle.THIN);
        headerStyle.setBorderRight(org.apache.poi.ss.usermodel.BorderStyle.THIN);

        String[] headers = {
            "Id", "Nombre Empleado", "Fecha", "Numero Cilindro", "Numero Prueba", "Cliente",
            "Ubicacion", "Sondeo", "Revenimiento", "Ultrasonico",
            "Esclerometria", "Analisis Petrograficos", "Elaboracion", "Reactividad", "Compresion"
        };

        for (int i = 0; i < headers.length; i++) {
            createCell(row, i, headers[i], headerStyle);
        }
    }

    private void writeDataLines(Sheet sheet) {
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

        for (PruebaCampo pruebaCampo : pruebaCampoList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            CellStyle dataStyle = (rowCount % 2 == 0) ? evenStyle : oddStyle;
            createCell(row, columnCount++, pruebaCampo.getId(), dataStyle);
            createCell(row, columnCount++, pruebaCampo.getNombreEmpleado(), dataStyle);
            createCell(row, columnCount++, pruebaCampo.getFecha().toString(), dataStyle);
            createCell(row, columnCount++, pruebaCampo.getNumeroCilindro(), dataStyle);
            createCell(row, columnCount++, pruebaCampo.getNumeroPrueba(), dataStyle);
            createCell(row, columnCount++, pruebaCampo.getCliente(), dataStyle);
            createCell(row, columnCount++, pruebaCampo.getUbicacion(), dataStyle);
            createCell(row, columnCount++, pruebaCampo.getSondeo(), dataStyle);
            createCell(row, columnCount++, pruebaCampo.getRevenimiento(), dataStyle);
            createCell(row, columnCount++, pruebaCampo.getUltrasonico(), dataStyle);
            createCell(row, columnCount++, pruebaCampo.getEsclerometria(), dataStyle);
            createCell(row, columnCount++, pruebaCampo.getAnalisisPetrograficos(), dataStyle);
            createCell(row, columnCount++, pruebaCampo.getElaboracion(), dataStyle);
            createCell(row, columnCount++, pruebaCampo.getReactividad(), dataStyle);
            createCell(row, columnCount++, pruebaCampo.getCompresion(), dataStyle);
        }

        for (int i = 0; i < 15; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        Cell cell = row.createCell(columnCount);
        if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else {
            cell.setCellValue(String.valueOf(value));
        }
        cell.setCellStyle(style);
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

    private CellStyle createTitleStyle() {
        CellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER);
        titleStyle.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
        titleStyle.setFont(createFont("Arial", (short) 20, true));
        titleStyle.setBorderTop(org.apache.poi.ss.usermodel.BorderStyle.NONE);
        titleStyle.setBorderBottom(org.apache.poi.ss.usermodel.BorderStyle.NONE);
        titleStyle.setBorderLeft(org.apache.poi.ss.usermodel.BorderStyle.NONE);
        titleStyle.setBorderRight(org.apache.poi.ss.usermodel.BorderStyle.NONE);
        return titleStyle;
    }

    private XSSFFont createFont(String fontName, short fontHeight, boolean bold) {
        XSSFFont font = workbook.createFont();
        font.setFontName(fontName);
        font.setFontHeightInPoints(fontHeight);
        font.setBold(bold);
        return font;
    }
}
