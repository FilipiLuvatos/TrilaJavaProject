package com.example.trilhaJava.service;

import com.example.trilhaJava.model.pessoa.Transacao;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class RelatorioContaExcel {

    public byte[] exportToExcel(List<Transacao> listaTransacao) throws IOException {

        try{
        // Criação do Workbook (arquivo Excel)
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Transações");

        // Cabeçalho da planilha
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Num Conta");
        headerRow.createCell(2).setCellValue("Tipo");
        headerRow.createCell(3).setCellValue("Saldo Movimentado");
        headerRow.createCell(4).setCellValue("Tempo");
        headerRow.createCell(5).setCellValue("Valor Moeda");
        headerRow.createCell(6).setCellValue("Moeda");
        headerRow.createCell(7).setCellValue("Total");

        // Adicionando os dados das transações
        int rowNum = 1;  // Começamos na linha 1, pois a linha 0 é o cabeçalho
        for (Transacao transacao : listaTransacao) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(transacao.getId());
            row.createCell(1).setCellValue(transacao.getNumConta());
            row.createCell(2).setCellValue(transacao.getTipo().toString());  // Se for um Enum, converta para String
            row.createCell(3).setCellValue(transacao.getSaladoMovimenta());
            row.createCell(4).setCellValue(transacao.getTempo().toString());
            row.createCell(5).setCellValue(transacao.getValorMoeda());
            row.createCell(6).setCellValue(transacao.getMoeda());
            row.createCell(7).setCellValue(transacao.getTotal());
        }

        // Escrevendo o conteúdo para um byte array (você pode salvar o arquivo no disco ou retornar via Response)
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        workbook.close();

        return baos.toByteArray();

        } catch (IOException e) {
            System.out.println("[ERRO AO GERAR EXCEL]");
        }
        return new byte[0];
    }

}
