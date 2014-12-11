package com.mingda.biz.temp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mingda.database.JdbcConnection;
import com.mingda.dto.tempfamilyinfoDTO;

@WebServlet(name = "TempQuery", urlPatterns = { "/TempQuery" })
public class TempQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TempQuery() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@SuppressWarnings({ "static-access", "unused" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ds = request.getParameter("ds");
		String mastername = request.getParameter("mastername");
		String paperid = request.getParameter("paperid");
		String familyno = request.getParameter("familyno");
		String onno = request.getParameter("onno");
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		Integer p = new Integer(page);
		Integer r = new Integer(rows);
		List<tempfamilyinfoDTO> ms = new ArrayList<tempfamilyinfoDTO>();
		List<tempfamilyinfoDTO> mspage = new ArrayList<tempfamilyinfoDTO>();
		if(ds==null||"".equals(ds)){
		}else{
			JdbcConnection db = new JdbcConnection(ds);
			Connection conn = null;
			try {
				response.setContentType("text/html;charset=UTF-8");
				conn = db.getConnection();
				String jwhere = "";
				if(mastername==null||"".equals(mastername)){
				}else{
					jwhere = jwhere + " and o.mastername='"+mastername+"' ";
				}
				if(paperid==null||"".equals(paperid)){
				}else{
					jwhere = jwhere + " and o.paperid='"+paperid+"' ";
				}
				if(familyno==null||"".equals(familyno)){
				}else{
					jwhere = jwhere + " and o.familyno='"+familyno+"' ";
				}
				String sql ="select * from tempfamiyinfo o where 1=1" + jwhere;
				Statement ps=conn.createStatement();
			    ResultSet rs=ps.executeQuery(sql);
			    while(rs.next())
		        {
			    	tempfamilyinfoDTO m = new tempfamilyinfoDTO();
			    	m.setFamilyid(rs.getString("familyid"));
			    	m.setFamilyno(rs.getString("familyno"));
			    	m.setMasterid(rs.getString("masterid"));
			    	m.setMastername(rs.getString("mastername"));
			    	m.setPaperid(rs.getString("paperid"));
			    	m.setOperstate(rs.getString("operstate"));
			    	m.setOnallname(rs.getString("onallname"));
			    	m.setPercount(rs.getString("percount"));
			    	m.setSalcount(rs.getString("salcount"));
			    	ms.add(m);
		        }
			    JSONObject json = new JSONObject();
				if (null != ms) {
	
					for (int i = (p - 1) * r; i < p * r; i++) {
						if (i == ms.size()) {
							break;
						}
						mspage.add(ms.get(i));
					}
	
					JSONArray jsArr = JSONArray.fromObject(mspage);
					json.put("total", ms.size());
					json.put("rows", jsArr.toString());
				} else {
					json.put("total", 0);
					json.put("rows", "");
				}
			    response.setContentType("application/x-json");//需要设置ContentType 为"application/x-json"
			    PrintWriter pw = response.getWriter();
			    pw.write(json.toString());
			    rs.close();
			    ps.close();
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
}
