package org.emoflon.ibex.gt.example;

import java.io.File;

import org.eclipse.emf.common.util.URI;

import gtproject.example.api.ExampleGtApi;
import gtproject.example.api.ExampleHiPEGtApi;

public class ExampleGtRunner {

	protected static String resourcePath = System.getProperty("user.dir") + "/resources/";

	public static void main(final String[] args) {
		// Create API
		final ExampleGtApi<?> api = new ExampleHiPEGtApi();

		// Load model
		final String path = resourcePath + "example.xmi";
		final File file = new File(path);
		if (file.exists()) {
			final URI resourceURI = URI.createFileURI(path);
			try {
				api.addModel(resourceURI);
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}

		// Initialize GT engine
		api.initializeEngine();

		// Update matches
		api.updateMatches();

		// Find matches
		System.out.println("Number of matches (Item): " + api.findItem().countMatches());
		System.out.println("Number of matches (Root): " + api.findRoot().countMatches());
		System.exit(0);
	}

}
