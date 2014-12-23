package com.mingda.biz.temp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mingda.util.ExportExcel;


@WebServlet(name = "DownloadExcel", urlPatterns = { "/DownloadExcel" })
public class DownloadExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DownloadExcel() {
        super();
    }

	@SuppressWarnings({"unchecked","rawtypes"})
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkedHashMap<String, String> title = new LinkedHashMap<String, String>();
		HttpSession session=request.getSession();
		request.setCharacterEncoding("UTF-8");//����request�ı��뷽ʽ����ֹ��������
		String fileName ="��������";
		String recommendedName = new String(fileName.getBytes(),"iso_8859_1");//�����ļ����Ƶı����ʽ
		title =(LinkedHashMap<String, String>) session.getAttribute("title");
		List<HashMap> rs = (List<HashMap>)session.getAttribute("hm");
		ByteArrayInputStream bais = null;
		ExportExcel ee = new ExportExcel();
		ByteArrayOutputStream baos = ee.genExcelData(title, rs); //����Ϊ  ��Ŀ�������excel���
		if (null != baos) {
			byte[] ba = baos.toByteArray();
			bais = new ByteArrayInputStream(ba);
		}
		response.setContentType("application/vnd.ms-excel ");
		response.setHeader("Content-Disposition", "attachment; filename='" + recommendedName + ".xls'");
		OutputStream os = response.getOutputStream();
		baos.writeTo(os);
        os.flush();
        baos.close();
        bais.close();
        os.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
