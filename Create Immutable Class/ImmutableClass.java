import java.util.Date;

public final class ImmutableClass {
	
	private final Integer ImmutableObj1;
	
	private final String str;
	
	private final Date date;

	public ImmutableClass(Integer immutableObj1, String str, Date date) {

		this.ImmutableObj1 = immutableObj1;
		this.str = str;
		this.date = new Date(date.getTime());
	}

	public Integer getImmutableObj1() {
		return ImmutableObj1;
	}

	public String getStr() {
		return str;
	}
	
	public Date getDate() {
		return new Date(date.getTime());
	}
	
	
public static void main(String[] args) {
	Date dt = new Date();
	ImmutableClass im = new ImmutableClass(1,"Start", new Date(dt.getTime()));
	
	System.out.println(im.getStr()+"--"+im.getDate()+"--"+im.getImmutableObj1());
}
}
