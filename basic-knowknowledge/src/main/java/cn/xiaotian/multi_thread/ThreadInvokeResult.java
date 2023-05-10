package cn.xiaotian.multi_thread;

/**
 * @author xiaotian
 * @description 线程执行结果的获取:
 *                              Future；
 *                              FutureTask;
 *                              CompletionService；
 *                              CompletionFuture；
 *                              对比：https://blog.csdn.net/weixin_44337445/article/details/121712544
 *                              总结：使用CompletionFuture获取结果即可。(1)https://www.jianshu.com/p/6bac52527ca4
 *                                                                   (2)https://juejin.cn/post/6937284979994918948
 *
 *
 *
 *
 * @date 2023-04-26 11:01
 */
public class ThreadInvokeResult {

    //
    ///**
    // *  场景一：第一个场景是需要分别调用两个RPC接口，无先后顺序关系，数据处理是需要同时依赖两个接口的返回数据。
    // */
    //public List<String> findIdList(String subjectId,Integer classType) {
    //    CompletableFuture<java.util.List<String>> aIds = CompletableFuture
    //            .supplyAsync(() -> clientA.queryClassIdList("1", classType), TestThreadExecutor.getInstance());
    //
    //    CompletableFuture<List<String>> bIds = CompletableFuture
    //            .supplyAsync(() -> clientB.queryClassIdList("2", classType), TestThreadExecutor.getInstance());
    //
    //    CompletableFuture<List<String>> unionClassIds = aIds
    //            .thenCombineAsync(bIds, (aIds, bIds) -> {
    //                aIds.addAll(bIds);
    //                return aIds.stream().distinct().collect(Collectors.toList());
    //            }, TestThreadExecutor.getInstance());
    //
    //    return unionClassIds11
    //            .exceptionally(exception -> {
    //                System.out.println("出异常了");
    //                return List.of();
    //            })
    //            .join();
    //}
    //
    ///**
    // *  场景二：第二个场景是需要循环调用RPC接口，调用100次以内，所有调用结束后统一对返回结果进行处理。
    // */
    //public void fin () {
    //    List<String> res = new ArrayList<>();
    //    List<String> idList = ListS.of("1","2","3","4","5","6");
    //    CompletableFuture[] cfs = idList.stream().map(object-> CompletableFuture.supplyAsync(()->client.queryClassIdList(object, classType), TestThreadExecutor.getInstance())
    //            .thenApply(dtoList->{
    //                if(CollectionUtils.isEmpty(dtoList)){
    //                    return "";
    //                } else {
    //                    return claCourseId;
    //                }
    //            })
    //            //如需获取任务完成先后顺序，此处代码即可
    //            .whenComplete((v, e) ->
    //    if(!StringUtils.isEmpty(v)){
    //        bindClassCourseList.add(v);
    //    }
    //})).toArray(CompletableFuture[]::new);
    ////等待总任务完成，但是封装后无返回值，必须自己whenComplete()获取
    //          CompletableFuture.allOf(cfs).join();
    //}

}
