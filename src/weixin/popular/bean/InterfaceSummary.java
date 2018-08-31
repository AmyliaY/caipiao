package weixin.popular.bean;

public class InterfaceSummary extends BaseResult{
	
	private String refDate;
	private String callbackCount;
	private String failCount;
	private String totalTimeCost;
	private String maxTimeCost;
	
	public String getRefDate() {
		return refDate;
	}
	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}
	public String getCallbackCount() {
		return callbackCount;
	}
	public void setCallbackCount(String callbackCount) {
		this.callbackCount = callbackCount;
	}
	public String getFailCount() {
		return failCount;
	}
	public void setFailCount(String failCount) {
		this.failCount = failCount;
	}
	public String getTotalTimeCost() {
		return totalTimeCost;
	}
	public void setTotalTimeCost(String totalTimeCost) {
		this.totalTimeCost = totalTimeCost;
	}
	public String getMaxTimeCost() {
		return maxTimeCost;
	}
	public void setMaxTimeCost(String maxTimeCost) {
		this.maxTimeCost = maxTimeCost;
	}

}
