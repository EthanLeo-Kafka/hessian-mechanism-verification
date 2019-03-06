package cn.mamba.services;

import cn.mamba.beans.Config;
import cn.mamba.beans.ResultBean;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 实现最简单的的config操作d
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    private final ConcurrentSkipListMap<Long, Config> configs = new ConcurrentSkipListMap<>();

    private static final AtomicLong ID_SEQUENCE = new AtomicLong(1000L);

    @Override
    public ResultBean<Long> addConfig(Config config) {
        System.out.println("addConfig：" + config);

        long id = ID_SEQUENCE.incrementAndGet();

        config.setId(id);
        configs.put(id, config);

        return new ResultBean<>(id);
    }

    @Override
    public ResultBean<Collection<Config>> getAll() {
        System.out.println("GetAll：=======打印一个日志，后面会用到========");
        return new ResultBean<>(configs.values());
    }

    @Override
    public ResultBean<Boolean> delete(long id) {
        System.out.println("Delete：" + id);
        return new ResultBean<>(configs.remove(id) != null);
    }

}
