package cn.mamba.services;

import java.util.Collection;

import cn.mamba.beans.Config;
import cn.mamba.beans.ResultBean;

/**
 * 定义config的操作接口
 */
public interface ConfigService {
	ResultBean<Long> addConfig(Config config);
	ResultBean<Collection<Config>> getAll();
	ResultBean<Boolean> delete(long id);
}
