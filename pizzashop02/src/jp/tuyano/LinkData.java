package jp.tuyano;

import java.net.URL;
import java.util.Date;

import javax.jdo.annotations.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class LinkData {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	@Persistent
	private String title;

	@Persistent
	private String count;

	@Persistent
	private String address;

	@Persistent
	private Date datetime;

	@Persistent
	private String price;

	@Persistent
	private String phone;

	@Persistent
	private String haitatsu;

	@Persistent
	private String pay;

	public LinkData(String title, String count, String address, Date datetime,
			String price, String phone, String haitatsu, String pay) {
		super();
		this.title = title;
		this.count = count;
		this.address = address;
		this.datetime = datetime;
		this.price = price;
		this.phone = phone;
		this.haitatsu = haitatsu;
		this.pay = pay;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHaitatsu() {
		return haitatsu;
	}

	public void setHaitatsu(String haitatsu) {
		this.haitatsu = haitatsu;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

}