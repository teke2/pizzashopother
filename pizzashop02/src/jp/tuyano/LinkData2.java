package jp.tuyano;

import java.net.URL;
import java.util.Date;

import javax.jdo.annotations.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class LinkData2 {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	@Persistent
	private String title;

	@Persistent
	private String count;

	@Persistent
	private String eat;

	@Persistent
	private Date datetime;

	@Persistent
	private String price;

	@Persistent
	private String phone;

	@Persistent
	private String time;

	public LinkData2(String title, String count, String eat, Date datetime,
			String price, String phone, String time) {
		super();
		this.title = title;
		this.count = count;
		this.eat = eat;
		this.datetime = datetime;
		this.price = price;
		this.phone = phone;
		this.time = time;
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

	public String getEat() {
		return eat;
	}

	public void setEat(String eat) {
		this.eat = eat;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}