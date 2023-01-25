package org.skriptlang.scroll

import org.gradle.api.Plugin
import org.gradle.api.Project

class ScrollBasePlugin implements Plugin<Project> {

	private static final String CONFIGURATION_NAME = 'scroll';
	//private static final String SCROLL_VERSION = '@version@';

	@Override
    void apply(Project project) {
		project.configurations.create(CONFIGURATION_NAME)
				.setVisible(false)
				.setTransitive(true)
				.setDescription('The scroll configurations to be used for this project.');
	}

	// TODO add Skript as a dependency if it's not already.

}
