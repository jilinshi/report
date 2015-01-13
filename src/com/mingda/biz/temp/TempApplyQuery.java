package com.mingda.biz.temp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import com.mingda.dto.TempfamilyinfoDTO;

@WebServlet(name = "TempApplyQuery", urlPatterns = { "/TempApplyQuery" })
public class TempApplyQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TempApplyQuery() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	@SuppressWarnings({ "static-access", "resource" })
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String ds = (String) session.getAttribute("ds");
		String onno = (String) session.getAttribute("onno");
		String paperid = request.getParameter("p");
		List<TempfamilyinfoDTO> ms = new ArrayList<TempfamilyinfoDTO>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (ds == null || "".equals(ds)) {
		} else {
			JdbcConnection db = new JdbcConnection(ds);
			Connection conn = null;
			try {
				response.setContentType("text/html;charset=UTF-8");
				conn = db.getConnection();
				String sql = "select * from tempfamiyinfo o where o.paperid='"
						+ paperid + "' and o.ON_NO like '" + onno + "%'";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				if (rs.next()) {
					TempfamilyinfoDTO m = new TempfamilyinfoDTO();
					m.setFamilyid(rs.getString("familyid"));
					m.setFamilyno(rs.getString("familyno"));
					m.setMasterid(rs.getString("masterid"));
					m.setMastername(rs.getString("mastername"));
					m.setPaperid(rs.getString("paperid"));
					m.setOperstate(rs.getString("operstate"));
					m.setOnallname(rs.getString("onallname"));
					m.setPercount(rs.getString("percount"));
					m.setSalcount(rs.getString("salcount"));
					m.setDs(ds);
					ms.add(m);
				} else {
					String familyid = "";
					sql = "select fm.familyid from familymemberinfo fm where fm.fm_paperid = '"
							+ paperid + "'";
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					if (rs.next()) {
						familyid = rs.getString(1);
					}

					if (!"".equals(familyid)) {
						sql = "select *  from tempfamiyinfo1 t where t.FAMILYID = '"
								+ familyid
								+ "'   and t.ON_NO like '"
								+ onno
								+ "%'";
						ps = conn.prepareStatement(sql);
						rs = ps.executeQuery();
						if (rs.next()) {
							TempfamilyinfoDTO m = new TempfamilyinfoDTO();
							m.setFamilyid(rs.getString("familyid"));
							m.setFamilyno(rs.getString("familyno"));
							m.setMasterid(rs.getString("masterid"));
							m.setMastername(rs.getString("mastername"));
							m.setPaperid(rs.getString("paperid"));
							m.setOperstate(rs.getString("operstate"));
							m.setOnallname(rs.getString("onallname"));
							m.setPercount(rs.getString("percount"));
							m.setSalcount(rs.getString("salcount"));
							m.setDs(ds);
							ms.add(m);
						}
					}

				}
				//查询是否有未审批的业务
		    	String sql_jz = "select count(*) as sum from temp_jz tj where tj.paperid='"+ paperid +"' and tj.on_no like '"+onno+"%' and tj.approvegoto='2' and tj.approveresult1='1' ";
		    	Statement ps_jz=conn.createStatement();
			    ResultSet rs_jz=ps.executeQuery(sql_jz);
			    int sum_jz=0;
			    while(rs_jz.next()){
			    	sum_jz = Integer.parseInt(rs_jz.getString("sum"));
			    }
			    if(sum_jz>0){
			    	request.setAttribute("flag", "0");
			    }else{
			    	request.setAttribute("flag", "1");
			    }
				JSONObject json = new JSONObject();
				JSONArray jsArr = JSONArray.fromObject(ms);
				json.put("rows", jsArr.toString());
				response.setContentType("application/x-json");// 需要设置ContentType
				PrintWriter pw = response.getWriter();
				pw.write(json.toString());

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (null != rs) {
						rs.close();
					}
					if (null != ps) {
						ps.close();
					}
					if (null != conn) {
						JdbcConnection.closeConnection();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}