package prs.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	@Column(name = "IsReviewer")
	private boolean reviewer;
	@Column(name = "IsAdmin")
	private boolean admin;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
	//private LocalDateTime dateCreated;
	
	public User() {
		userName = "";
		password ="";
	}

	public User(int id, String userName, String password, String firstName, String lastName, String phone,
			String email, boolean reviewer, boolean admin) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.reviewer = reviewer;
		this.admin = admin;
	}
	
	public User(String un, String pw, String fn, String ln, String pn, String e, boolean m, boolean a) {
		setUserName(un);
		setPassword(pw);
		setFirstName(fn);
		setLastName(ln);
		setPhone(pn);
		setEmail(e);
		setReviewer(m);
		setAdmin(a);
	}
	
	public boolean isReviewer() {
		return reviewer;
	}

	public void setReviewer(boolean reviewer) {
		this.reviewer = reviewer;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//public Timestamp getDateCreated() {
	//	return dateCreated;
	//}

	//public void setDateCreated(Timestamp dateCreated) {
	//	this.dateCreated = dateCreated;
	//}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phone=" + phone + ", email=" + email + ", reviewer=" + reviewer
				+ ", admin=" + admin //+ ", dateCreated=" + dateCreated+""
						+ "]";
	}
	
	

//	@Override
//	public String toString() {
//		String userinfo =
//				"User:	id=" +id+", username=" +username+", password="+password+", firstName="+firstName+", lastName="
//						+lastName+", phone="+phone+", email"+email+", reviewer="+reviewer+", admin="+admin +"\n";
//				return userinfo;
//		
//	}
	
}