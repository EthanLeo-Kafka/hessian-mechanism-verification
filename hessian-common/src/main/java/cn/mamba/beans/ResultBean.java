package cn.mamba.beans;

import java.io.Serializable;

import lombok.Data;

/**
 * @author yufei.liu
 */
@Data
public class ResultBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int code;
	private String msg = "success";
	private T data;
	public ResultBean() {
		super();
	}
	public ResultBean(T data) {
		super();
		this.data = data;
	}
}