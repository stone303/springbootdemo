package com.example.springbootdemo.service;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/***
 *
 * @PerfTest 注解：
 *
 * invocations：执行次数 n，与线程数量无关，默认值为 1
 *
 * threads：线程池数量 n，并发执行 n 个线程
 *
 * duration：重复地执行时间 n，测试至少执行 n 毫秒
 *
 *
 * @Required 注解：
 *
 * @Required(throughput = 20)：要求每秒至少执行 20 个测试；
 *
 * @Required(average = 50)：要求平均执行时间不超过 50ms；
 *
 * @Required(median = 45)：要求所有执行的 50%不超过 45ms；
 *
 * @Required(max = 2000)：要求没有测试超过 2s；
 *
 * @Required(totalTime = 5000)：要求总的执行时间不超过 5s；
 *
 * @Required(percentile90 = 3000)：要求 90%的测试不超过 3s；
 *
 * @Required(percentile95 = 5000)：要求 95%的测试不超过 5s；
 *
 * @Required(percentile99 = 10000)：要求 99%的测试不超过 10s;
 *
 * @Required(percentiles = “66:200,96:500”)：要求 66%的测试不超过 200ms，96%的测试不超过 500ms。
 */
@RunWith(SpringRunner.class)
@SpringBootTest //SpringBootTest 是springboot 用于测试的注解，可指定启动类或者测试环境等，这里直接默认。
public class UnitTestServiceTest {
    @Autowired
    UnitTestService testService;

    // 引入 ContiPerf 进行性能测试
    @Rule
    public ContiPerfRule contiPerfRule = new ContiPerfRule();

    @Test
    @PerfTest(invocations = 10000,threads = 100) //100个线程 执行10000次
    public void test() {
        String msg = "this is a test";
        String result = testService.process(msg);
        //断言 是否和预期一致
        Assert.assertEquals(msg,result);
    }
}