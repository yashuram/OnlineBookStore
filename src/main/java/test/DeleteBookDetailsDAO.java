package test;
import java.sql.*;

public class DeleteBookDetailsDAO {
	public int k=0;
	public int delete(BookBean bb) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("delete  from BookDetails77 where code=? ");
			ps.setString(1, bb.getCode());
			ps.execute();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}

}
