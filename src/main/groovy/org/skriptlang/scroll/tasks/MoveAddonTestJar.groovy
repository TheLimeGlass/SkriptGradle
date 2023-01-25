package org.skriptlang.scroll.tasks;

import org.gradle.api.Project;
import org.gradle.api.internal.ConventionTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

public class MoveAddonTestJar extends ConventionTask {

	@Input
	Project project;

	@Input
	String addonPath;

	@Input
	String runnerRoot;

	@Input
	String addonName;

	@TaskAction
	public void start() {
		dependsOn AddonTestJar;
		doLast {
			copy {
				from addonPath
				into runnerRoot
				rename('*.jar', addonName + '.jar')
			}
		}
	}

}
