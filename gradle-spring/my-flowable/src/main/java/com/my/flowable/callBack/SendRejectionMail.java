package com.my.flowable.callBack;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

/**
 * @author kevin
 * @ClassName SendRejectionMail.java
 * @Description TODO
 * @createTime 2020年11月23日 13:52:00
 */
public class SendRejectionMail implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("send reject resone 2 employee【"+execution.getVariable("employee")+"】");
    }
}
