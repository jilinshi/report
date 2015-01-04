package com.mingda.biz.temp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.mail.Session;
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

@WebServlet(name = "TempQuery", urlPatterns = { "/TempQuery" })
public class TempQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TempQuery() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@SuppressWarnings({ "static-access", "rawtypes", "unchecked" })
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String ds = (String)session.getAttribute("ds");
		String onno = (String)session.getAttribute("onno");
		String mastername = request.getParameter("mastername");
		String paperid = request.getParameter("paperid");
		String familyno = request.getParameter("familyno");
		String approveend = request.getParameter("approveend");
		String orgno = request.getParameter("orgno");
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		Integer p = new Integer(page);
		Integer r = new Integer(rows);
		List<TempJzDTO> ms = new ArrayList<TempJzDTO>();
		List<TempJzDTO> mspage = new ArrayList<TempJzDTO>();
		List<HashMap> hm = new ArrayList<HashMap>();
		if (null == ds || "".equals(ds)) {
		} else {
			JdbcConnection db = new JdbcConnection(ds);
			PreparedStatement ps = null;
			ResultSet rs = null;
			Connection conn = null;
			try {
				response.setContentType("text/html;charset=UTF-8");
				conn = db.getConnection();

				String jwhere = "";
				if (null == mastername || "".equals(mastername)) {
				} else {
					jwhere = jwhere + " and o.mastername='" + mastername + "' ";
				}
				if (null == paperid || "".equals(paperid)) {
				} else {
					jwhere = jwhere + " and o.paperid='" + paperid + "' ";
				}
				if (null == familyno || "".equals(familyno)) {
				} else {
					jwhere = jwhere + " and o.familyno='" + familyno + "' ";
				}
				if (null == approveend || "".equals(approveend)) {

				} else {
					jwhere = jwhere + " and o.approveend='" + approveend + "' ";
				}
				if (null == orgno || "".equals(orgno)) {
					jwhere = jwhere + " and o.on_no like '" + onno + "%' ";
				} else {
					jwhere = jwhere + " and o.on_no like '" + orgno + "%' ";
				}
				String sql = "select * from temp_jz o where 1=1" + jwhere;
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
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
					if ("1".equals(rs.getString("approveresult1"))) {
						m.setApproveresult1txt("同意");
					} else if ("0".equals(rs.getString("approveresult1"))) {
						m.setApproveresult1txt("不同意");
					}
					m.setApproveperson1(rs.getString("approveperson1"));
					m.setApproveidea1(rs.getString("approveidea1"));
					String appdate1 = "";
					if ("".equals(rs.getString("aprrovedate1"))
							|| rs.getString("aprrovedate1") == null) {
					} else {
						appdate1 = rs.getString("aprrovedate1").split(" ")[0];
					}
					m.setAprrovedate1(appdate1);
					m.setApproveresult2(rs.getString("approveresult2"));
					if ("1".equals(rs.getString("approveresult2"))) {
						m.setApproveresult2txt("同意");
					} else if ("0".equals(rs.getString("approveresult2"))) {
						m.setApproveresult2txt("不同意");
					}
					m.setApproveperson2(rs.getString("approveperson2"));
					m.setApproveidea2(rs.getString("approveidea2"));
					String appdate2 = "";
					if ("".equals(rs.getString("aprrovedate2"))
							|| rs.getString("aprrovedate2") == null) {
					} else {
						appdate2 = rs.getString("aprrovedate2").split(" ")[0];
					}
					m.setAprrovedate2(appdate2);
					m.setApproveresult3(rs.getString("approveresult3"));
					if ("1".equals(rs.getString("approveresult3"))) {
						m.setApproveresult3txt("同意");
					} else if ("0".equals(rs.getString("approveresult3"))) {
						m.setApproveresult3txt("不同意");
					}
					m.setApproveperson3(rs.getString("approveperson3"));
					m.setApproveidea3(rs.getString("approveidea3"));
					String appdate3 = "";
					if ("".equals(rs.getString("aprrovedate3"))
							|| rs.getString("aprrovedate3") == null) {
					} else {
						appdate3 = rs.getString("aprrovedate3").split(" ")[0];
					}
					m.setAprrovedate3(appdate3);
					m.setApprovegoto(rs.getString("approvegoto"));
					m.setSerialno(rs.getString("serialno"));
					m.setCreatetime(rs.getString("createtime"));
					m.setApproveend(rs.getString("approveend"));
					if ("1".equals(rs.getString("approveend"))) {
						m.setApproveendtxt("同意救助");
					} else if ("0".equals(rs.getString("approveend"))) {
						m.setApproveendtxt("不同意救助");
					} else if ("-1".equals(rs.getString("approveend"))) {
						m.setApproveendtxt("作废");
					}
					m.setUpdatetime(rs.getString("updatetime"));
					m.setApprovemoney(rs.getString("approvemoney"));
					ms.add(m);
					// 打印
					HashMap map = new HashMap();
					map.put("familyno", rs.getString("familyno"));
					map.put("mastername", rs.getString("mastername"));
					map.put("paperid", rs.getString("paperid"));
					map.put("operstate", rs.getString("operstate"));
					map.put("qx", rs.getString("qx"));
					map.put("jd", rs.getString("jd"));
					map.put("sq", rs.getString("sq"));
					hm.add(map);
				}
				
				session.setAttribute("hm", hm);
				LinkedHashMap title = new LinkedHashMap();
				title.put("familyno", "家庭编号");
				title.put("mastername", "户主姓名");
				title.put("paperid", "身份证号码");
				title.put("operstate", "救助状态");
				title.put("qx", "区县");
				title.put("jd", "街道");
				title.put("sq", "社区");
				session.setAttribute("title", title);
				JSONObject json = new JSONObject();
				if (ms.size() > 0) {
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
				response.setContentType("application/text");// 需要设置ContentType
																// 为"application/x-json"
				PrintWriter pw = response.getWriter();
				pw.write(json.toString());
				pw.flush();
				pw.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (null != conn) {
					try {
						rs.close();
						ps.close();
						JdbcConnection.closeConnection();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
