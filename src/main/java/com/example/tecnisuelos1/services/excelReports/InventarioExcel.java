
package com.example.tecnisuelos1.services.excelReports;

import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.example.tecnisuelos1.entity.Inventario;

import jakarta.servlet.http.HttpServletResponse;

public class InventarioExcel {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Inventario> inventarioInfoList;

    public InventarioExcel (List<Inventario> InventarioInfoList) {
        this.inventarioInfoList = InventarioInfoList;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Informe de inventario");
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
        createCell(row, 6, "Granulometria", style);
        createCell(row, 7, "Contenido de Aire", style);
        createCell(row, 8, "Flexion del Concreto", style);
        createCell(row, 9, "Compresion", style);
        createCell(row, 10, "Estudia Petrografico", style);
        createCell(row, 11, "Elasticidad del Extensometro", style);
        createCell(row, 12, "Contraccion de Secado", style);
        createCell(row, 13, "Pruebas de Permeabilidad", style);
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
        for (Inventario inventario : inventarioInfoList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, inventario.getInventarioId(), style);
            createCell(row, columnCount++, inventario.getCantidadInven(), style);
            createCell(row, columnCount++, inventario.getNombreInven(), style);
            createCell(row, columnCount++, inventario.getDescripcionInven(), style);
            createCell(row, columnCount++, inventario.getCategoriaInven(), style);
            createCell(row, columnCount++, inventario.getImagenInven(), style);
           
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
