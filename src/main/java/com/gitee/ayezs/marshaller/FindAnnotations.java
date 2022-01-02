package com.gitee.ayezs.marshaller;

import com.gitee.ayezs.annotation.wrapper.WrapperAnnotation;

import java.lang.annotation.Annotation;


public class FindAnnotations {
    Annotation start;
    WrapperAnnotation end;

    public Annotation getStart() {
        return start;
    }

    public void setStart(Annotation start) {
        this.start = start;
    }

    public WrapperAnnotation getEnd() {
        return end;
    }

    public void setEnd(WrapperAnnotation end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "FindAnnotations{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
