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


@WebServlet(name = "TempApplyInit", urlPatterns = { "/TempApplyInit" })
public class TempApplyInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TempApplyInit() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paperid = request.getParameter("paperid");
		String ds = "cs";
		JdbcConnection db = new JdbcConnection(ds);
		Connection conn = null;
		try {
			response.setContentType("text/html;charset=UTF-8");
			conn = db.getConnection();
			String sql ="select count(*) as sum from tempfamiyinfo o where o.paperid='"+paperid+"' ";
			Statement ps=conn.createStatement();
		    ResultSet rs=ps.executeQuery(sql);
		    int sum = 0;
		    while(rs.next()){
		    	sum = Integer.parseInt(rs.getString("sum"));
		    }
		    if(sum>0){
		    	request.setAttribute("msg", "");
		    	request.setAttribute("p", paperid);
		    	RequestDispatcher rd = request.getRequestDispatcher("/page/biz/applyview.jsp");
				rd.forward(request, response);
		    }else{
		    	request.setAttribute("msg", "查无此人，请核实身份证号码！");
		    	RequestDispatcher rd = request.getRequestDispatcher("/page/biz/tempapply.jsp");
				rd.forward(request, response);
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
