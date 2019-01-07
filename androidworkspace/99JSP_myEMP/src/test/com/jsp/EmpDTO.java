package test.com.jsp;

public class EmpDTO {
	
	private int bno;
	private String writer;
	private String contents;
	

	public EmpDTO(int bno, String writer, String contents) {
		super();
		this.bno = bno;
		this.writer = writer;
		this.contents = contents;
	}

	public EmpDTO() {
		super();
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	
	
}
