package com.mingda.biz.temp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.mingda.database.JdbcConnection;

@WebServlet(name = "TempApprove", urlPatterns = { "/TempApprove" })
public class TempApprove extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TempApprove() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String ds = (String)session.getAttribute("ds");
		String onno = (String)session.getAttribute("onno");
		String tjzId = request.getParameter("tjzId");
		String approveperson = request.getParameter("approveperson");
		String approveresult = request.getParameter("approveresult");
		String approvemoney = request.getParameter("approvemoney");
		JdbcConnection db = new JdbcConnection(ds);
		Connection conn = null;
		try {
			response.setContentType("text/html;charset=UTF-8");
			conn = db.getConnection();
			String sql = "update temp_jz tj "
					+ " set tj.approveresult2=?,tj.approveperson2=?,tj.approveidea2=?,"
					+ " tj.aprrovedate2=?,tj.approvemoney=?,tj.approvegoto=?,tj.updatetime=?"
					+ " where tj.tjz_id=? ";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, approveresult);
			pst.setString(2, approveperson);
			pst.setString(3, "");
			pst.setTimestamp(4, new Timestamp(new Date().getTime()));
			pst.setString(5, approvemoney);
			pst.setString(6, "2");
			pst.setTimestamp(7, new Timestamp(new Date().getTime()));
			pst.setString(8, tjzId);
			int i = pst.executeUpdate();
			JSONObject json = new JSONObject();
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
			pst.close();
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
