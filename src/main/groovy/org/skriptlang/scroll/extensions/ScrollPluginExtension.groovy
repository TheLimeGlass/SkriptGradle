package org.skriptlang.scroll.extensions

import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.provider.Property

interface ScrollPluginExtension extends JavaPluginExtension {

	/**
	 * The addon version.
	 * 
	 * @return String of the addon version.
	 */
	Property<String> getAddonVersion()

	/**
	 * Define the directory location of the addon's testing scripts (.sk)
	 * 
	 * @return String path of the directory location.
	 */
	Property<String> getScriptsPath()

	/**
	 * Define the compiled jar path including the name if you added a version tag to it etc.
	 * Scroll needs to know it's exact location and name aka the path.
	 * 
	 * @return String path of the jar location.
	 */
	Property<String> getAddonPath()

	/**
	 * The root directory Skript uses to grab runner data like the server.properties.
	 * This will default to src/test/resources/runner_data/
	 * 
	 * @return String path of the runner data directory.
	 */
	Property<String> getRunnerRoot()

	/**
	 * The addon name.
	 * 
	 * @return String of the addon name.
	 */
	Property<String> getAddonName()

	/**
	 * If the deployment should be in development mode, meaning sys input allowed.
	 * 
	 * @return Boolean stating if devMode should or not be enabled.
	 */
	Property<Boolean> getDevMode()

	/**
	 * The json file that defines all the details about the environment.
	 * 
	 * @return String the path to the environment json file.
	 */
	Property<String> getEnvironment()

	/**
	 * The java version string the test system should run on.
	 *
	 * @return String representing the JavaLanguageVersion.of(...) value.
	 */
	Property<String> getJavaVersion()

}
