package com.mingda.report;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mingda.database.JdbcConnection;
import com.mingda.util.GenJasper;

@WebServlet(name = "Report", urlPatterns = { "/Report" })
public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Report() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ds = request.getParameter("ds");
		String fid = request.getParameter("fid");
		String mid = request.getParameter("mid");
		String jpt = request.getParameter("jpt");
		String onepic = "";

		if (null == jpt || "".equals(jpt)) {
			jpt = "html";
		}
		JdbcConnection db = new JdbcConnection(ds);
		Connection conn = null;
		try {
			conn = db.getConnection();
			System.out.println(ds + "..." + fid);
			ServletContext servletContext = this.getServletConfig()
					.getServletContext();
			String reportFilePath = "page/report/testFile.jasper";
			File jasperFile = new File(
					servletContext.getRealPath(reportFilePath));
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("fid", fid);
			if ("cs".equals(ds)) {
				onepic = "http://10.10.10.10:7001/db/resident/editor/ViewPic?memberId="
						+ mid;
			}
			if ("nc".equals(ds)) {
				onepic = "http://10.10.10.10:7001/njdb/resident/editor/ViewPic?memberId="
						+ mid;
			}
			parameters.put("onepic", onepic);
			GenJasper gj = new GenJasper();
			if ("xls".equals(jpt)) {
				gj.exportXls(response, conn, parameters, jasperFile.getPath());
			} else if ("pdf".equals(jpt)) {
				gj.exportPdf(response, conn, parameters, jasperFile.getPath());
			} else {
				gj.exportHtml(response, conn, parameters, jasperFile.getPath());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != conn) {
				try {
					JdbcConnection.closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
