package com.udacity.gradle.builditbigger;


import android.test.AndroidTestCase;
import android.text.TextUtils;

/**
 * Created by Robert Mathew on 23/4/16.
 */
public class BackendTest extends AndroidTestCase {

    public void testVerifyBackendResult() throws Throwable {
        new GetGcmJokeTest().execute();
    }


    private class GetGcmJokeTest extends EndpointsAsyncTask {
        @Override
        protected void onPostExecute(String result) {
            assertTrue(result, result.length() > 0);
            assertFalse(TextUtils.isEmpty(result));
        }
    }
}
