package thoughtworks.problems.utils;

import java.text.MessageFormat;
import java.util.*;

/**
 * Read app properties
 * 
 * @author tbansal
 *
 */
public class PropertiesUtil {
	private static final Map<String, String> properties = new HashMap<String, String>();

	static {
		loadProperties();
	}

	/**
	 * Load properties from file.
	 */
	private static void loadProperties() {
		try {
			properties.clear();

			Locale defaultLocale = Locale.getDefault();
			ResourceBundle props = ResourceBundle.getBundle("thoughtworks.messages.exceptions", defaultLocale);

			for (Object key : props.keySet()) {
				String keyStr = key.toString();
				properties.put(keyStr, props.getString(keyStr));
			}

		} catch (MissingResourceException e) {
			throw new IllegalArgumentException("Properties not found");
		}
	}

	public static Map<String, String> getProperties() {
		return properties;
	}

	/**
	 * 
	 * Return parsed value fo give property
	 * 
	 * @param key
	 * @param arguments
	 * @return
	 */
	public static String getProperty(String key, String... arguments) {
		String value = getProperties().get(key);

		if (value == null) {
			throw new IllegalArgumentException(String.format("Property %1s not found", key));
		}

		MessageFormat formatter = new MessageFormat("");
		formatter.applyPattern(value);
		String output = formatter.format(arguments);
		return output;
	}

}
