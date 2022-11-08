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
	
	public List<AdvehicleSWVO> selectList(AdvehicleSWVO param) throws Exception {
		return advehicleSWMapper.selectList(param);
	}
	
	public List<AdvehicleSWVO> selectDownloadList(AdvehicleSWVO param) throws Exception {
		return advehicleSWMapper.selectDownloadList(param);
	}
	
	public AdvehicleSWVO selectDuplicateRow(AdvehicleSWVO param) throws Exception {
		return advehicleSWMapper.selectDuplicateRow(param);
	}
	
	public AdvehicleSWVO selectById(int sw_serial) throws Exception {
		return advehicleSWMapper.selectById(sw_serial);
	}
	
	public int insert(AdvehicleSWVO param) throws Exception {
		logger.info(">>> AdvehicleSWService insert invoked...");
		logger.info(">>> param: {}", param);
		
		return advehicleSWMapper.insert(param);
	}
	
	public int update(AdvehicleSWVO param) throws Exception {
		return advehicleSWMapper.update(param);
	}
	
	public int delete(AdvehicleSWVO param) throws Exception {
		return advehicleSWMapper.delete(param);
	}
	
}
