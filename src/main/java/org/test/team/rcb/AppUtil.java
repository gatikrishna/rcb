package org.test.team.rcb;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class AppUtil {
	public static int getCount(String key, String value) {
		int count = 0;
		try {
			JSONObject jsonObject = new JSONObject(readJson());
			JSONArray playerArray = jsonObject.getJSONArray("player");
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("count", 0);
			for (int i = 0; i < playerArray.length(); i++) {
				String mathcher = playerArray.getJSONObject(i).get(key).toString();
				if (!mathcher.equalsIgnoreCase(value) && key.equalsIgnoreCase("country")) {
					map.put("count", map.get("count") + 1);
				}
				if ((mathcher.equalsIgnoreCase(value) || mathcher.equalsIgnoreCase("All-Rounder"))
						&& key.equalsIgnoreCase("role")) {
					map.put("count", map.get("count") + 1);
				}
			}
			count = map.get("count");
			System.out.println("count of " + key + " : " + count);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return count;
		}
	}

	public static int getWicketKeeperCount() {
		return getCount("role", "Wicket-keeper");
	}

	public static int getForeignPlayerCount() {
		return getCount("country", "india");
	}

	public static String readJson() {
		try {
			URL file = Resources.getResource("resources/Team_RCB.txt");
			String jsonString = Resources.toString(file, Charsets.UTF_8);
			System.out.println("file" + jsonString);
			return jsonString;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

}
