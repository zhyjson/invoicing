package cn.wdu4.invoicing.pojo;

import java.io.Serializable;

/**
 *
* <p>Title: Emp</p>
* <p>Description: 员工表实体 12.8引入员工头像与员工昵称 实现了Serializable序列化接口</p>
* @author zhy
* @date 2018年11月21日
 */
public class Emp implements Serializable{
	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	// 员工ID
	private Integer empId;
	// 员工登录名
	private String empName;
	// 员工密码
	private String empPassword;
	// 员工电话
	private String empTelephone;
	// 员工昵称
	private String empNickName;
	// 员工头像
	private String empFaceUrl;

	@Override
	public String toString() {
		return "Emp{" +
				"empId=" + empId +
				", empName='" + empName + '\'' +
				", empPassword='" + empPassword + '\'' +
				", empTelephone='" + empTelephone + '\'' +
				", empNickName='" + empNickName + '\'' +
				", empFaceUrl='" + empFaceUrl + '\'' +
				'}';
	}

	public Emp(Integer empId, String empName, String empPassword, String empTelephone, String empNickName, String empFaceUrl) {
		this.empId = empId;
		this.empName = empName;
		this.empPassword = empPassword;
		this.empTelephone = empTelephone;
		this.empNickName = empNickName;
		this.empFaceUrl = empFaceUrl;
	}

	public Emp() {
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpTelephone() {
		return empTelephone;
	}

	public void setEmpTelephone(String empTelephone) {
		this.empTelephone = empTelephone;
	}

	public String getEmpNickName() {
		return empNickName;
	}

	public void setEmpNickName(String empNickName) {
		this.empNickName = empNickName;
	}

	public String getEmpFaceUrl() {
		return empFaceUrl;
	}

	public void setEmpFaceUrl(String empFaceUrl) {
		this.empFaceUrl = empFaceUrl;
	}
}
