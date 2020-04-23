package cordova.plugin.killapp;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.util.Log;


/**
 * This class echoes a string called from JavaScript.
 */
public class KillApp extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.i("KillApp","Execute");
        Log.i("KillApp", action);
        /*
         * Finishes the activity provided by CordovaInterface.
         */
        if (action.equals("kill")) {
            Log.i("KillApp", "Entrei aqui!!!");
            try {
                Activity activity = this.cordova.getActivity();
                activity.finishAndRemoveTask();
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
            } catch (Exception e) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, 1));
            }
            return true;
        }
        return false;
    }
}
