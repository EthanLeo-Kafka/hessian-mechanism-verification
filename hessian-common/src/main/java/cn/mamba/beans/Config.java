package cn.mamba.beans;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * @author yufei.liu
 */
@Data
@Builder
public class Config implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String name, value;
}
