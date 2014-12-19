package com.mingda.biz.temp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paperid = request.getParameter("p");
		String ds = "cs";
		List<TempfamilyinfoDTO> ms = new ArrayList<TempfamilyinfoDTO>();
		if(ds==null||"".equals(ds)){
		}else{
			JdbcConnection db = new JdbcConnection(ds);
			Connection conn = null;
			try {
				response.setContentType("text/html;charset=UTF-8");
				conn = db.getConnection();
				String sql ="select * from tempfamiyinfo o where o.paperid='"+paperid+"' ";
				Statement ps=conn.createStatement();
			    ResultSet rs=ps.executeQuery(sql);
			    while(rs.next())
		        {
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
			    	ms.add(m);
		        }
			    JSONObject json = new JSONObject();
			    JSONArray jsArr = JSONArray.fromObject(ms);
			    json.put("rows", jsArr.toString());
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