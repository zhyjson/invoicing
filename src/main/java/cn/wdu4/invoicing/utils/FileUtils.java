package cn.wdu4.invoicing.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.Instant;

import static cn.wdu4.invoicing.utils.Dictionary.*;

/**
 * @ClassName FileUtils
 * @Description TODO 文件储存
 * @Auther zhy
 * @Date 2019/4/8 0008 20:19
 * @Version 1.0
 **/
public class FileUtils {

    public static String fileStorage( MultipartFile file) {
        try {
            if (file.isEmpty()) {
                // 文件为空
                return BLANK;
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf(POINT));
            // 设置文件存储路径
            String filePath = EMP_FACE_URL_PREFIX;
            // 设置文件新路径
            String path = filePath+ Instant.now().toEpochMilli() + suffixName;
            File dest = new File(FileUtils.class.getClassLoader().getResource(BLANK).getPath()+PATH+path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入
            // 上传成功
            return path;
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        // 上传失败
        return BLANK;
    }
}
