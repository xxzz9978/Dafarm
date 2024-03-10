package kr.co.dafarm.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.dafarm.bean.KamisAPIBean;

@Service
public class KamisAPIService {

	public KamisAPIBean getKamisAPIInfo() {
		final String URL = "https://www.kamis.or.kr/service/price/xml.do?action=dailySalesList&p_cert_key=fd8ed4ed-d3d4-4d16-9ba6-50bbaf31f085&p_cert_id=3917&p_returntype=json";

		RestTemplate restTemplate = new RestTemplate();

		try {
			String result = restTemplate.getForObject(URL, String.class);
			result = result.replaceAll("\\[]", "\"-\"");
			ObjectMapper objectMapper = new ObjectMapper();
			KamisAPIBean kamisApiBean = objectMapper.readValue(result, KamisAPIBean.class);
			return kamisApiBean;
		} catch (Exception e) {
			e.printStackTrace();
			return new KamisAPIBean();
		}
	}

}
