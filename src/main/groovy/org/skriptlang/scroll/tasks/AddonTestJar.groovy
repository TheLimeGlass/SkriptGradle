package org.skriptlang.scroll.tasks

import org.gradle.api.Project
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

class AddonTestJar extends ShadowJar {

	/**
	 * The version of the addon.
	 */
	@Input
	String addonVersion

	/**
	 * The name of the addon.
	 */
	@Input
	String addonName

	@Input
	Project project

	@TaskAction
	public void start() {
		dependsOn(ShadowJar)
		archiveFileName = addonName + '-TestJar-' + addonVersion + '.jar'
		from sourceSets.test.output, sourceSets.main.output, project.configurations.testShadow
	}

}
