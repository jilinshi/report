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

@WebServlet(name = "TempApproveInfo", urlPatterns = { "/TempApproveInfo" })
public class TempApproveInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TempApproveInfo() {
        super();
    }

	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String familyid = request.getParameter("familyid");
		String ds = "cs";
		JdbcConnection db = new JdbcConnection(ds);
		Connection conn = null;
		try {
			response.setContentType("text/html;charset=UTF-8");
			conn = db.getConnection();
			String sql ="select * from tempfamiyinfo o where o.familyid='"+familyid+"' ";
			Statement ps=conn.createStatement();
		    ResultSet rs=ps.executeQuery(sql);
		    List<TempfamilyinfoDTO> ms = new ArrayList<TempfamilyinfoDTO>();
		    while(rs.next())
	        {
		    	TempfamilyinfoDTO m = new TempfamilyinfoDTO();
		    	m.setFamilyid(rs.getString("familyid"));
		    	m.setFamilyno(rs.getString("familyno"));
		    	m.setMasterid(rs.getString("masterid"));
		    	m.setMastername(rs.getString("mastername"));
		    	m.setPaperid(rs.getString("paperid"));
		    	m.setPercount(rs.getString("percount"));
		    	m.setSalcount(rs.getString("salcount"));
		    	m.setOperstate(rs.getString("operstate"));
		    	m.setOn_no(rs.getString("on_no"));
		    	m.setFamsort(rs.getString("famsort"));
		    	m.setAccounts(rs.getString("accounts"));
		    	m.setOnallname(rs.getString("onallname"));
		    	m.setFde(rs.getString("fde"));
		    	m.setFdefamilyno(rs.getString("fdefamilyno"));
		    	m.setFdename(rs.getString("fdename"));
		    	m.setIsybsqdb(rs.getString("isybsqdb"));
		    	m.setBankname(rs.getString("bankname"));
		    	m.setBanktime(rs.getString("banktime"));
		    	m.setBankdate(rs.getString("bankdate"));
		    	m.setBanktype(rs.getString("banktype"));
		    	m.setF_income(rs.getString("f_income"));
		    	m.setFm_sex(rs.getString("fm_sex"));
		    	m.setFmage(rs.getString("fmage"));
		    	m.setF_familyid(rs.getString("f_familyid"));
		    	m.setXm_jtcy0(rs.getString("xm_jtcy0"));
		    	m.setSfzh_jtcy0(rs.getString("sfzh_jtcy0"));
		    	m.setRel0(rs.getString("rel0"));
		    	m.setRes0(rs.getString("res0"));
		    	m.setBody0(rs.getString("body0"));
		    	m.setXm_jtcy1(rs.getString("xm_jtcy1"));
		    	m.setSfzh_jtcy1(rs.getString("sfzh_jtcy1"));
		    	m.setRel1(rs.getString("rel1"));
		    	m.setRes1(rs.getString("res1"));
		    	m.setBody1(rs.getString("body1"));
		    	m.setXm_jtcy2(rs.getString("xm_jtcy2"));
		    	m.setSfzh_jtcy2(rs.getString("sfzh_jtcy2"));
		    	m.setRel2(rs.getString("rel2"));
		    	m.setRes2(rs.getString("res2"));
		    	m.setBody2(rs.getString("body2"));
		    	m.setXm_jtcy3(rs.getString("xm_jtcy3"));
		    	m.setSfzh_jtcy3(rs.getString("sfzh_jtcy3"));
		    	m.setRel3(rs.getString("rel3"));
		    	m.setRes3(rs.getString("res3"));
		    	m.setBody3(rs.getString("body3"));
		    	m.setXm_jtcy4(rs.getString("xm_jtcy4"));
		    	m.setSfzh_jtcy4(rs.getString("sfzh_jtcy4"));
		    	m.setRel4(rs.getString("rel4"));
		    	m.setRes4(rs.getString("res4"));
		    	m.setBody4(rs.getString("body4"));
		    	m.setQx(rs.getString("qx"));
		    	m.setJd(rs.getString("jd"));
		    	m.setSq(rs.getString("sq"));
		    	ms.add(m);
	        }
		    JSONObject json = new JSONObject();
			json = JSONObject.fromObject(ms.get(0));
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
