package test.com.model;

import java.sql.Date;
import java.util.Objects;

public class TravelVO {
	private String attraction;
	private String location;
	private String content;
	private String tdate;
	private String save_file_name;
	private String id;
	private String pw;
	private Date save_date;

	public String getAttraction() {
		return attraction;
	}

	public void setAttraction(String attraction) {
		this.attraction = attraction;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTdate() {
		return tdate;
	}

	public void setTdate(String tdate) {
		this.tdate = tdate;
	}

	public String getSave_file_name() {
		return save_file_name;
	}

	public void setSave_file_name(String save_file_name) {
		this.save_file_name = save_file_name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Date getSave_date() {
		return save_date;
	}

	public void setSave_date(Date save_date) {
		this.save_date = save_date;
	}

	@Override
	public String toString() {
		return "TravelVO [attraction=" + attraction + ", location=" + location + ", content=" + content + ", tdate="
				+ tdate + ", save_file_name=" + save_file_name + ", id=" + id + ", pw=" + pw + ", save_date="
				+ save_date + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(attraction, content, id, location, pw, save_date, save_file_name, tdate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TravelVO other = (TravelVO) obj;
		return Objects.equals(attraction, other.attraction) && Objects.equals(content, other.content)
				&& Objects.equals(id, other.id) && Objects.equals(location, other.location)
				&& Objects.equals(pw, other.pw) && Objects.equals(save_date, other.save_date)
				&& Objects.equals(save_file_name, other.save_file_name) && Objects.equals(tdate, other.tdate);
	}

}
