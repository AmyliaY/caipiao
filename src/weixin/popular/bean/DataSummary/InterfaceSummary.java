package weixin.popular.bean.DataSummary;

import weixin.popular.bean.BaseResult;

public class InterfaceSummary extends BaseResult{
	
	SingleSummary[] list ;
	


	public SingleSummary[] getList() {
		return list;
	}



	public void setList(SingleSummary[] list) {
		this.list = list;
	}



	public static class SingleSummary{
	
	private String ref_date;
	private String callback_count;
	private String fail_count;
	private String total_time_cost;
	private String max_time_cost;
	
	public String getRef_date() {
		return ref_date;
	}
	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}


	public String getCallback_count() {
		return callback_count;
	}
	public void setCallback_count(String callback_count) {
		this.callback_count = callback_count;
	}
	public String getFail_count() {
		return fail_count;
	}
	public void setFail_count(String fail_count) {
		this.fail_count = fail_count;
	}
	public String getTotal_time_cost() {
		return total_time_cost;
	}
	public void setTotal_time_cost(String total_time_cost) {
		this.total_time_cost = total_time_cost;
	}
	public String getMax_time_cost() {
		return max_time_cost;
	}
	public void setMax_time_cost(String max_time_cost) {
		this.max_time_cost = max_time_cost;
	}
	}


}
