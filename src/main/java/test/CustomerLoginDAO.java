package test;
import java.sql.*;


public class CustomerLoginDAO {
	public CustomerBean cb=null;
	public CustomerBean Login(String uName,String pWord) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("select * from Customer77 where uname=? and pword=?");
			ps.setString(1, uName);
			ps.setString(2, pWord);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				 cb=new CustomerBean();
				 cb.setuName(rs.getString(1));
				 cb.setpWord(rs.getString(2));
				 cb.setfName(rs.getString(3));
				 cb.setlName(rs.getString(4));
				 cb.setAddr(rs.getString(5));
				 cb.setmId(rs.getString(6));
				 cb.setPhno(rs.getLong(7));
			}
			
		}catch(Exception e) {e.printStackTrace();}
		return cb;
	}

}
