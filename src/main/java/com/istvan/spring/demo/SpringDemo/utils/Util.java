package com.istvan.spring.demo.SpringDemo.utils;

import com.istvan.spring.demo.SpringDemo.entity.Tour;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class Util {

    /** remote end poin to download tour inventory **/
    private final String REMOTE_URL = "https://s3-eu-west-1.amazonaws.com/pocketguide/_test/store_en.v2.gz";

    /**
     *  download all tours information from remote url.
     *  If key is mentioned to filter, then it will filter  the tours
     *  information based on the key. If key is null, then all of the
     *  tour information will be downloaded
     * @param key
     * @return
     */
    public List<Tour> downloadTourData(String key) throws Exception {
            URL url = new URL(REMOTE_URL);
            HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
            conn.setDoInput(true);
            InputStream is = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(is)));
            String line;
            StringBuilder sb = new StringBuilder();
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }

            if(reader != null) reader.close();

            JSONObject jsonObject = new JSONObject(sb.toString());
            JSONArray array = jsonObject.getJSONArray("tours");

            List<Tour> tours = new ArrayList<>();
            for(int i = 0; i<array.length(); i++) {
                JSONObject jsobj = array.getJSONObject(i);
                Tour tour = new Tour();

                if(jsobj.has("id")) {
                    tour.setCityId(jsobj.getLong("id"));
                }

                if(jsobj.has("name")) {
                    tour.setName(jsobj.getString("name"));
                }

                if(jsobj.has("shortDesc")) {
                    tour.setShortDesc(jsobj.getString("shortDesc"));
                }

                if(key == null)
                    tours.add(tour);
                else {
                    if(tour.getShortDesc().toLowerCase().contains(key.toLowerCase())) tours.add(tour);
                }
            }
            return tours;
            }
}
