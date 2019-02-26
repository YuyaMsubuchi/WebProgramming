package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import model.User;

public class UserDao {
	public User findByLoginInfo(String loginId, String password) {
        Connection conn = null;
        try {

            conn = DBmanager.getConnection();

            String souse = password;

          Charset charset = StandardCharsets.UTF_8;

          String algorithm = "MD5";


          byte[] bytes =  null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(souse.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
          String result = DatatypeConverter.printHexBinary(bytes);

          System.out.println(result);



            String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";


            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, result);
            ResultSet rs = pStmt.executeQuery();

            if (!rs.next()) {
                return null;
            }
            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            return new User(loginIdData, nameData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
	}

	public List<User> findAll(){
		Connection conn = null;
		List<User> userlist = new ArrayList<User>();

		try {
			conn = DBmanager.getConnection();

			String sql = "SELECT * FROM user WHERE id > 2 ";

			Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

	        while (rs.next()) {
	        	int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

                userlist.add(user);
	        }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userlist;
	}
	public List<User> findAll(String loginId,String name, String birthDate1,String birthDate2){
		Connection conn = null;
		List<User> userlist = new ArrayList<User>();

		try {
			conn = DBmanager.getConnection();

			String sql = "SELECT * FROM user WHERE id > 2 ";

			if (!loginId.equals("")) {
				sql += " AND login_id = '" + loginId + "'";
			}

			if (!name.equals("")) {
				sql += " AND name LIKE '%" +name + "%'";
			}
			if(!birthDate1.equals("")) {
				sql += "AND birth_date >= '"+ birthDate1+"'  ";
			}
			if(!birthDate2.equals("")) {
				sql += "AND birth_date <= '"+ birthDate2+"'  ";
			}

			System.out.println(sql);

			Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

	        while (rs.next()) {
	        	int id = rs.getInt("id");
                String LoginId = rs.getString("login_id");
                String Name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, LoginId, Name, birthDate, password, createDate, updateDate);

                userlist.add(user);
	        }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userlist;
	}
        public void InsertUser(String loginId, String password, String name,String birthDate ) throws SQLException {
        	Connection conn = null;
        	try {
        		conn = DBmanager.getConnection();

        		//ハッシュを生成したい元の文字列
        		String source = password;
        		//ハッシュ生成前にバイト配列に置き換える際のCharset
        		Charset charset = StandardCharsets.UTF_8;
        		//ハッシュアルゴリズム
        		String algorithm = "MD5";

        		//ハッシュ生成処理
        		byte[] bytes = null;
				try {
					bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
				} catch (NoSuchAlgorithmException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
        		String result = DatatypeConverter.printHexBinary(bytes);



        		String sql = "INSERT into user(login_id,password,name,birth_date,create_date,update_date) VALUES( ?,  ?,  ?,  ?,now(),now())";

        		PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, loginId);
                pStmt.setString(2, result);
                pStmt.setString(3, name);
                pStmt.setString(4, birthDate);
                pStmt.executeUpdate();

        	}catch (SQLException e) {
                    e.printStackTrace();
                    throw e;

                } finally {

                    if (conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException e) {
                            e.printStackTrace();

                        }

		}
}
        }
        public User UserRead(String id) {
        	Connection conn = null;
        	try {
        		conn = DBmanager.getConnection();

        		String sql = "SELECT * FROM user WHERE id = ? ";

        		PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, id);
                ResultSet rs = pStmt.executeQuery();

                while (rs.next()) {

                	int Id = rs.getInt("id");
                    String loginId = rs.getString("login_id");
                    String name = rs.getString("name");
                    Date birthDate = rs.getDate("birth_date");
                    String password = rs.getString("password");
                    String createDate = rs.getString("create_date");
                    String updateDate = rs.getString("update_date");

                    User user = new User(Id,loginId, name, birthDate, password, createDate, updateDate);
                    return user;
                }
                }catch (SQLException e) {
                    e.printStackTrace();

                } finally {

                    if (conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException e) {
                            e.printStackTrace();

                        }

		}
}
return null;
        }

        public void UserRe(String password,String name,String birthDate,String id) {
        	Connection conn = null;
        	try {
        		conn = DBmanager.getConnection();

                String source = password;

        		Charset charset = StandardCharsets.UTF_8;

        		String algorithm = "MD5";


        		byte[] bytes = null;
				try {
					bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
				} catch (NoSuchAlgorithmException e) {

					e.printStackTrace();
				}
        		String result = DatatypeConverter.printHexBinary(bytes);


        		String sql = "UPDATE user SET password=?,name=?,birth_date=?,update_date=now() WHERE id=?";

        		PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, result);
                pStmt.setString(2, name);
                pStmt.setString(3, birthDate);
                pStmt.setString(4, id);

                pStmt.executeUpdate();

        	}catch (SQLException e) {
                e.printStackTrace();

            } finally {

                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();

                    }

	}
}
        }
        public void UserRe2(String name,String birthDate,String id) {
        	Connection conn = null;
        	try {
        		conn = DBmanager.getConnection();


        		String sql = "UPDATE user SET name=?,birth_date=?,update_date=now() WHERE id=?";

        		PreparedStatement pStmt = conn.prepareStatement(sql);

                pStmt.setString(1, name);
                pStmt.setString(2, birthDate);
                pStmt.setString(3, id);

                pStmt.executeUpdate();

        	}catch (SQLException e) {
                e.printStackTrace();


            } finally {

                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();

                    }

	}
}
        }
        public void UserDe(String id) {
        	Connection conn = null;
        	try {
        		conn = DBmanager.getConnection();

        		String sql = "DELETE FROM user WHERE id = ?";

        		PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, id);
                pStmt.executeUpdate();

        	}catch (SQLException e) {
                e.printStackTrace();

            } finally {

                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();

                    }

	}
}
        }
        }





