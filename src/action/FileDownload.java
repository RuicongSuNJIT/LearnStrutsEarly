package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownload extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4384469196935532848L;

	private String path;
	private String contentType;
	private String fileName;
	private InputStream targetFile;

	public void setPath(String path) {
		this.path = path;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getTargetFile() {
		return targetFile;
	}

	@Action(value = "download", results = {
			// contentType文件类型，${}给contentType赋值（赋了本class相应变量的值），因为只能通过annotation给content赋值。inputName和targetFile是一对，inputName指的是相应inputstream的变量值，
			//contentdiposition是下载时候的保存成的文件的名字。这里的type,params...等等是返回到浏览器的。
			@Result(name = "success", type = "stream", params = { "contentType",
					"${contentType}", "inputName", "targetFile",
					"contentDisposition",
					"attachment;filename=\"${fileName}\"" }),
			@Result(name = "error", location = "/error.jsp") })
	public String download() throws Exception {
		File file = new File("D:/JavaDevelopment/Data/" + path);
		if (!file.exists()) {
			return ERROR;
		}
		//得到文件的类型
		contentType = Files.probeContentType(file.toPath());
		String[] pathSplit = path.split("/");
		fileName = pathSplit[pathSplit.length - 1];
		//中文文件名是乱码，所以要转换
		fileName = new String(fileName.getBytes(), "iso-8859-1");
		//file的内容是inputstream要读的内容
		targetFile = new FileInputStream(file);
		return SUCCESS;
	}

}
