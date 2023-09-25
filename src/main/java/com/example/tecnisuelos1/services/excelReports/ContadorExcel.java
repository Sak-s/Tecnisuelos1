
package com.example.tecnisuelos1.services.excelReports;

import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
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
        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Id Cliente", style);
        createCell(row, 2, "Fecha", style);
        createCell(row, 3, "Numero Celular", style);
        createCell(row, 4, "Direccion Cliente", style);
        createCell(row, 5, "Nombre Cliente", style);
        createCell(row, 6, "Apellido Cliente", style);
        createCell(row, 7, "Email Cliente", style);

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
        for (Contador contador : contadorList ) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, contador.getClienteId(), style);
            createCell(row, columnCount++, contador.getFecha(), style);
            createCell(row, columnCount++, contador.getCelNumero().toString(), style);
            createCell(row, columnCount++, contador.getDireccionCliente(), style);
            createCell(row, columnCount++, contador.getNombreCliente(), style);
            createCell(row, columnCount++, contador.getApellidoCliente(), style);
            createCell(row, columnCount++, contador.getEmailCliente(), style);
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
