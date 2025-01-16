package com.ihome.util;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.opencv.imgcodecs.Imgcodecs.imwrite;


public class ExtractFrame {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public String extractImage(MultipartFile image) {
        if (image.isEmpty()) {
            System.out.println("图片文件为空");
        }
        String uploadDir = "E:/uploads/";
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs(); // 创建目录
        }
        String filePath = uploadDir + image.getOriginalFilename();
        try {
            image.transferTo(new File(filePath)); // 保存视频
            System.out.println("图片保存路径：" + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("图片保存失败");
        }
        return filePath;
    }

    public List<String> extractFrame(MultipartFile video) {
        //保存视频为文件
        if (video.isEmpty()) {
            System.out.println("视频文件为空");
        }
        String uploadDir = "E:/uploads/";
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs(); // 创建目录
        }
        String filePath = uploadDir + video.getOriginalFilename();
        try {
            video.transferTo(new File(filePath)); // 保存视频
            System.out.println("视频保存路径：" + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("视频保存失败");
        }

        //提取视频帧
        VideoCapture capture = new VideoCapture(filePath);
        if (!capture.isOpened()) {
            System.out.println("无法打开视频文件！");
            return null;
        }

        // 循环读取每一帧
        Mat frame = new Mat();
        int frameIndex=0;
        List<String> imageNameList = new ArrayList<>();
        while (capture.read(frame)) {
            if (frame.empty()) {
                break; // 如果无法读取帧，退出循环
            }

            // 转换Mat对象为byte数组并处理帧
            String fileName = String.format("E:/uploads/face1_%05d.png", frameIndex++);
            imwrite(fileName, frame);
            imageNameList.add(fileName);
        }
        capture.release();

        return imageNameList;
    }
}
