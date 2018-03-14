package action;

import java.io.File;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class FileUpload extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -79070811354184957L;

	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private long fileSize;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	@Action(value = "fileUpload", interceptorRefs = {
			//params里的key是你用的拦截器里边有的key名字，是规定的，自己查
			@InterceptorRef(value = "fileUpload", params = { "allowedTypes",
					//A/B这种A是大类型eg:application,audio,image,text..B是小类型eg:png..
					"image/*" }),
			//使用了拦截器的话要加入defaultstack拦截器
			@InterceptorRef(value = "defaultStack") }, results = {
					@Result(name = "success", location = "/succFileUpload.jsp"),
					@Result(name = "input", location = "/fileUpload.jsp") })
	public String fileUpload() throws Exception {
		setFileSize(upload.length());

		return SUCCESS;
	}
}
