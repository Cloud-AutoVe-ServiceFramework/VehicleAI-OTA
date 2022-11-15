package kr.re.etri.advcloud.common.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "props.common")
public class CommonConstant {

	private String baseFilePath;

	private String advehicleSwPath;

	/**
	 * @return the baseFilePath
	 */
	public String getBaseFilePath() {
		return baseFilePath;
	}

	/**
	 * @param baseFilePath the baseFilePath to set
	 */
	public void setBaseFilePath(String baseFilePath) {
		this.baseFilePath = baseFilePath;
	}


	/**
	 * @return the advehicleSwPath
	 */
	public String getAdvehicleSwPath() {
		return advehicleSwPath;
	}

	/**
	 * @param advehicleSwPath the advehicleSwPath to set
	 */
	public void setAdvehicleSwPath(String advehicleSwPath) {
		this.advehicleSwPath = advehicleSwPath;
	}

}
