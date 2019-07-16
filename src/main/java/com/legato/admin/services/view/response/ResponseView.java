/**
 * 
 */
package com.legato.admin.services.view.response;

/**
 * @author af83580
 *
 */
public class ResponseView<T> {
	private int statusCode;
	private String statusDescription;
	private T data;
	private long total;

	public ResponseView() {
		// Auto-generated constructor stub
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}