package com.example.demo;

import com.example.demo.async.TaskOfAsync;
import com.example.demo.async.TaskOfSync;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TaskTest {

    private final static Logger logger = LoggerFactory.getLogger(TaskTest.class);

    @Autowired
    private TaskOfSync taskOfSync;
    @Autowired
    private TaskOfAsync taskOfAsync;


    @Test
    public void test() throws Exception{

        taskOfSync.doTaskOne();
        taskOfSync.doTaskTwo();
        taskOfSync.doTaskThree();
    }

    @Test
    public void testForAsync() throws InterruptedException {
        long start = System.currentTimeMillis();

        taskOfAsync.doTask();
        Future<String> task1 = taskOfAsync.doTaskOne();
        Future<String> task2 = taskOfAsync.doTaskTwo();
        Future<String> task3 = taskOfAsync.doTaskThree();
        for(;;) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                break;
            }
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();
        System.out.println("任务完成，总耗时" + (end - start) +" 毫秒");
    }
}
