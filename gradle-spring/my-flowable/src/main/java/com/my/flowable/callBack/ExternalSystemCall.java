package com.my.flowable.callBack;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * @author kevin
 * @ClassName ExternalSystemCall.java
 * @Description TODO
 * @createTime 2020年11月23日 13:50:00
 */
public class ExternalSystemCall implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("call ExternalSystemCall for empolyee:"+execution.getVariable("employee"));
    }
}
