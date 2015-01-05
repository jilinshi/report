package com.mingda.biz.temp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mingda.database.JdbcConnection;
import com.mingda.dto.TempJzDTO;

@WebServlet(name = "TempApproveDelete", urlPatterns = { "/TempApproveDelete" })
public class TempApproveDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TempApproveDelete() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String ds = (String)session.getAttribute("ds");
		String onno = (String)session.getAttribute("onno");
		String tjzId = request.getParameter("tjzId");
		if (null == ds || "".equals(ds)) {
		} else {
			JdbcConnection db = new JdbcConnection(ds);
			PreparedStatement pst = null;
			Connection conn = null;
			try {
				response.setContentType("text/html;charset=UTF-8");
				conn = db.getConnection();
				String sql = " delete temp_jz o where o.tjz_id=? " ;
				pst = conn.prepareStatement(sql);
				pst.setString(1, tjzId);
				JSONObject json = new JSONObject();
				int i = pst.executeUpdate();
				if(i>0){
					json.put("success", "成功！");
					json.put("result", "1");
				}else{
					json.put("success", "失败！");
					json.put("result", "0");
				}
				response.setContentType("application/x-json");// 需要设置ContentType,为"application/x-json"
				PrintWriter pw = response.getWriter();
				pw.write(json.toString());
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (null != conn) {
					try {
						pst.close();
						JdbcConnection.closeConnection();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
