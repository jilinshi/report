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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mingda.database.JdbcConnection;
import com.mingda.dto.TempfamilyinfoDTO;

@WebServlet(name = "TempApprove", urlPatterns = { "/TempApprove" })
public class TempApprove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TempApprove() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		//保存操作   
		TempfamilyinfoDTO tfdto = new TempfamilyinfoDTO();
		tfdto = ms.get(0);
		String sql_insert ="insert into temp_jz "
				+ " (tjz_id, familyid, familyno, masterid, mastername, paperid, percount, salcount, operstate, on_no, famsort, accounts, onallname, fde, fdefamilyno, fdename, f_income, fm_sex, fmage, f_familyid, xm_jtcy0, sfzh_jtcy0, res0, body0, xm_jtcy1, sfzh_jtcy1, rel1, res1, body1, xm_jtcy2, sfzh_jtcy2, rel2, res2, body2, xm_jtcy3, sfzh_jtcy3, rel3, res3, body3, xm_jtcy4, sfzh_jtcy4, rel4, res4, body4, qx, jd, sq, approveresult1, approveperson1, approveidea1, aprrovedate1, approveresult2, approveperson2, approveidea2, aprrovedate2, approveresult3, approveperson3, approveidea3, aprrovedate3, approvegoto, serialno, createtime, approveend, updatetime, approvemoney) "			
				+ " values "
				+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1,tfdto.getFamilyid());
		
		System.out.println(familyid);
		JSONObject json = new JSONObject();
		json.put("success", "成功！");
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
