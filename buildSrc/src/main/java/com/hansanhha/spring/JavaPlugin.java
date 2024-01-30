package com.hansanhha.spring;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.jvm.toolchain.JavaLanguageVersion;

public class JavaPlugin implements Plugin<Project> {

    private static final String LOMBOK_CONFIGURATION_NAME = "compileOnly";

    @Override
    public void apply(Project project) {
        project.getPlugins().apply("java");

        project.getExtensions().configure(JavaPluginExtension.class, javaPlugin -> {
            javaPlugin.toolchain(spec -> spec.getLanguageVersion().set(JavaLanguageVersion.of(21)));
        });

        project.getDependencies().add(LOMBOK_CONFIGURATION_NAME, "org.projectlombok:lombok");
    }
}
