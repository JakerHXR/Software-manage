package Main;

public class Menu {

	private String Name;
	private String Taste;
	private String Tag;
	private String Id;

	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getTaste() {
		return Taste;
	}
	public void setTaste(String taste) {
		this.Taste = taste;
	}
	public String getTag() {
		return Tag;
	}
	public void setTag(String tag) {
		this.Tag = tag;
	}
}
