package homework_5;

import java.sql.*;

import org.sqlite.*;

public class db_process {
	public static final String dbInfoString = "jdbc:sqlite:JavaLesson.db";
	Connection con = null;
	Statement stat = null;
	ResultSet rs = null;
	
	public db_process(){
		try{
	    	// 加载JDBC驱动程序
	    	Class.forName("org.sqlite.JDBC");
	    	// 连接数据库
	    	con = DriverManager.getConnection(dbInfoString);
	    	// 建立Statment对象
			stat = con.createStatement();
	    }catch( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	System.exit(0);
	    }	
	}
	
	public boolean loginUser(String name, char[] pwd) throws SQLException{
		// 执行查询
		try{
			String sql = "Select * from user where name='"+name+"' and pwd='"+String.valueOf(pwd)+"'";
			rs = stat.executeQuery(sql);
		}catch( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	System.exit(0);
	    }
		
		if (rs.next()){
			return true;
		} else{
			return false;
		}
	}
	
	public boolean regUser(String name, char[] pwd) throws SQLException{
		// 执行查询，是否已经注册
		try{
			String sql = "select * from user where name='"+name+"'";
			rs = stat.executeQuery(sql);
		}catch( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	System.exit(0);
	    }
		
		// 如果用户名已注册，则返回注册失败
		if (rs.next()){
			return false;
		} else{
			// 未注册，插入数据
			try{
				String sql = "insert into user(name,pwd) values('"+name+"','"+String.valueOf(pwd)+"')";
				stat.executeUpdate(sql);
			}catch( Exception e ) {
		    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    	System.exit(0);
		    }
			return true;
		}
	}
	
	public void close() throws SQLException{
		// 关闭状态，结果集和连接
		try{
			rs.close();
			stat.close();
			con.close();
		}catch( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	System.exit(0);
	    }
	}
}
