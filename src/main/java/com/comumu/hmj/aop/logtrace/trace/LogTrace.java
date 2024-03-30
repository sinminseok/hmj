package com.comumu.hmj.aop.logtrace.trace;


import com.comumu.hmj.aop.logtrace.model.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);

}
