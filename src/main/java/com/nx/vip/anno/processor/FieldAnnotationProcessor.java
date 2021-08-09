package com.nx.vip.anno.processor;

import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

/**
 * 自定义注解处理器
 *
 * @author SUN Katus
 * @version 1.0, 2021-08-09
 */
@AutoService(Processor.class)   // 使用google自动注册到mete-info下
public class FieldAnnotationProcessor extends AbstractProcessor {
    private StringBuilder sb = new StringBuilder();
    private int count;

    /**
     * 将类信息持久化到硬盘 (疑问: 当前并非每次都能生效)
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> elementSet = roundEnv.getElementsAnnotatedWith(FieldAnnotation.class);
        for (Element element : elementSet) {
            // 由于该注解处理器是处理FieldAnnotation注解的，而FieldAnnotation注解只添加在filed
            VariableElement varField = (VariableElement) element;
            TypeElement enclosingElement = (TypeElement) varField.getEnclosingElement();   // 父元素是一个类
            String className = enclosingElement.getQualifiedName().toString();
            Name fieldName = varField.getSimpleName();

            // 拼接类和属性名
            sb.append("className = ").append(className).append("\nfiledName = ").append(fieldName).append("\t");

            // 拼接属性上的注解
            FieldAnnotation anno = varField.getAnnotation(FieldAnnotation.class);
            sb.append("annotationValue = ").append(anno.value());

            count++;
            sb.append("\ncount = ").append(count).append("\n");
        }
        generateFile(sb.toString());
        return false;
    }

    /**
     * 可以使用@SupportedAnnotationTypes("com.nx.vip.anno.processor.FieldAnnotation")替代
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(FieldAnnotation.class.getCanonicalName());
    }

    /**
     * 可以使用@SupportedSourceVersion(SourceVersion.RELEASE_8)替代
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    private void generateFile(String str) {
        FileWriter fileWriter = null;
        try {
            File file = new File("D:\\Data\\info");
            if (!file.exists()) {
                file.createNewFile();
            }
            fileWriter = new FileWriter(file);
            fileWriter.append(str);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
