package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.google.gson.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/menu";
		String user = "root";
		String password = "123";

		try (Connection connection = DriverManager.getConnection(url, user, password)) {
		    // ִ��SQL��ѯ
		    String sql = "SELECT * FROM Menu";
		    try (PreparedStatement statement = connection.prepareStatement(sql);
		         ResultSet resultSet = statement.executeQuery()) {
		        // ��������
		        while (resultSet.next()) {
		            // ��ȡ���ݲ����д���
//		            int id = resultSet.getInt("Id");
//		            String name = resultSet.getString("Name");
//		            String taste = resultSet.getString("Taste");
//		            String tag = resultSet.getString("Tag");
		        

		            // ������ת��Ϊ����Ȼ��ת��ΪJSON
		            Menu m = new Menu();
		            m.setId(resultSet.getString(1));
		            m.setName(resultSet.getString(2));
		            m.setTaste(resultSet.getString(3));
		            m.setTag(resultSet.getString(4));
		            String json = new Gson().toJson(m);

		            // ���� JSON ���ݣ����Դ�ӡ�򱣴浽�ļ���
		            System.out.println(json);
		        }
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}

}
