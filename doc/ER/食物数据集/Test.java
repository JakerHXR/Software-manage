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
		    // 执行SQL查询
		    String sql = "SELECT * FROM Menu";
		    try (PreparedStatement statement = connection.prepareStatement(sql);
		         ResultSet resultSet = statement.executeQuery()) {
		        // 处理结果集
		        while (resultSet.next()) {
		            // 获取数据并进行处理
//		            int id = resultSet.getInt("Id");
//		            String name = resultSet.getString("Name");
//		            String taste = resultSet.getString("Taste");
//		            String tag = resultSet.getString("Tag");
		        

		            // 将数据转化为对象，然后转化为JSON
		            Menu m = new Menu();
		            m.setId(resultSet.getString(1));
		            m.setName(resultSet.getString(2));
		            m.setTaste(resultSet.getString(3));
		            m.setTag(resultSet.getString(4));
		            String json = new Gson().toJson(m);

		            // 处理 JSON 数据，可以打印或保存到文件等
		            System.out.println(json);
		        }
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}

}
