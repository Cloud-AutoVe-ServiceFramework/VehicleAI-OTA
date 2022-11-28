package kr.re.etri.advcloud.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.etri.advcloud.mapper.AdvehicleInfoMapper;
import kr.re.etri.advcloud.model.AdvehicleInfoVO;


@Service
public class AdvehicleInfoService {
	
	private static final Logger logger = LoggerFactory.getLogger(AdvehicleInfoService.class);
	
	@Autowired
	AdvehicleInfoMapper advehicleInfoMapper;

	public List<AdvehicleInfoVO> selectList(AdvehicleInfoVO param) {
		try {
			return advehicleInfoMapper.selectList(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	public AdvehicleInfoVO select(String advehicle_id) {
		try {
			return advehicleInfoMapper.select(advehicle_id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	public int insert(AdvehicleInfoVO param) {
		try {
			return advehicleInfoMapper.insert(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	public int update(String advehicle_id, AdvehicleInfoVO param) {
		try {
			param.setAdvehicle_id(advehicle_id);
			return advehicleInfoMapper.update(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	public int delete(String advehicle_id) {
		try {
			return advehicleInfoMapper.delete(advehicle_id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

}
