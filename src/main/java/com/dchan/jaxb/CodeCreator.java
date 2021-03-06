package com.dchan.jaxb;

import com.sun.codemodel.JAnnotationUse;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JPackage;
import com.sun.tools.xjc.outline.ClassOutline;
import com.sun.tools.xjc.outline.Outline;

import javax.annotation.Generated;
import java.util.Set;

abstract class CodeCreator {

    protected final JPackage jpackage;
    protected final Outline outline;
    private JDefinedClass output;

    CodeCreator(Outline outline, JPackage jPackage) {
        this.outline = outline;
        this.jpackage = jPackage;
    }

    protected abstract void run(Set<ClassOutline> classes, Set<JClass> directClasses);

    JDefinedClass getOutput() {
        return output;
    }
    
    void setOutput(JDefinedClass output) {
        JAnnotationUse annotationUse = output.annotate(Generated.class);
        annotationUse.param("value", "Generated by jaxb-visitor");
        this.output = output;
    }

    protected JPackage getPackage() {
        return jpackage;
    }

    protected Outline getOutline() {
        return outline;
    }
}
