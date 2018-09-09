package com.skyhospital.tools;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadingUtil {
	
	/**
	 * 上传logo图片
	 * @param request
	 * @param attach  文件
	 * @param newFileName 新文件名APK
	 * @return 对象
	 */
	public static AppReturn uploadingLogoFile(HttpServletRequest request,
								MultipartFile attach,String newFileName){
		AppReturn appReturn=null;
		//图片判断是否为空
		if(!attach.isEmpty()){
			//文件要上传的位置(request.getSession().getServletContext())
			String path = request.getSession().getServletContext().getRealPath("statics"+ File.separator+"uploadfiles");
			//原文件名
			String oldFileName = attach.getOriginalFilename();
			//原文件后缀
			String prefix = FilenameUtils.getExtension(oldFileName);
			if(attach.getSize() > Constants.FILEUPLOAD_FILESIZE){//上传大小不得超过 50k
				//上传的文件过大
				appReturn=AppReturn.build(400,"上传文件过大", null);
				//上传图片格式验证
            }else if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") 
            		||prefix.equalsIgnoreCase("jepg") || prefix.equalsIgnoreCase("pneg")){
				 String fileName = newFileName + ".jpg";//上传LOGO图片命名:apk名称.jpg
				 File targetFile = new File(path,fileName); //将文件上传位置 path 、图片名称 fileName  加入file中
				 if(!targetFile.exists()){//判断文件是否存在
					 targetFile.mkdirs(); //生成所有目录
				 }
				 try {
					attach.transferTo(targetFile);//上传文件到指定的位置path，并将文件名称修改为我们指定的 fileName
					FileReturn fileReturn=new FileReturn();
					//文件url路径
					fileReturn.setLocPath(path+File.separator+fileName);
					//服务器存储的根路径
					fileReturn.setPicPath(request.getContextPath()+"/statics/uploadfiles/"+fileName);
					appReturn=AppReturn.ok(fileReturn);
				 } catch (Exception e) {
					e.printStackTrace();
					//上传失败
					appReturn=AppReturn.build(400,"上传失败", null);
				}
            }else{
            	appReturn=AppReturn.build(400,"上传文件格式错误", null);
            }
		}
		return appReturn;
	}
	
	/**
	 *  上传APK文件
	 * @param request
	 * @param attach 文件
	 * @param newFileName   APK名称
	 * @param versionNo 版本号
	 * @return
	 */
	public static AppReturn uploadingAPKFile(HttpServletRequest request,MultipartFile attach,String newFileName,String versionNo){
		AppReturn appReturn=null;
		//图片判断是否为空
		if(!attach.isEmpty()){
			//文件要上传的位置
			String path = request.getSession().getServletContext().getRealPath("statics"+ File.separator+"uploadfiles");
			//原文件名
			String oldFileName = attach.getOriginalFilename();
			//原文件后缀
			String prefix = FilenameUtils.getExtension(oldFileName);
			if(attach.getSize() > Constants.FILEUPLOAD_APKFILESIZE){//上传大小不得超过 500M
				//上传的文件过大
				appReturn=AppReturn.build(400,"上传文件过大", null);
				//上传图片格式验证
            }else if(prefix.equalsIgnoreCase("apk")){
				 String fileName = newFileName+versionNo+ ".apk";//上传apk文件命名:apk名称+版本号+.apk
				 File targetFile = new File(path,fileName); //将文件上传位置 path 、文件名称 fileName  加入file中
				 if(!targetFile.exists()){//判断文件是否存在
					 targetFile.mkdirs(); //生成所有目录
				 }
				 try {
					attach.transferTo(targetFile);//上传文件到指定的位置path，并将文件名称修改为我们指定的 fileName
					FileReturn fileReturn=new FileReturn();
					//文件url路径
					fileReturn.setLocPath(path+File.separator+fileName);
					//服务器存储的根路径
					fileReturn.setPicPath(request.getContextPath()+"/statics/uploadfiles/"+fileName);
					//新拼接的文件名
					fileReturn.setFileName(fileName);
					appReturn=AppReturn.ok(fileReturn);
				 } catch (Exception e) {
					e.printStackTrace();
					//上传失败
					appReturn=AppReturn.build(400,"上传失败", null);
				}
            }else{
            	appReturn=AppReturn.build(400,"上传文件格式错误", null);
            }
		}
		return appReturn;
	}
	
	
	
	
}
