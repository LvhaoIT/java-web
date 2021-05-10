package com.Dao;

import com.entity.Question;
import com.til.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/10
 * Time: 10:36
 */
public class QusetDao {
    private JdbcUtil util = new JdbcUtil();

    public int add(Question que) {
        int result = 0;
        String sql = "insert into question(title,optionA,optionB,optionC,optionD,answer) values(?,?,?,?,?,?)";

        PreparedStatement ps = this.util.createStatement(sql);
        try {
            ps.setString(1, que.getTitle());
            ps.setString(2, que.getOptionA());
            ps.setString(3, que.getOptionB());
            ps.setString(4, que.getOptionC());
            ps.setString(5, que.getOptionD());
            ps.setString(6, que.getAnswer());
            result = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            this.util.close();
        }
        return result;
    }

    public void findAll(List list) {
        String sql = "select * from question order by questionId asc";
        PreparedStatement ps = this.util.createStatement(sql);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Question que = new Question(rs.getInt("questionId"),
                        rs.getString("title"),
                        rs.getString("optionA"),
                        rs.getString("optionB"),
                        rs.getString("optionC"),
                        rs.getString("optionD"),
                        rs.getString("answer"));

                list.add(que);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            this.util.close(rs);
            this.util.close();
        }
    }

    public int delete(Integer id) {
        int result = 0;
        String sql = "delete from question where questionId=?";
        PreparedStatement ps = this.util.createStatement(sql);
        try {
            ps.setInt(1, id);
            result = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    /**
     * 查找一个quest对象
     */
    public Question findOne(Integer id) {
        Question que = null;
        ResultSet rs = null;
        String sql = "select * from question where questionId=?";
        PreparedStatement ps = this.util.createStatement(sql);
        try {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                que = new Question(rs.getInt("questionId"),
                        rs.getString("title"),
                        rs.getString("optionA"),
                        rs.getString("optionB"),
                        rs.getString("optionC"),
                        rs.getString("optionD"),
                        rs.getString("answer"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return que;
    }

    public int updata(Question que) {
        int result = 0;
        String sql = "update question set title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where  questionId=? ";
        PreparedStatement ps = this.util.createStatement(sql);
        try {
            ps.setString(1, que.getTitle());
            ps.setString(2, que.getOptionA());
            ps.setString(3, que.getOptionB());
            ps.setString(4, que.getOptionC());
            ps.setString(5, que.getOptionD());
            ps.setString(6, que.getAnswer());
            ps.setInt(7, que.getQueestionID());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            this.util.close();
        }
        return result;
    }
}
