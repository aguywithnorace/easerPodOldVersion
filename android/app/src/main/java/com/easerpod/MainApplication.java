package com.easerpod;

import android.app.Application;
import io.invertase.firebase.auth.RNFirebaseAuthPackage;
import io.invertase.firebase.firestore.RNFirebaseFirestorePackage; // <-- Add this line
import com.airbnb.android.react.maps.MapsPackage;

import com.facebook.CallbackManager;
import com.facebook.react.ReactApplication;
import com.oblador.vectoricons.VectorIconsPackage;
import com.github.reactnativecommunity.location.RNLocationPackage;
import com.swmansion.gesturehandler.react.RNGestureHandlerPackage;
import com.airbnb.android.react.maps.MapsPackage;
import com.facebook.reactnative.androidsdk.FBSDKPackage;
import io.invertase.firebase.RNFirebasePackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private static CallbackManager mCallbackManager = CallbackManager.Factory.create();

  protected static CallbackManager getCallbackManager() {
    return mCallbackManager;
  }

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
            new VectorIconsPackage(),
            new RNLocationPackage(),
            new RNGestureHandlerPackage(),
            new MapsPackage(),
            new FBSDKPackage(mCallbackManager),
            new RNFirebasePackage(),
              new RNFirebaseAuthPackage(),
              new RNFirebaseFirestorePackage()


      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
  }
}
