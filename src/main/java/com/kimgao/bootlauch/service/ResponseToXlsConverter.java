package com.kimgao.bootlauch.service;

import com.kimgao.bootlauch.AjaxResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ResponseToXlsConverter extends AbstractHttpMessageConverter<AjaxResponse> {
    private static final MediaType EXCEL_TYPE = MediaType.valueOf("application/vnd.ms-excel");

    ResponseToXlsConverter() {
        super(EXCEL_TYPE);
    }

    @Override
    protected AjaxResponse readInternal(final Class<? extends AjaxResponse> clazz,
                                        final HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        return null;
    }

    //针对AjaxResponse类型返回值，使用下面的writeInternal方法进行消息类型转换
    @Override
    protected boolean supports(final Class<?> clazz) {
        return (AjaxResponse.class == clazz);
    }

    @Override
    protected void writeInternal(final AjaxResponse ajaxResponse, final HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {

        final Workbook workbook = new HSSFWorkbook();
        final Sheet sheet = workbook.createSheet();

        final Row row = sheet.createRow(0);
        row.createCell(0).setCellValue(ajaxResponse.getMessage());
        row.createCell(1).setCellValue(ajaxResponse.getData().toString());

        workbook.write(outputMessage.getBody());
    }
}
