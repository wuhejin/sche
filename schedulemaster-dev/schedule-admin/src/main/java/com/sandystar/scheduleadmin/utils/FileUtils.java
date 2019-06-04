package com.sandystar.scheduleadmin.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;

public class FileUtils {

    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    /**
     * Description: 检查文件夹是否存在，不存在则创建。
     * Author:  suwenlong
     * Date: 2018/5/2 10:39
     **/
    public static boolean fileFoldCheck(String filePath){

        File file = new File(filePath);
        if( !file.exists() ){
           return file.mkdirs();
        }
        return true;
    }


    /**
     * Description: 从远程url 下载文件， 可能返回null
     * Author:  suwenlong
     * Date: 2018/5/10 17:27
    **/
    public static String downloadFromUrl(String urlStr, String fileName){

        logger.info("upload-file| start ! fileName:{}", fileName);
        int bytesum = 0;
        int byteread = 0;

        try {
            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream(fileName);

            byte[] buffer = new byte[1204];
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                fs.write(buffer, 0, byteread);
            }
            logger.info("Upload-file| end ! fileName:{} ,filesize:{}", fileName,bytesum);
        } catch (FileNotFoundException e) {
            logger.error("Download-File-Exception | ", e);
            return null;
        } catch (IOException e) {
            logger.error("Download-File-Exception | ", e);
            return null;
        }
        return fileName;
    }

    /**
     * Description: 文件大小转换
     * Author:  suwenlong
     * Date: 2018/5/3 21:30
    **/
    public static String fileSizeExchange(Long fileSize){

        if(fileSize ==null){
            return "0";
        }
        if(fileSize<1024){
            return fileSize.toString()+"B";
        }

        double kiloByte = fileSize/1024;
        if(kiloByte < 1024) {
            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
            return result1.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "KB";
        }

        double megaByte = kiloByte/1024;
        if(megaByte < 1024) {
            BigDecimal result2  = new BigDecimal(Double.toString(megaByte));
            return result2.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "MB";
        }

        double teraBytes = megaByte/1024;
        if(teraBytes < 1024) {
            BigDecimal result3 = new BigDecimal(Double.toString(teraBytes));
            return result3.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
        }
        return fileSize + "Byte(s)";
    }


    
    /**
     * Description: 删除文件夹，以及文件夹下的文件。
     * Author:  suwenlong
     * Date: 2018/5/28 15:48
    **/
    public static void deleteFiles(String filePath){

        File file = new File(filePath);
        if( !file.exists() ){
            logger.error("Delete-File-While-File-Not-Exist | file not exist . filePath:{} ",filePath);
            return ;
        }
        if (!file.isDirectory()) {
            return ;
        }

        String[] tempList = file.list();
        File temp = null;
        for(int i = 0; i < tempList.length; i++) {
            if(filePath.endsWith(File.separator)) {
                temp = new File(filePath + tempList[i]);
            }else{
                temp = new File(filePath + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                deleteFiles(filePath + "/" + tempList[i]);//先删除文件夹里面的文件
                delFolder(filePath + "/" + tempList[i]);//再删除空文件夹
            }
        }
    }


    public static void delFolder(String folderPath) {
        try {
            deleteFiles(folderPath); //删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            myFilePath.delete(); //删除空文件夹
        } catch (Exception e) {
            logger.error("Delete-FileFold-Exception |. filePath:{} ",folderPath, e);
        }
    }

    public static void fileUpload(byte[] file, String filePath, String fileName) throws IOException {

        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();

    }





    public static void main(String[] args) {

//      FileUtils.parseApkAndUpdateInfo("./package/1/231/Tuandai-debug.apk");
    }
}
