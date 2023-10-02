package com.example.tecnisuelos1.services.excelReports;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress; // Agregada la importación
import org.springframework.stereotype.Service;

import com.example.tecnisuelos1.entity.Laboratorista;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class LaboratoristaExcel {

    private XSSFWorkbook workbook;
    private List<Laboratorista> laboratoristaInfoList;

    public LaboratoristaExcel(List<Laboratorista> laboratoristaInfoList) {
        this.laboratoristaInfoList = laboratoristaInfoList;
        workbook = new XSSFWorkbook();
    }

    public void export(HttpServletResponse response) throws IOException {
        Sheet sheet = workbook.createSheet("Informes de Laboratorio");
        writeTitle(sheet);
        writeHeaderLine(sheet);
        writeDataLines(sheet);

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=informe_laboratorio.xlsx");

        workbook.write(response.getOutputStream());
        workbook.close();
    }

    private void writeTitle(Sheet sheet) {
        Row titleRow = sheet.createRow(0);
        CellStyle titleStyle = createCellStyle(IndexedColors.WHITE, IndexedColors.LIGHT_BLUE);
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setFont(createFont("Arial", (short) 20, true));
        titleStyle.setBorderRight(BorderStyle.NONE); // Sin borde derecho
        titleStyle.setBorderLeft(BorderStyle.NONE); // Sin borde izquierdo
        titleRow.setHeightInPoints(40);
        
        createCell(titleRow, 0, "Reporte de Informes de Laboratorio", titleStyle);
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 13)); // Fusiona las dos filas en el centro del título
    }

    private void writeHeaderLine(Sheet sheet) {
        Row row = sheet.createRow(2); // Comienza a escribir a partir de la tercera fila
        row.setHeightInPoints(30);

        String[] headers = {
            "Id", "Nombre Empleado", "Fecha", "Numero Cilindro", "Numero Prueba", "Cliente",
            "Granulometria", "Contenido de Aire", "Flexion del Concreto", "Compresion",
            "Estudio Petrografico", "Elasticidad del Extensometro", "Contraccion de Secado",
            "Pruebas de Permeabilidad"
        };

        CellStyle headerStyle = createCellStyle(IndexedColors.LIGHT_BLUE, IndexedColors.WHITE);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setFont(createFont("Arial", (short) 14, true));
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);

        for (int i = 0; i < headers.length; i++) {
            createCell(row, i, headers[i], headerStyle);
        }
    }

    private void writeDataLines(Sheet sheet) {
        int rowCount = 3; // Comienza a escribir a partir de la cuarta fila

        CellStyle evenStyle = createCellStyle(IndexedColors.GREY_25_PERCENT, IndexedColors.BLACK);
        CellStyle oddStyle = createCellStyle(IndexedColors.WHITE, IndexedColors.BLACK);

        evenStyle.setAlignment(HorizontalAlignment.CENTER);
        evenStyle.setFont(createFont("Arial", (short) 14, false));
        evenStyle.setBorderTop(BorderStyle.THIN);
        evenStyle.setBorderBottom(BorderStyle.THIN);
        evenStyle.setBorderLeft(BorderStyle.THIN);
        evenStyle.setBorderRight(BorderStyle.THIN);

        oddStyle.setAlignment(HorizontalAlignment.CENTER);
        oddStyle.setFont(createFont("Arial", (short) 14, false));
        oddStyle.setBorderTop(BorderStyle.THIN);
        oddStyle.setBorderBottom(BorderStyle.THIN);
        oddStyle.setBorderLeft(BorderStyle.THIN);
        oddStyle.setBorderRight(BorderStyle.THIN);

        for (Laboratorista laboratorista : laboratoristaInfoList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            CellStyle dataStyle = (rowCount % 2 == 0) ? evenStyle : oddStyle;
            createCell(row, columnCount++, laboratorista.getLaboratoristaId(), dataStyle);
            createCell(row, columnCount++, laboratorista.getNombreEmpleado(), dataStyle);
            createCell(row, columnCount++, laboratorista.getFecha().toString(), dataStyle);
            createCell(row, columnCount++, laboratorista.getNumerocilindro(), dataStyle);
            createCell(row, columnCount++, laboratorista.getNumeroPrueba(), dataStyle);
            createCell(row, columnCount++, laboratorista.getCliente(), dataStyle);
            createCell(row, columnCount++, laboratorista.getGranulometria(), dataStyle);
            createCell(row, columnCount++, laboratorista.getContenidoAire(), dataStyle);
            createCell(row, columnCount++, laboratorista.getFlexionCocreto(), dataStyle);
            createCell(row, columnCount++, laboratorista.getCompresion(), dataStyle);
            createCell(row, columnCount++, laboratorista.getEstudioPetrografico(), dataStyle);
            createCell(row, columnCount++, laboratorista.getElasticidadExtensometro(), dataStyle);
            createCell(row, columnCount++, laboratorista.getContraccionSecado(), dataStyle);
            createCell(row, columnCount++, laboratorista.getPruebasPermeabilidad(), dataStyle);
        }

        for (int i = 0; i < 14; i++) {
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
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFont(createFont("Arial", (short) 14, true));
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(createFont("Arial", (short) 14, true));
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setFont(createFont("Arial", (short) 14, false));
        style.setFillForegroundColor(foregroundColor.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFont(createFont("Arial", (short) 14, true));
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(createFont("Arial", (short) 14, true));
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setFont(createFont("Arial", (short) 14, false));
        style.setFillForegroundColor(foregroundColor.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFont(createFont("Arial", (short) 14, true));
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(createFont("Arial", (short) 14, true));
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        return style;
    }

    private Font createFont(String fontName, short fontHeight, boolean bold) {
        Font font = workbook.createFont();
        font.setFontName(fontName);
        font.setFontHeightInPoints(fontHeight);
        font.setBold(bold);
        return font;
    }
}
