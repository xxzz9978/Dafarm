package kr.co.dafarm.service;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.dafarm.bean.UserInformationBean;
import kr.co.dafarm.bean.UserProductBean;
import kr.co.dafarm.dao.UserTradeDao;

@Service
public class UserTradeService {
	
	@Value("${path.upload}")
	private String path_upload;

	@Autowired
	private UserTradeDao userTradeDao;
	
	// 파일 저장 메서드
	private String saveUploadFile(MultipartFile upload_file) {

		// 경로 시스템 오류시
		String file_name = System.currentTimeMillis() + "_"
				+ FilenameUtils.getBaseName(upload_file.getOriginalFilename()) + "."
				+ FilenameUtils.getExtension(upload_file.getOriginalFilename());

		try {
			upload_file.transferTo(new File(path_upload + "/" + file_name));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return file_name;
	}
	
	public void addProductInfo(UserProductBean userProductBean) {
		 
		MultipartFile upload_file = userProductBean.getUpload_file();

		if (upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			System.out.println(file_name);
			userProductBean.setProduct_image(file_name);
		}
		userTradeDao.addProductInfo(userProductBean);
	}

	public List<UserProductBean> select_product_table() {
		return userTradeDao.select_product_table();
	}

	public UserProductBean select_one_product_table(int product_idx) {
		return userTradeDao.select_one_product_table(product_idx);
	}

	public List<UserInformationBean> trackingshipment(int user_num) {
		return userTradeDao.trackingshipment(user_num);
	}
	
}
