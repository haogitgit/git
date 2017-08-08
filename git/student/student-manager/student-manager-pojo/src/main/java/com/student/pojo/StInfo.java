package com.student.pojo;

import java.util.Date;

public class StInfo {
    private Long id;

    private String number;

    private String name;

    private String sex;

    private String identity;

    private String nation;

    private String session;

    private String major;

    private String classes;

    private String phone;

    private String graduated;

    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session == null ? null : session.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes == null ? null : classes.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getGraduated() {
        return graduated;
    }

    public void setGraduated(String graduated) {
        this.graduated = graduated == null ? null : graduated.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

	@Override
	public String toString() {
		return "StInfo [number=" + number + ", name=" + name + ", sex=" + sex + ", identity=" + identity + ", nation="
				+ nation + ", session=" + session + ", major=" + major + ", classes=" + classes + ", phone=" + phone
				+ ", graduated=" + graduated + ", created=" + created + "]";
	}
    
    
}