package hello;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="status_id")
	private long statusId;
	private String message;
	private Time postedAt;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	protected Status() {

	}

	public Status(User user, String message, Time postedAt) {
		this.user = user;
		this.message = message;
		this.postedAt = postedAt;
	}



	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Time getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(Time postedAt) {
		this.postedAt = postedAt;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Status [msg='%s', postedAt='%s']", this.message, this.postedAt.toString());
	}
}
