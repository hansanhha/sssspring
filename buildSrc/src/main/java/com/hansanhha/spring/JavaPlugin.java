package com.hansanhha.spring;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.jvm.toolchain.JavaLanguageVersion;

public class JavaPlugin implements Plugin<Project> {

    private static final String COMPILE_ONLY = "compileOnly";
    private static final String ANNOTATION_PROCESSOR = "annotationProcessor";
    private static final String LOMBOK = "org.projectlombok:lombok";

    @Override
    public void apply(Project project) {
        project.getPlugins().apply("java");

        project.getExtensions().configure(JavaPluginExtension.class, javaPlugin -> {
            javaPlugin.toolchain(spec -> spec.getLanguageVersion().set(JavaLanguageVersion.of(21)));
        });

        project.getDependencies().add(COMPILE_ONLY, LOMBOK);
        project.getDependencies().add(ANNOTATION_PROCESSOR, LOMBOK);
    }
}
