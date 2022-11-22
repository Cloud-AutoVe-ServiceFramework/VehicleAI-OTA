package kr.re.etri.advcloud.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.etri.advcloud.mapper.AdvehicleSWMapper;
import kr.re.etri.advcloud.model.AdvehicleSWVO;
 
@Service
public class AdvehicleSWService {
	
	private static final Logger logger = LoggerFactory.getLogger(AdvehicleSWService.class);
	
	@Autowired
	AdvehicleSWMapper advehicleSWMapper;
	
	public List<AdvehicleSWVO> selectList(AdvehicleSWVO param) {
		try {
			return advehicleSWMapper.selectList(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public List<AdvehicleSWVO> selectDownloadList(AdvehicleSWVO param) {
		try {
			return advehicleSWMapper.selectDownloadList(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public AdvehicleSWVO selectDuplicateRow(AdvehicleSWVO param) {
		try {
			return advehicleSWMapper.selectDuplicateRow(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public AdvehicleSWVO selectById(int sw_serial) {
		try {
			return advehicleSWMapper.selectById(sw_serial);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public int insert(AdvehicleSWVO param) {
		logger.info(">>> AdvehicleSWService insert invoked...");
		logger.info(">>> param: {}", param);
		
		try {
			return advehicleSWMapper.insert(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public int update(AdvehicleSWVO param) {
		try {
			return advehicleSWMapper.update(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public int delete(AdvehicleSWVO param) {
		try {
			return advehicleSWMapper.delete(param);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
	
}
