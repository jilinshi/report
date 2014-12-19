package com.mingda.biz.temp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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


@WebServlet(name = "TempApply", urlPatterns = { "/TempApply" })
public class TempApply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TempApply() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String familyid = request.getParameter("familyid");
		String ds = "cs";
		String approveperson = request.getParameter("approveperson");
		String approveresult = request.getParameter("approveresult");
		String approvemoney = request.getParameter("approvemoney");
		JdbcConnection db = new JdbcConnection(ds);
		Connection conn = null;
		try {
			response.setContentType("text/html;charset=UTF-8");
			conn = db.getConnection();
			String sql = "select * from tempfamiyinfo o where o.familyid='"
					+ familyid + "' ";
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			List<TempfamilyinfoDTO> ms = new ArrayList<TempfamilyinfoDTO>();
			while (rs.next()) {
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
			// 保存操作
			TempfamilyinfoDTO tfdto = new TempfamilyinfoDTO();
			tfdto = ms.get(0);
			String sql_insert = "insert into temp_jz "
					+ " (tjz_id, familyid, familyno, masterid, mastername, paperid, percount, salcount, operstate, on_no, famsort, accounts, onallname, fde, fdefamilyno, fdename, f_income, fm_sex, fmage, f_familyid, xm_jtcy0, sfzh_jtcy0, rel0, res0, body0, xm_jtcy1, sfzh_jtcy1, rel1, res1, body1, xm_jtcy2, sfzh_jtcy2, rel2, res2, body2, xm_jtcy3, sfzh_jtcy3, rel3, res3, body3, xm_jtcy4, sfzh_jtcy4, rel4, res4, body4, qx, jd, sq, approveresult1, approveperson1, approveidea1, aprrovedate1, approveresult2, approveperson2, approveidea2, aprrovedate2, approveresult3, approveperson3, approveidea3, aprrovedate3, approvegoto, serialno, createtime, approveend, updatetime, approvemoney) "
					+ " values "
					+ " (XTJZ_ID.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

			PreparedStatement pst = conn.prepareStatement(sql_insert);
			pst.setString(1, tfdto.getFamilyid());
			pst.setString(2, tfdto.getFamilyno());
			pst.setString(3, tfdto.getMasterid());
			pst.setString(4, tfdto.getMastername());
			pst.setString(5, tfdto.getPaperid());
			pst.setString(6, tfdto.getPercount());
			pst.setString(7, tfdto.getSalcount());
			pst.setString(8, tfdto.getOperstate());
			pst.setString(9, tfdto.getOn_no());
			pst.setString(10, tfdto.getFamsort());
			pst.setString(11, tfdto.getAccounts());
			pst.setString(12, tfdto.getOnallname());
			pst.setString(13, tfdto.getFde());
			pst.setString(14, tfdto.getFdefamilyno());
			pst.setString(15, tfdto.getFdename());
			pst.setString(16, tfdto.getF_income());
			pst.setString(17, tfdto.getFm_sex());
			pst.setString(18, tfdto.getFmage());
			pst.setString(19, tfdto.getF_familyid());
			pst.setString(20, tfdto.getXm_jtcy0());
			pst.setString(21, tfdto.getSfzh_jtcy0());
			pst.setString(22, tfdto.getRel0());
			pst.setString(23, tfdto.getRes0());
			pst.setString(24, tfdto.getBody0());
			pst.setString(25, tfdto.getXm_jtcy1());
			pst.setString(26, tfdto.getSfzh_jtcy1());
			pst.setString(27, tfdto.getRel1());
			pst.setString(28, tfdto.getRes1());
			pst.setString(29, tfdto.getBody1());
			pst.setString(30, tfdto.getXm_jtcy2());
			pst.setString(31, tfdto.getSfzh_jtcy2());
			pst.setString(32, tfdto.getRel2());
			pst.setString(33, tfdto.getRes2());
			pst.setString(34, tfdto.getBody2());
			pst.setString(35, tfdto.getXm_jtcy3());
			pst.setString(36, tfdto.getSfzh_jtcy3());
			pst.setString(37, tfdto.getRel3());
			pst.setString(38, tfdto.getRes3());
			pst.setString(39, tfdto.getBody3());
			pst.setString(40, tfdto.getXm_jtcy4());
			pst.setString(41, tfdto.getSfzh_jtcy4());
			pst.setString(42, tfdto.getRel4());
			pst.setString(43, tfdto.getRes4());
			pst.setString(44, tfdto.getBody4());
			pst.setString(45, tfdto.getQx());
			pst.setString(46, tfdto.getJd());
			pst.setString(47, tfdto.getSq());
			pst.setString(48, approveresult);
			pst.setString(49, approveperson);
			pst.setString(50, "");
			pst.setTimestamp(51, new Timestamp(new Date().getTime())); 
			pst.setString(52, "");
			pst.setString(53, "");
			pst.setString(54, "");
			pst.setString(55, "");
			pst.setString(56, "");
			pst.setString(57, "");
			pst.setString(58, "");
			pst.setString(59, "");
			pst.setString(60, "1");
			UUID uuid = UUID.randomUUID();
			pst.setString(61, uuid.toString());
			pst.setTimestamp(62, new Timestamp(new Date().getTime()));
			pst.setString(63, "");
			pst.setTimestamp(64, new Timestamp(new Date().getTime()));
			pst.setString(65, approvemoney);
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
			
			rs.close();
			ps.close();
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
