package com.mingda.biz.temp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import com.mingda.dto.OrgDTO;


@WebServlet(name = "TempOrg", urlPatterns = { "/TempOrg" })
public class TempOrg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TempOrg() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	@SuppressWarnings({ "static-access" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String orgno = request.getParameter("orgno");
		String ds = (String)session.getAttribute("ds");
		JdbcConnection db = new JdbcConnection(ds);
		Connection conn = null;
		try {
			response.setContentType("text/html;charset=UTF-8");
			conn = db.getConnection();
			String sql = "select * from ORGANNO t where t.on_no =? or t.on_fatherid=? order by t.on_no";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, orgno);
			pst.setString(2, orgno);
			List<OrgDTO> orglist = new ArrayList<OrgDTO>();
			ResultSet rs = pst.executeQuery();
			while(rs.next())
	        {
				OrgDTO o = new OrgDTO();
				o.setOn_no(rs.getString("on_no"));
				o.setOn_id(rs.getString("on_id"));
				o.setOn_name(rs.getString("on_name"));
				o.setOn_level(rs.getString("on_level"));
				o.setOn_fatherid(rs.getString("on_fatherid"));
				o.setOn_allname(rs.getString("on_allname"));
				if(orgno.equals(rs.getString("on_no"))){
					o.setSelected("true");
				}
				orglist.add(o);
	        }
			JSONArray jsArr = JSONArray.fromObject(orglist);
			response.setContentType("application/x-json");//需要设置ContentType 为"application/x-json"
		    PrintWriter pw = response.getWriter();
		    pw.write(jsArr.toString());
		    rs.close();
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
