package org.skriptlang.scroll.tasks

import org.gradle.api.Project
import org.gradle.api.file.FileCollection
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.JavaExec
import org.gradle.api.tasks.TaskAction

import org.skriptlang.scroll.tasks.MoveAddonTestJar

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

class AddonTest extends JavaExec {

	/**
	 * If the deployment should be in development mode, meaning sys input allowed.
	 */
	@Input
	boolean devMode = false

	@Input
	String addonPath

	@Input
	String testScriptsPath

	@Input
	String runnerRoot

	@Input
	String skriptEnvironment

	@Input
	String skriptJavaVersion

	@TaskAction
	public void start() {
		dependsOn MoveAddonTestJar, ShadowJar
		this.javaLauncher = javaToolchains.launcherFor {
			languageVersion = JavaLanguageVersion.of(skriptJavaVersion)
		}
		if (devMode)
			standardInput = System.in

		group = 'execution'
		classpath = files([
			addonPath,
			project.configurations.runtimeClasspath.find { it.name.startsWith('gson') },
			sourceSets.main.runtimeClasspath
		])
		main = 'ch.njol.skript.tests.platform.PlatformMain'
		args = [
			'build/test_runners',
			testScriptsPath,
			runnerRoot,
			skriptEnvironment,
			devMode,
			false
		]
	}

}
