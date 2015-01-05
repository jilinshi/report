package com.mingda.biz.temp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.mingda.database.JdbcConnection;
import com.mingda.dto.TempJzDTO;

@WebServlet(name = "TempApproveInit", urlPatterns = { "/TempApproveInit" })
public class TempApproveInit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TempApproveInit() {
        super();
    }

	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String tjzid = request.getParameter("tjzid");
		String ds = (String)session.getAttribute("ds");
		JdbcConnection db = new JdbcConnection(ds);
		Connection conn = null;
		try {
			response.setContentType("text/html;charset=UTF-8");
			conn = db.getConnection();
			String sql ="select * from temp_jz o where o.tjz_id='"+tjzid+"' ";
			Statement ps=conn.createStatement();
		    ResultSet rs=ps.executeQuery(sql);
		    List<TempJzDTO> ms = new ArrayList<TempJzDTO>();
		    while(rs.next())
	        {
		    	TempJzDTO m = new TempJzDTO();
		    	m.setTjzId(rs.getString("tjz_id"));
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
		    	m.setApproveresult1(rs.getString("approveresult1"));
		    	if("1".equals(rs.getString("approveresult1"))){
		    		m.setApproveresult1txt("同意");
		    	}else if("0".equals(rs.getString("approveresult1"))){
		    		m.setApproveresult1txt("不同意");
		    	}
		    	m.setApproveperson1(rs.getString("approveperson1"));
		    	m.setApproveidea1(rs.getString("approveidea1"));
		    	m.setAprrovedate1(rs.getString("aprrovedate1"));
		    	
		    	m.setApproveresult2(rs.getString("approveresult2"));
		    	if("1".equals(rs.getString("approveresult2"))){
		    		m.setApproveresult2txt("同意");
		    	}else if("0".equals(rs.getString("approveresult2"))){
		    		m.setApproveresult2txt("不同意");
		    	}
		    	m.setApproveperson2(rs.getString("approveperson2"));
		    	m.setApproveidea2(rs.getString("approveidea2"));
		    	m.setAprrovedate2(rs.getString("aprrovedate2"));
		    	
		    	m.setApproveresult3(rs.getString("approveresult3"));
		    	if("1".equals(rs.getString("approveresult3"))){
		    		m.setApproveresult3txt("同意");
		    	}else if("0".equals(rs.getString("approveresult3"))){
		    		m.setApproveresult3txt("不同意");
		    	}
		    	m.setApproveperson3(rs.getString("approveperson3"));
		    	m.setApproveidea3(rs.getString("approveidea3"));
		    	m.setAprrovedate3(rs.getString("aprrovedate3"));
		    	m.setApprovegoto(rs.getString("approvegoto"));
		    	m.setSerialno(rs.getString("serialno"));
		    	m.setCreatetime(rs.getString("createtime"));
		    	m.setApproveend(rs.getString("approveend"));
		    	m.setUpdatetime(rs.getString("updatetime"));
		    	m.setApprovemoney(rs.getString("approvemoney"));
		    	m.setApplymoney(rs.getString("applymoney"));
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
