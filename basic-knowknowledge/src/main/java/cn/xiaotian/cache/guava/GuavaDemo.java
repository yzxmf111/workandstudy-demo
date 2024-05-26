package cn.xiaotian.cache.guava;


/**
 * @author xiaotian
 * @description
 * @date 2022-09-20 16:23
 */
public class GuavaDemo {

    //private final LoadingCache<Long, BackCategory> backCategoryCache = CacheBuilder.newBuilder()
    //        //设置cache的初始大小为10，要合理设置该值
    //        .initialCapacity(10000)
    //        //设置并发数为5，即同一时间最多只能有5个线程往cache执行写入操作
    //        .concurrencyLevel(5)
    //        //最大key个数
    //        .maximumSize(100)
    //        //移除监听器
    //        .removalListener(removalListener)
    //        //设置cache中的数据在写入之后的存活时间为10秒
    //        .expireAfterWrite(10, TimeUnit.SECONDS)
    //        //构建cache实例
    //        .build(new CacheLoader<Long, BackCategory>() {
    //            @Override
    //            public BackCategory load(Long categoryId) throws Exception {
    //                Response<BackCategory> rBackCategory = backCategoryReadService.findById(categoryId);
    //                if (!rBackCategory.isSuccess()) {
    //                    log.warn("failed to find back category(id={}), error code:{}",
    //                            categoryId, rBackCategory.getError());
    //                    throw new ServiceException("find back category fail,code: " + rBackCategory.getError());
    //                }
    //                return rBackCategory.getResult();
    //            }
    //        });
    //
    //RemovalListener<String, String> removalListener = new RemovalListener<String, String>() {
    //    public void onRemoval(RemovalNotification<categoryId, BackCategory> removal) {
    //        System.out.println("[" + removal.getKey() + ":" + removal.getValue() + removal.getCause() +  "] is evicted!");
    //    }
    //};

}
