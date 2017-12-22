package com.neusoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.neusoft.bean.Post;
import com.neusoft.bean.User;
import com.neusoft.util.DButil;

public class UserDao {

	// 减少飞吻数
	public void deleteKiss(int kissNum) {
		DButil db = DButil.getInstance();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = db.getConnection();
			String sql = "update bbs_userinfo set kiss_num=kiss_num-? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, kissNum);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close(ps);
			db.close(conn);

		}
	}

	// 发帖
	public boolean userPost(Post p) {
		DButil db = DButil.getInstance();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = db.getConnection();
			String sql = "INSERT into bbs_post (title,startime,content,pcid,nickName)" + " values(?,now(),?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getTitle());
			ps.setString(2, p.getContent());
			ps.setObject(3, p.getPcid().getId());
			ps.setString(4, p.getNickName());
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close(ps);
			db.close(conn);

		}
		return false;
	}

	// 登录
	public User userLogin(String email) {
		DButil db = DButil.getInstance();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			String sql = " select * from bbs_userinfo " + " where email=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setNickName(rs.getString("nickname"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(ps);
			db.close(rs);
			db.close(conn);
		}

		return null;
	}

	// 用户注册
	public void userReg(User user) {
		DButil db = DButil.getInstance();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = db.getConnection();
			String sql = "INSERT into bbs_userinfo (email,nickname,password)" + " values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getNickName());
			ps.setString(3, user.getPassword());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close(ps);
			db.close(conn);

		}
	}
}
