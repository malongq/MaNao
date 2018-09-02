package com.malong.manaomall.common.imageloader;

import android.graphics.Bitmap;

/**
 * Created by Malong
 * on 18/7/5.
 * BitmapLoadingListener--第三方
 */
public interface BitmapLoadingListener {

    void onSuccess(Bitmap b);

    void onError();
}
