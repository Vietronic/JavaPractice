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
	    	// ����JDBC��������
	    	Class.forName("org.sqlite.JDBC");
	    	// �������ݿ�
	    	con = DriverManager.getConnection(dbInfoString);
	    	// ����Statment����
			stat = con.createStatement();
	    }catch( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	System.exit(0);
	    }	
	}
	
	public boolean loginUser(String name, char[] pwd) throws SQLException{
		// ִ�в�ѯ
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
		// ִ�в�ѯ���Ƿ��Ѿ�ע��
		try{
			String sql = "select * from user where name='"+name+"'";
			rs = stat.executeQuery(sql);
		}catch( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	System.exit(0);
	    }
		
		// ����û�����ע�ᣬ�򷵻�ע��ʧ��
		if (rs.next()){
			return false;
		} else{
			// δע�ᣬ��������
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
		// �ر�״̬�������������
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
