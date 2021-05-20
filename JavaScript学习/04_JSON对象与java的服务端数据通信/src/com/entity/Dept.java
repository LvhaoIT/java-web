package com.entity;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/20
 * Time: 23:27
 */
public class Dept {
    private Integer deptNo;
    private String deptName;
    private String loc;

    public Dept() {
    }

    public Dept(Integer deptNo, String deptName, String loc) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.loc = loc;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
