package test;
import java.sql.*;


public class AdminLoginDAO {
	public AdminBean ab=null;
	public AdminBean Login(String uName,String pWord) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from Admin77 where uname=? and pword=?");
			ps.setString(1, uName);
			ps.setString(2, pWord);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ab=new AdminBean();
				ab.setuName(rs.getString(1));
				ab.setpWord(rs.getString(2));
				ab.setfName(rs.getString(3));
				ab.setlName(rs.getString(4));
				ab.setAddr(rs.getString(5));
				ab.setmId(rs.getString(6));
				ab.setPhno(rs.getLong(7));
			}
		}catch(Exception e) {e.printStackTrace();}
		return ab;
	}

}
