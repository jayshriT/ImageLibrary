package com.example.jayshri.imagelibrary.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NetworkUtils {
    private List<String> imageUrls;
    private static final String TAG = NetworkUtils.class.getSimpleName();
    private static final String BASE_URL = "https://gamedata.britishcouncil.org/sites/default/files/attachment/";


    // Assuming this list will be returned by An API
    // As for now, created a dummy list
    public List<String> getImageUrlList() {
        imageUrls = new ArrayList<>();
        imageUrls.add(BASE_URL+"number-1_1.jpg");
        imageUrls.add(BASE_URL+"number-2_1.jpg");
        imageUrls.add(BASE_URL+"number-3_1.jpg");
        imageUrls.add(BASE_URL+"number-4_1.jpg");
        imageUrls.add(BASE_URL+"number-5_1.jpg");
        imageUrls.add(BASE_URL+"number-6_1.jpg");
        imageUrls.add(BASE_URL+"number-7_0.jpg");
        imageUrls.add(BASE_URL+"number-8_1.jpg");
        imageUrls.add(BASE_URL+"number-9_1.jpg");
        return imageUrls;
    }


}
