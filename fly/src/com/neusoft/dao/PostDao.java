package com.neusoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.bean.Post;
import com.neusoft.bean.PostClass;
import com.neusoft.util.DButil;

public class PostDao {
	// 帖子点击数+1
	public void addPostClick(int pid) {
		DButil db = DButil.getInstance();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = db.getConnection();
			String sql = " update bbs_post set click=click+1" + " where pid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(ps);
			db.close(conn);
		}

	}

	// 根据帖子id查询
	public Post selById(int pid) {

		DButil db = DButil.getInstance();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			String sql = " select * from bbs_post " + " where pid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Post p = new Post();
				PostClass pc = new PostClass();
				p.setPid(rs.getInt("pid"));
				p.setTitle(rs.getString("title"));
				p.setContent(rs.getString("content"));
				p.setClick(rs.getInt("click"));
				p.setRevert(rs.getInt("revert"));
				pc.setId(rs.getInt("pcid"));
				p.setPcid(pc);
				p.setStartime(rs.getDate("startime"));
				p.setNickName(rs.getString("nickname"));
				return p;
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

	// 查询所有帖子
	public List<Post> selAllPost() {
		DButil db = DButil.getInstance();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Post> list = new ArrayList<Post>();
		try {
			conn = db.getConnection();
			String sql = " select * from bbs_post ";
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				Post p = new Post();
				PostClass pc = new PostClass();
				p.setTitle(rs.getString("title"));
				p.setContent(rs.getString("content"));
				p.setClick(rs.getInt("click"));
				p.setRevert(rs.getInt("revert"));
				pc.setId(rs.getInt("pcid"));
				p.setPcid(pc);
				p.setStartime(rs.getDate("startime"));
				p.setNickName(rs.getString("nickname"));
				p.setPid(rs.getInt("pid"));
				list.add(p);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(ps);
			db.close(rs);
			db.close(conn);
		}

		return null;
	}
}
