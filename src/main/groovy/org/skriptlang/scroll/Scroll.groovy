package org.skriptlang.scroll

import org.gradle.api.Plugin
import org.gradle.api.Project

import org.skriptlang.scroll.tasks.AddonTest
import org.skriptlang.scroll.tasks.AddonTestJar
import org.skriptlang.scroll.tasks.MoveAddonTestJar

import org.skriptlang.scroll.ScrollBasePlugin
import org.skriptlang.scroll.extensions.ScrollPluginExtension

class Scroll implements Plugin<Project> {

	private static final String EXTENSION_NAME = 'scroll';

	@Override
    void apply(Project project) {
		project.plugins.apply(ScrollBasePlugin)

		ScrollPluginExtension extension = project.extensions.create(EXTENSION_NAME, ScrollPluginExtension, project)

		configureAddonTestTask(project, extension)
		configureAddonTestJarTask(project, extension)
		configureMoveAddonTestJarTask(project, extension)

		project.task('addonTest', type: AddonTest)
	}

	private void configureAddonTestTask(Project project, ScrollPluginExtension extension) {
		project.tasks.withType(AddonTest) {
			conventionMapping.map('skriptEnvironment') { extension.environment }
			conventionMapping.map('testScriptsPath') { extension.scriptsPath }
			conventionMapping.map('javaVersion') { extension.javaVersion }
			conventionMapping.map('runnerRoot') { extension.runnerRoot }
			conventionMapping.map('addonPath') { extension.addonPath }
			conventionMapping.map('devMode') { extension.devMode }
			conventionMapping.map('project') { project }
		}
	}

	private void configureAddonTestJarTask(Project project, ScrollPluginExtension extension) {
		project.tasks.withType(AddonTestjar) {
			conventionMapping.map('devMode') { extension.getDevMode() }
			conventionMapping.map('project') { project }
		}
	}

	private void configureMoveAddonTestJarTask(Project project, ScrollPluginExtension extension) {
		project.tasks.withType(MoveAddonTestJar) {
			conventionMapping.map('runnerRoot') { extension.getRunnerRoot() }
			conventionMapping.map('addonPath') { extension.getAddonPath() }
		}
	}

}
