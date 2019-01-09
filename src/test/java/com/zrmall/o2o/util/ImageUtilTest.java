package com.zrmall.o2o.util;
/**
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.zrmall.o2o.BaseTest;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtilTest{
	public static void main(String[] args) throws IOException {
		String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		System.out.println(basePath);
		//指定文件大小
		Thumbnails.of("d://a.jpg").size(200, 200)
		//加入水印 0.25f是透明度  outputQuality(0.8f)是压缩比
				.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("d://watermark.jpg")), 0.25f)
				.outputQuality(0.8f).toFile("d://newa.jpg");
	}

}
*/
