package com.yang.common.utils;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.net.URLDecoder;


public class FastDFSClient {

	private TrackerClient trackerClient = null;
	private TrackerServer trackerServer = null;
	private StorageServer storageServer = null;
	private StorageClient1 storageClient = null;
	// fdfsclient的配置文件的路径
	
	private String CONF_NAME = "/fdfs/fdfs_client.conf";

	public FastDFSClient() throws Exception {

		// 配置文件必须指定全路径
		String confName = this.getClass().getResource(CONF_NAME).getPath();
		// 配置文件全路径中如果有中文，需要进行utf8转码
		confName = URLDecoder.decode(confName, "utf8");

		ClientGlobal.init(confName);
		trackerClient = new TrackerClient();
		trackerServer = trackerClient.getConnection();
		storageServer = null;
		storageClient = new StorageClient1(trackerServer, storageServer);
	}

	/**
	 * 上传文件方法
	 * <p>
	 * Title: uploadFile
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param fileName
	 *            文件全路径
	 * @param extName
	 *            文件扩展名，不包含（.）
	 * @param metas
	 *            文件扩展信息
	 * @return
	 * @throws Exception
	 */
	public String uploadFile(String fileName, String extName, NameValuePair[] metas) throws Exception {
		String result = storageClient.upload_file1(fileName, extName, metas);
		return result;
	}

	public String uploadFile(String fileName) throws Exception {
		String extName = null;
		return uploadFile(fileName, extName, null);
	}

	public String uploadFile(String fileName, String extName) throws Exception {
		return uploadFile(fileName, extName, null);
	}

	/**
	 * 上传文件方法
	 * <p>
	 * Title: uploadFile
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param fileContent
	 *            文件的内容，字节数组
	 * @param extName
	 *            文件扩展名
	 * @param metas
	 *            文件扩展信息
	 * @return
	 * @throws Exception
	 */
	public String uploadFile(byte[] fileContent, String extName, NameValuePair[] metas) throws Exception {

		String result = storageClient.upload_file1(fileContent, extName, metas);
		return result;
	}

	public String uploadFile(byte[] fileContent) throws Exception {
		return uploadFile(fileContent, null, null);
	}

	public String uploadFile(byte[] fileContent, String extName) throws Exception {
		return uploadFile(fileContent, extName, null);
	}
	/**
	 * 指定分组上传
	 * @param gropName
	 * @param fileContent
	 * @param extName
	 * @return
	 * @throws Exception
	 */
	public String uploadFile(String gropName, byte[] fileContent, String extName) throws Exception {
		return storageClient.upload_file1(gropName,fileContent, extName, null);
	}
	
	/**
	 * 根据路径删除图片服务器上的图片
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public String deleteFile(String oldPath) throws Exception {
		Integer num = storageClient.delete_file1(oldPath);
		return (num==0 ? "删除成功":"删除失败");
	}
}

