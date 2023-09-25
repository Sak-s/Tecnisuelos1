/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tecnisuelos1.services.excelReports;

import com.example.tecnisuelos1.entity.PruebaCampo;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author santiago
 */
public class PruebaCampoExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<PruebaCampo> pruebaCampoList;

    public PruebaCampoExcelExporter(List<PruebaCampo> pruebaCampoList) {
        this.pruebaCampoList = pruebaCampoList;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("PruebasCampo");
        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Id", style);
        createCell(row, 1, "Nombre Empleado", style);
        createCell(row, 2, "Fecha", style);
        createCell(row, 3, "Numero Cilindro", style);
        createCell(row, 4, "Numero Prueba", style);
        createCell(row, 5, "Cliente", style);
        createCell(row, 6, "Ubicacion", style);
        createCell(row, 7, "Sondeo", style);
        createCell(row, 8, "Revenimiento", style);
        createCell(row, 9, "Ultrasonico", style);
        createCell(row, 10, "Esclerometria", style);
        createCell(row, 11, "Analisis Petrograficos", style);
        createCell(row, 12, "Elaboracion", style);
        createCell(row, 13, "Reactividad", style);
        createCell(row, 14, "Compresion", style);
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
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        for (PruebaCampo pruebaCampo : pruebaCampoList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, pruebaCampo.getId(), style);
            createCell(row, columnCount++, pruebaCampo.getNombreEmpleado(), style);
            createCell(row, columnCount++, pruebaCampo.getFecha().toString(), style);
            createCell(row, columnCount++, pruebaCampo.getNumeroCilindro(), style);
            createCell(row, columnCount++, pruebaCampo.getNumeroPrueba(), style);
            createCell(row, columnCount++, pruebaCampo.getCliente(), style);
            createCell(row, columnCount++, pruebaCampo.getUbicacion(), style);
            createCell(row, columnCount++, pruebaCampo.getSondeo(), style);
            createCell(row, columnCount++, pruebaCampo.getRevenimiento(), style);
            createCell(row, columnCount++, pruebaCampo.getUltrasonico(), style);
            createCell(row, columnCount++, pruebaCampo.getEsclerometria(), style);
            createCell(row, columnCount++, pruebaCampo.getAnalisisPetrograficos(), style);
            createCell(row, columnCount++, pruebaCampo.getElaboracion(), style);
            createCell(row, columnCount++, pruebaCampo.getReactividad(), style);
            createCell(row, columnCount++, pruebaCampo.getCompresion(), style);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
        response.setContentType("application/octet-stream");
        workbook.write(response.getOutputStream());
        workbook.close();
    }

}
