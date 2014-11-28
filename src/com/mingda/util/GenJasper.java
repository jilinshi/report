package com.mingda.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

@SuppressWarnings("deprecation")
public class GenJasper {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void exportHtml(HttpServletResponse response, Connection conn,
			Map parameters, String jasperFile) {
		byte[] bReport = null;
		JasperPrint jasperPrint;
		try {
			jasperPrint = JasperFillManager.fillReport(jasperFile, parameters,
					conn);

			JRHtmlExporter exporter = new JRHtmlExporter();
			ByteArrayOutputStream oStream = new ByteArrayOutputStream();
			exporter.setParameter(
					JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,
					Boolean.FALSE);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "GBK");
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, oStream);
			exporter.exportReport();
			bReport = oStream.toByteArray();
			oStream.close();
			ServletOutputStream out = response.getOutputStream();
			out.write(bReport, 0, bReport.length);
			out.flush();
			out.close();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void exportPdf(HttpServletResponse response, Connection conn,
			Map parameters, String jasperFile) {
		try {
			response.setCharacterEncoding("UTF-8");
			ServletOutputStream out = response.getOutputStream();
			byte[] bytes = JasperRunManager.runReportToPdf(jasperFile,
					parameters, conn);
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			out.write(bytes, 0, bytes.length);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void exportXls(HttpServletResponse response, Connection conn,
			Map parameters, String jasperFile) {
		try {
			byte[] bReport = null;
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFile,
					parameters, conn);
			JRXlsExporter exporter = new JRXlsExporter();
			ByteArrayOutputStream oStream = new ByteArrayOutputStream();

			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, oStream);
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
					Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
					Boolean.FALSE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
					Boolean.FALSE);

			exporter.exportReport();

			byte[] bytes = oStream.toByteArray();
			bReport = oStream.toByteArray();
			if (bReport != null) {
				String fname = "cust_test";// Excel文件名
				response.reset();
				response.setHeader("Content-disposition",
						"attachment; filename=" + fname + ".xls");// 设定输出文件头
				response.setContentType("application/vnd.ms-excel");
				response.setContentLength(bytes.length);
				ServletOutputStream ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
				oStream.close();
				ouputStream.close();
			}
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
